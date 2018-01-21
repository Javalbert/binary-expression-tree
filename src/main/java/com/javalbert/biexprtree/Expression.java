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

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

public class Expression {
	private final List<Node> nodes = new ArrayList<>();
	private final Map<String, Variable> variables = new HashMap<>();
	
	public List<Node> getNodes() {
		return Collections.unmodifiableList(nodes);
	}
	
	public Map<String, Variable> getVariables() {
		return Collections.unmodifiableMap(variables);
	}
	
	public Expression() {}
	
	public Expression(Expression expr) {
		nodes.addAll(expr.getNodes());
		variables.putAll(expr.getVariables());
	}
	
	public Variable getVariable(String name) {
		return variables.get(name);
	}
	
	private void addNestedVariables(Expression expr) {
		for (Entry<String, Variable> entry : expr.getVariables().entrySet()) {
			Variable nestedVariable = entry.getValue();
			Variable existingVariable = variables.get(nestedVariable.getName());
			
			if (existingVariable == null) {
				variables.put(nestedVariable.getName(), nestedVariable);
			} else if (nestedVariable != existingVariable) {
				throw new IllegalStateException("expr has a variable with the"
						+ " same name (" + nestedVariable.getName()
						+ ") as that of the containing Expression");
			}
		}
	}
	
	/* START Operand methods */
	
	public Expression expr(Expression expr) {
		Objects.requireNonNull(expr, "expr must not be null");
		addNestedVariables(expr);
		nodes.add(new Operand<>(Expression.class, new Expression(expr)));
		return this;
	}

	public Expression flatExpr(Expression expr) {
		Objects.requireNonNull(expr, "expr must not be null");
		
		expr.getNodes().stream()
		.forEach(node -> {
			if (node instanceof Operand) {
				Operand operand = (Operand)node;
				
				if (operand.getValue() instanceof Expression) {
					expr((Expression) operand.getValue());
				} else {
					val(operand.getValue(), operand.getOperandClass());
				}
			} else if (node instanceof BinaryOperatorDefinition) {
				binaryOp((BinaryOperatorDefinition) node);
			} else {
				unaryOp((UnaryOperatorDefinition) node);
			}
		});
		return this;
	}
	
	public Expression val(BigDecimal d) {
		nodes.add(new Operand<>(BigDecimal.class, d));
		return this;
	}
	
	public Expression val(boolean b) {
		nodes.add(new BooleanOperand(b));
		return this;
	}
	
	public Expression val(char c) {
		nodes.add(new CharOperand(c));
		return this;
	}
	
	public Expression val(Date d) {
		nodes.add(new Operand<>(Date.class, d));
		return this;
	}
	
	public Expression val(double d) {
		nodes.add(new DoubleOperand(d));
		return this;
	}
	
	public Expression val(float f) {
		nodes.add(new FloatOperand(f));
		return this;
	}
	
	public Expression val(int i) {
		nodes.add(new IntOperand(i));
		return this;
	}
	
	public Expression val(LocalDate d) {
		nodes.add(new Operand<>(LocalDate.class, d));
		return this;
	}
	
	public Expression val(LocalDateTime d) {
		nodes.add(new Operand<>(LocalDateTime.class, d));
		return this;
	}
	
	public Expression val(long l) {
		nodes.add(new LongOperand(l));
		return this;
	}
	
	public <T> Expression val(T o, Class<T> cls) {
		Objects.requireNonNull(cls, "cls must not be null");
		
		if (Expression.class.isAssignableFrom(cls)) {
			throw new IllegalArgumentException("call expr() or flatExpr() instead when passing in an Expression");
		} else if (Variable.class.isAssignableFrom(cls)) {
			return val((Variable)o);
		}
		
		// Gradle build complains:
		/*
		error: incompatible types: T cannot be converted to boolean
		                        case "boolean": return val((boolean) o);
		                                                             ^
		  where T is a type-variable:
		 */
		// After some Googling, found answers that did not work
		// and there is no way to disable the lint since compilerOptions is read-only
//		switch (cls.getCanonicalName()) {
//			case "boolean": return val((boolean) o);
//			case "char": return val((char) o);
//			case "double": return val((double) o);
//			case "float": return val((float) o);
//			case "int": return val((int) o);
//			case "long": return val((long) o);
//			default:
//				// other types just do new Operand<>(cls, o);
//				break;
//		}
		if (toPrimitive(o, cls)) {
			return this;
		}
		
		nodes.add(new Operand<>(cls, o));
		return this;
	}
	
	private boolean toPrimitive(Object o, Class cls) {
		switch (cls.getCanonicalName()) {
			case "java.lang.Boolean":
			case "boolean": val((boolean) o); return true;
			case "java.lang.Character":
			case "char": val((char) o); return true;
			case "java.lang.Double":
			case "double": val((double) o); return true;
			case "java.lang.Float":
			case "float": val((float) o); return true;
			case "java.lang.Integer":
			case "int": val((int) o); return true;
			case "java.lang.Long":
			case "long": val((long) o); return true;
		}
		return false;
	}
	
	public Expression val(String s) {
		nodes.add(new Operand<>(String.class, s));
		return this;
	}
	
	public <T> Expression val(Variable<T> v) {
		nodes.add(new Operand<>(Variable.class, v));
		variables.put(v.getName(), v);
		return this;
	}
	
	public Expression val(ZonedDateTime d) {
		nodes.add(new Operand<>(ZonedDateTime.class, d));
		return this;
	}
	
	/* END Operand methods */
	
	/* START Operator methods */
	
	public Expression binaryOp(BinaryOperatorDefinition op) {
		nodes.add(Objects.requireNonNull(op));
		return this;
	}
	
	public Expression unaryOp(UnaryOperatorDefinition op) {
		nodes.add(Objects.requireNonNull(op));
		return this;
	}
	
	// Math
	
	public Expression plus() {
		nodes.add(Operators.ADD);
		return this;
	}
	
	public Expression minus() {
		nodes.add(Operators.SUBTRACT);
		return this;
	}
	
	public Expression times() {
		nodes.add(Operators.MULTIPLY);
		return this;
	}
	
	public Expression dividedBy() {
		nodes.add(Operators.DIVIDE);
		return this;
	}
	
	public Expression modulo() {
		nodes.add(Operators.MODULO);
		return this;
	}
	
	public Expression powerOf() {
		nodes.add(Operators.POWER);
		return this;
	}
	
	public Expression negate() {
		nodes.add(Operators.NEGATE);
		return this;
	}
	
	// Boolean
	
	public Expression eq() {
		nodes.add(Operators.EQ);
		return this;
	}
	
	public Expression noteq() {
		nodes.add(Operators.NOTEQ);
		return this;
	}
	
	public Expression lt() {
		nodes.add(Operators.LT);
		return this;
	}
	
	public Expression lteq() {
		nodes.add(Operators.LTEQ);
		return this;
	}
	
	public Expression gt() {
		nodes.add(Operators.GT);
		return this;
	}
	
	public Expression gteq() {
		nodes.add(Operators.GTEQ);
		return this;
	}
	
	public Expression and() {
		nodes.add(Operators.AND);
		return this;
	}
	
	public Expression or() {
		nodes.add(Operators.OR);
		return this;
	}
	
	public Expression not() {
		nodes.add(Operators.NOT);
		return this;
	}
	
	/* END Operator methods */
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder("[Expression");
		for (Node node : nodes) {
			str.append(" ");
			if (node instanceof Operand) {
				str.append(((Operand)node).getValue());
			} else {
				str.append(node);
			}
		}
		return str.append("]").toString();
	}
}
