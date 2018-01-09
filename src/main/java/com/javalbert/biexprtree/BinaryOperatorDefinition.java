package com.javalbert.biexprtree;

public class BinaryOperatorDefinition implements Operator {
	private final String operator;
	
	@Override
	public String getOperator() {
		return operator;
	}

	public BinaryOperatorDefinition(String operator) {
		this.operator = Functions.validateOperator(operator);
	}
}
