package com.javalbert.biexprtree;

public interface Func {
	default String getOperator() {
		return getOperatorInfo().getOperator();
	}
	OperatorInfo getOperatorInfo();
}
