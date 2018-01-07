package com.javalbert.biexprtree;

public interface Func {
	default FunctionType getFunctionType() {
		return getOperatorInfo().getFunctionType();
	}
	default String getOperator() {
		return getOperatorInfo().getOperator();
	}
	OperatorInfo getOperatorInfo();
}
