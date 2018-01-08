package com.javalbert.biexprtree;

public class BinaryOperatorNode implements Operator {
	private final String operator;
	
	@Override
	public String getOperator() {
		return operator;
	}

	public BinaryOperatorNode(String operator) {
		this.operator = Functions.validateOperator(operator);
	}
}
