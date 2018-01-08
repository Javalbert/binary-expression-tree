package com.javalbert.biexprtree;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Expression {
	public static Expression newExpr() {
		return new Expression();
	}
	
	private final List<Node> nodes = new ArrayList<>();
	
	public Expression expr(Expression expr) {
		nodes.add(new Operand<>(Expression.class, expr));
		return this;
	}
	
	public Expression flatExpr(Expression expr) {
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
		return this;
	}
	
	public Expression val(ZonedDateTime d) {
		nodes.add(new Operand<>(ZonedDateTime.class, d));
		return this;
	}
}
