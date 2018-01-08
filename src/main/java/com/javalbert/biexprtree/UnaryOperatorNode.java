package com.javalbert.biexprtree;

public class UnaryOperatorNode implements Operator {
	private final String operator;
	
	@Override
	public String getOperator() {
		return operator;
	}

	public UnaryOperatorNode(String operator) {
		this.operator = Functions.validateOperator(operator);
	}
}
