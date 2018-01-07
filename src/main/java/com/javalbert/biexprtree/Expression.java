package com.javalbert.biexprtree;

import java.util.ArrayList;
import java.util.List;

public class Expression {
	public static Expression newExpr() {
		return new Expression();
	}
	
	private final List<Object> nodes = new ArrayList<>();
	
	public Expression val(Boolean b) {
		nodes.add(new Operand<>(Boolean.class, b));
		return this;
	}
	
	public Expression val(boolean b) {
		nodes.add(new BooleanOperand(b));
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
	
	public Expression val(Long l) {
		nodes.add(new Operand<>(Long.class, l));
		return this;
	}
	
	public Expression val(long l) {
		nodes.add(new LongOperand(l));
		return this;
	}
}
