package com.javalbert.biexprtree;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Expression {
	public static Expression newExpr() {
		return new Expression();
	}
	
	private final List<Node> nodes = new ArrayList<>();
	private final Map<String, Variable> variables = new HashMap<>();
	
	public Variable getVariable(String name) {
		return variables.get(name);
	}
	
	/* START Operand methods */
	
	public Expression expr(Expression expr) {
		Objects.requireNonNull(expr, "expr must not be null");
		nodes.add(new Operand<>(Expression.class, expr));
		return this;
	}
	
	public Expression flatExpr(Expression expr) {
		Objects.requireNonNull(expr, "expr must not be null");
		
		expr.nodes.stream()
		.forEach(node -> {
			if (node instanceof Operand) {
				Operand operand = (Operand)node;
				val(operand.getValue(), operand.getOperandClass());
			}
		});
		return this;
	}
	
	public Expression val(BigDecimal d) {
		nodes.add(new Operand<>(BigDecimal.class, d));
		return this;
	}
	
	public Expression val(Boolean b) {
		nodes.add(new Operand<>(Boolean.class, b));
		return this;
	}
	
	public Expression val(boolean b) {
		nodes.add(new BooleanOperand(b));
		return this;
	}
	
	public Expression val(Date d) {
		nodes.add(new Operand<>(Date.class, d));
		return this;
	}
	
	public Expression val(Double d) {
		nodes.add(new Operand<>(Double.class, d));
		return this;
	}
	
	public Expression val(double d) {
		nodes.add(new DoubleOperand(d));
		return this;
	}
	
	public Expression val(Character c) {
		nodes.add(new Operand<>(Character.class, c));
		return this;
	}
	
	public Expression val(char c) {
		nodes.add(new CharOperand(c));
		return this;
	}
	
	public Expression val(Float f) {
		nodes.add(new Operand<>(Float.class, f));
		return this;
	}
	
	public Expression val(float f) {
		nodes.add(new FloatOperand(f));
		return this;
	}
	
	public Expression val(Integer i) {
		nodes.add(new Operand<>(Integer.class, i));
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
	
	public Expression val(Long l) {
		nodes.add(new Operand<>(Long.class, l));
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
		
		switch (cls.getCanonicalName()) {
			case "boolean": return val((boolean) o);
			case "char": return val((char) o);
			case "double": return val((double) o);
			case "float": return val((float) o);
			case "int": return val((int) o);
			case "long": return val((long) o);
			default:
				// other types just do new Operand<>(cls, o);
				break;
		}
		
		nodes.add(new Operand<>(cls, o));
		return this;
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
	
	public Expression binaryOp(BinaryOperatorNode node) {
		nodes.add(Objects.requireNonNull(node));
		return this;
	}
	
	public Expression unaryOp(UnaryOperatorNode node) {
		nodes.add(Objects.requireNonNull(node));
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
}
