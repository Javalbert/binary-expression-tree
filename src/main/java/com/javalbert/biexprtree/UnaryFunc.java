package com.javalbert.biexprtree;

import java.util.function.Function;

public class UnaryFunc implements Func {
	private final Function function;
	private final String operator;
	
	@Override
	public FunctionType getFunctionType() {
		return FunctionType.UNARY;
	}

	@Override
	public String getOperator() {
		return operator;
	}
	
	public Function getFunction() {
		return function;
	}
	
	public UnaryFunc(String operator, Function function) {
		this.operator = Functions.validateOperator(operator);
		this.function = function;
	}
}
