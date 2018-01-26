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
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.text.StringEscapeUtils;

import static java.util.stream.Collectors.*;

public class ExpressionParser {
	private static final Map<String, BinaryOperatorDefinition> DEFAULT_BINARY_OPERATORS;
	private static final Map<String, UnaryOperatorDefinition> DEFAULT_UNARY_OPERATORS;
	
	static {
		Map<String, BinaryOperatorDefinition> binaryOperators = new HashMap<>();
		binaryOperators.put(Operators.ADD.getOperator(), Operators.ADD);
		binaryOperators.put(Operators.SUBTRACT.getOperator(), Operators.SUBTRACT);
		binaryOperators.put(Operators.MULTIPLY.getOperator(), Operators.MULTIPLY);
		binaryOperators.put(Operators.DIVIDE.getOperator(), Operators.DIVIDE);
		binaryOperators.put(Operators.MODULO.getOperator(), Operators.MODULO);
		binaryOperators.put(Operators.POWER.getOperator(), Operators.POWER);
		binaryOperators.put(Operators.EQ.getOperator(), Operators.EQ);
		binaryOperators.put(Operators.NOTEQ.getOperator(), Operators.NOTEQ);
		binaryOperators.put(Operators.LT.getOperator(), Operators.LT);
		binaryOperators.put(Operators.LTEQ.getOperator(), Operators.LTEQ);
		binaryOperators.put(Operators.GT.getOperator(), Operators.GT);
		binaryOperators.put(Operators.GTEQ.getOperator(), Operators.GTEQ);
		binaryOperators.put(Operators.AND.getOperator(), Operators.AND);
		binaryOperators.put(Operators.OR.getOperator(), Operators.OR);
		DEFAULT_BINARY_OPERATORS = Collections.unmodifiableMap(binaryOperators);

		Map<String, UnaryOperatorDefinition> unaryOperators = new HashMap<>();
		unaryOperators.put(Operators.NEGATE.getOperator(), Operators.NEGATE);
		unaryOperators.put(Operators.NOT.getOperator(), Operators.NOT);
		DEFAULT_UNARY_OPERATORS = Collections.unmodifiableMap(unaryOperators);
	}
	
	private Map<String, BinaryOperatorDefinition> binaryOperators = DEFAULT_BINARY_OPERATORS;
	private Map<String, UnaryOperatorDefinition> unaryOperators = DEFAULT_UNARY_OPERATORS;
	private final Map<String, Variable> variables = new HashMap<>();
	
	// processing
	//
	private List<String> tokens;
	private Iterator<String> tokenIterator;
	private String currentToken;
	private String previousToken;
	private Expression expression;
	
	public Map<String, BinaryOperatorDefinition> getBinaryOperators() {
		return Collections.unmodifiableMap(binaryOperators);
	}
	
	public Map<String, UnaryOperatorDefinition> getUnaryOperators() {
		return Collections.unmodifiableMap(unaryOperators);
	}
	
	public Map<String, Variable> getVariables() {
		return Collections.unmodifiableMap(variables);
	}
	
	public BinaryOperatorDefinition addBinaryOperator(BinaryOperatorDefinition binaryOperator) {
		initBinaryOperators();
		return binaryOperators.put(binaryOperator.getOperator(), binaryOperator);
	}
	
	public UnaryOperatorDefinition addUnaryOperator(UnaryOperatorDefinition unaryOperator) {
		initUnaryOperators();
		return unaryOperators.put(unaryOperator.getOperator(), unaryOperator);
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
	
	public BinaryOperatorDefinition removeBinaryOperator(String operator) {
		initBinaryOperators();
		return binaryOperators.remove(operator);
	}
	
	public UnaryOperatorDefinition removeUnaryOperator(String operator) {
		initUnaryOperators();
		return unaryOperators.remove(operator);
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
				|| handleVariable()
				|| throwInvalidTokenError())) {
			;
		}
	}
	
	private void cleanUp() {
		tokens = null;
		tokenIterator = null;
		currentToken = null;
		previousToken = null;
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
		
		List<String> operatorList = new ArrayList<>();
		operatorList.addAll(binaryOperators.values()
				.stream()
				.map(BinaryOperatorDefinition::getOperator)
				.collect(toList()));
		operatorList.addAll(unaryOperators.values()
				.stream()
				.map(UnaryOperatorDefinition::getOperator)
				.collect(toList()));
		
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
		if (!binaryOperators.containsKey(currentToken)
				&& !unaryOperators.containsKey(currentToken)) {
			return false;
		}
		
		if (previousToken == null
				|| binaryOperators.containsKey(previousToken)
				|| unaryOperators.containsKey(previousToken)) {
			UnaryOperatorDefinition unaryOperator = unaryOperators.get(currentToken);
			
			if (unaryOperator == null) {
				throw new IllegalArgumentException("Unrecognized unary operator: " + currentToken);
			}
			
			expression.unaryOp(unaryOperator);
		} else {
			BinaryOperatorDefinition binaryOperator = binaryOperators.get(currentToken);
			
			if (binaryOperator == null) {
				throw new IllegalArgumentException("Unrecognized binary operator: " + currentToken);
			}
			
			expression.binaryOp(binaryOperator);
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
	
	private boolean handleVariable() {
		Variable variable = variables.get(currentToken);
		if (variable == null) {
			return false;
		}
		expression.val(variable);
		return true;
	}
	
	private boolean handleWhiteSpace() {
		return currentToken.trim().isEmpty();
	}
	
	private void initBinaryOperators() {
		if (binaryOperators == DEFAULT_BINARY_OPERATORS) {
			binaryOperators = new HashMap<>(DEFAULT_BINARY_OPERATORS);
		}
	}
	
	private void initUnaryOperators() {
		if (unaryOperators == DEFAULT_UNARY_OPERATORS) {
			unaryOperators = new HashMap<>(DEFAULT_UNARY_OPERATORS);
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
