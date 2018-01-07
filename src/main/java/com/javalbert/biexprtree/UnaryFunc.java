package com.javalbert.biexprtree;

import java.util.Objects;
import java.util.function.Function;

public class UnaryFunc<T> implements Func {
	private final Function<Operand<T>, Operand<?>> function;
	private final OperatorInfo operatorInfo;

	@Override
	public OperatorInfo getOperatorInfo() {
		return operatorInfo;
	}
	
	public Function getFunction() {
		return function;
	}
	
	public UnaryFunc(UnaryOperatorInfo<T> operatorInfo, Function<Operand<T>, Operand<?>> function) {
		this.operatorInfo = Objects.requireNonNull(operatorInfo, "operatorInfo must not be null");
		this.function = Objects.requireNonNull(function, "function must not be null");
	}
}
