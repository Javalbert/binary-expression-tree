package com.javalbert.biexprtree;

import java.util.Objects;
import java.util.function.BiFunction;

public class BinaryFunc<T, U> implements Func {
	private final BiFunction<Operand<T>, Operand<U>, Operand<?>> function;
	private final OperatorInfo operatorInfo;

	@Override
	public OperatorInfo getOperatorInfo() {
		return operatorInfo;
	}
	
	public BiFunction getFunction() {
		return function;
	}
	
	public BinaryFunc(BinaryOperatorInfo<T, U> operatorInfo, BiFunction<Operand<T>, Operand<U>, Operand<?>> function) {
		this.operatorInfo = Objects.requireNonNull(operatorInfo, "operatorInfo must not be null");
		this.function = Objects.requireNonNull(function, "function must not be null");
	}
}
