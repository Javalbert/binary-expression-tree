/*
   Copyright 2018 Albert Shun-Dat Chan

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

 */
package com.javalbert.biexprtree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.text.StringEscapeUtils;

public class ExpressionParser {
	private static final Set<String> DEFAULT_OPERATORS;
	static {
		Set<String> defaultOperators = new HashSet<>();
		defaultOperators.add(Operators.ADD.getOperator());
		defaultOperators.add(Operators.SUBTRACT.getOperator());
		defaultOperators.add(Operators.MULTIPLY.getOperator());
		defaultOperators.add(Operators.DIVIDE.getOperator());
		defaultOperators.add(Operators.MODULO.getOperator());
		defaultOperators.add(Operators.POWER.getOperator());
		defaultOperators.add(Operators.NEGATE.getOperator());
		defaultOperators.add(Operators.EQ.getOperator());
		defaultOperators.add(Operators.NOTEQ.getOperator());
		defaultOperators.add(Operators.LT.getOperator());
		defaultOperators.add(Operators.LTEQ.getOperator());
		defaultOperators.add(Operators.GT.getOperator());
		defaultOperators.add(Operators.GTEQ.getOperator());
		defaultOperators.add(Operators.AND.getOperator());
		defaultOperators.add(Operators.OR.getOperator());
		defaultOperators.add(Operators.NOT.getOperator());
		DEFAULT_OPERATORS = Collections.unmodifiableSet(defaultOperators);
	}
	
	private Set<String> operators = DEFAULT_OPERATORS;
	private final Map<String, Variable> variables = new HashMap<>();
	
	// processing
	//
	private List<String> tokens;
	private Iterator<String> tokenIterator;
	private String currentToken;
	private String previousToken;
	private Expression expression;
	
	public Set<String> getOperators() {
		return Collections.unmodifiableSet(operators);
	}
	
	public Map<String, Variable> getVariables() {
		return Collections.unmodifiableMap(variables);
	}
	
	public boolean addOperator(String operator) {
		initOperators();
		return operators.add(Functions.validateOperator(operator));
	}
	
	public Variable addVariable(Variable variable) {
		Objects.requireNonNull(variable, "variable must not be null");
		return variables.put(variable.getName(), variable);
	}
	
	public Expression parse(String exprString) {
		Objects.requireNonNull(exprString, "exprString must not be null");
		tokens = createTokens(exprString);
		expression = new Expression();
		
		buildExpression();
		
		Expression expr = expression;
		cleanUp();
		return expr;
	}
	
	public boolean removeOperator(String operator) {
		initOperators();
		return operators.remove(operator);
	}
	
	public Variable removeVariable(String name) {
		return variables.remove(name);
	}
	
	private void addNumber(Number number) {
		if (number instanceof Integer) {
			expression.val((int) number);
		} else if (number instanceof Float) {
			expression.val((float) number);
		} else if (number instanceof Long) {
			expression.val((long) number);
		} else if (number instanceof Double) {
			expression.val((double) number);
		} else {
			expression.val(number, (Class<Number>)number.getClass());
		}
	}
	
	private boolean appendTokenWithinQuotes(StringBuilder str) {
		if (currentToken.equals("\"")) {
			return false;
		}
		
		str.append(StringEscapeUtils.unescapeJava(currentToken));
		return true;
	}
	
	private void buildExpression() {
		tokenIterator = tokens.iterator();
		
		while (nextToken()
				&& (handleWhiteSpace()
				|| handleOperator()
				|| handleOperand()
				|| throwInvalidTokenError())) {
			;
		}
	}
	
	private void cleanUp() {
		tokens = null;
		tokenIterator = null;
		currentToken = null;
		expression = null;
	}
	
	private List<String> createTokens(String exprString) {
		List<String> tokens = new ArrayList<>();
		
		Matcher matcher = getTokenPattern().matcher(exprString);
		int beginIndex = 0;
		
		while (matcher.find()) {
			String beforeToken = exprString.substring(beginIndex, matcher.start());
			if (!beforeToken.isEmpty()) {
				tokens.add(beforeToken);
			}
			
			String token = exprString.substring(matcher.start(), matcher.end());
			tokens.add(token);
			
			beginIndex = matcher.end();
		}
		
		String lastToken = exprString.substring(beginIndex);
		if (!lastToken.isEmpty()) {
			tokens.add(lastToken);
		}
		
		return Collections.unmodifiableList(tokens);
	}
	
	private Pattern getTokenPattern() {
		StringBuilder regex = new StringBuilder(
				"([0-9]+\\.*[0-9]*(E\\d+)*)|\\w+|\\s+|\"|\\\\\"|\\(|\\)"
				); // ([0-9]+\.*[0-9]*(E\d+)*)|\w+|\s+|"|\\"|\(|\)
		
		List<String> operatorList = new ArrayList<>(operators);
		// sort to put more specific operators first
		// e.g. not equal (!=) before logical NOT (!)
		// otherwise != token will never appear
		operatorList.sort((a, b) -> {
			if (a.startsWith(b)) {
				return -1;
			} else if (b.startsWith(a)) {
				return 1;
			}
			return a.compareTo(b);
		});
		
		operatorList.stream()
		.map(op -> "|" + escapeRegexText(op))
		.forEach(regex::append);
		return Pattern.compile(regex.toString());
	}
	
	private static String escapeRegexText(String str) {
		StringBuilder builder = new StringBuilder();
		
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			
			switch (c) {
				case '.':
				case '\\':
				case '+':
				case '*':
				case '?':
				case '^':
				case '$':
				case '[':
				case ']':
				case '(':
				case ')':
				case '|':
				case '/':
					builder.append("\\");
					break;
			}
			builder.append(c);
		}
		return builder.toString();
	}
	
	private boolean handleOperand() {
		if (handleString()) {
			return true;
		}
		
		try {
			addNumber(NumberUtils.createNumber(currentToken));
			return true;
		} catch (NumberFormatException e) {
		}
		
		return false;
	}
	
	private boolean handleOperator() {
		if (!operators.contains(currentToken)) {
			return false;
		}
		
		switch (currentToken) {
			case "+": expression.plus(); break;
			case "-":
				if (operators.contains(previousToken)) {
					expression.negate();
				} else {
					expression.minus();
				}
				break;
			case "*": expression.times(); break;
			case "/": expression.dividedBy(); break;
			case "%": expression.modulo(); break;
			case "**": expression.powerOf(); break;
			case "=": expression.eq(); break;
			case "!=": expression.noteq(); break;
			case "<": expression.lt(); break;
			case "<=": expression.lteq(); break;
			case ">": expression.gt(); break;
			case ">=": expression.gteq(); break;
			case "!": expression.not(); break;
			default:
//				expression.binaryOp(op);
//				expression.unaryOp(op);
				break;
		}
		
		return true;
	}
	
	private boolean handleString() {
		if (!currentToken.equals("\"")) {
			return false;
		}
		nextToken();

		StringBuilder strWithinQuotes = new StringBuilder();
		while (appendTokenWithinQuotes(strWithinQuotes) && nextToken()) {
			;
		}
		expression.val(strWithinQuotes.toString());
		
		return true;
	}
	
	private boolean handleWhiteSpace() {
		return currentToken.trim().isEmpty();
	}
	
	private void initOperators() {
		if (operators == DEFAULT_OPERATORS) {
			operators = new HashSet<>(DEFAULT_OPERATORS);
		}
	}
	
	private boolean nextToken() {
		if (tokenIterator.hasNext()) {
			if (currentToken != null && !currentToken.trim().isEmpty()) {
				previousToken = currentToken;
			}
			
			currentToken = tokenIterator.next();
			return true;
		}
		return false;
	}
	
	private boolean throwInvalidTokenError() {
		throw new IllegalArgumentException("Invalid token: " + currentToken);
	}
}
