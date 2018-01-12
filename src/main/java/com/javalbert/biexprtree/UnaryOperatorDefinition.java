package com.javalbert.biexprtree;

public class UnaryOperatorDefinition implements Operator {
	private final String operator;
	
	@Override
	public String getOperator() {
		return operator;
	}

	public UnaryOperatorDefinition(String operator) {
		this.operator = Functions.validateOperator(operator);
	}
	
	@Override
	public String toString() {
		return operator;
	}
}
