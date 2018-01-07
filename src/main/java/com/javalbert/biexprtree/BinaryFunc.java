package com.javalbert.biexprtree;

import java.util.function.BiFunction;

public class BinaryFunc implements Func {
	private final BiFunction function;
	private final String operator;
	
	@Override
	public FunctionType getFunctionType() {
		return FunctionType.BINARY;
	}
	
	@Override
	public String getOperator() {
		return operator;
	}
	
	public BiFunction getFunction() {
		return function;
	}
	
	public BinaryFunc(String operator, BiFunction function) {
		this.operator = Functions.validateOperator(operator);
		this.function = function;
	}
}
