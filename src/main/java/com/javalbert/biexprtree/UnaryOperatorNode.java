package com.javalbert.biexprtree;

public class UnaryOperatorNode implements Operator {
	private final String operator;
	private Operand operand;
	
	@Override
	public String getOperator() {
		return operator;
	}
	
	public Operand getOperand() {
		return operand;
	}
	
	void setOperand(Operand operand) {
		this.operand = operand;
	}

	public UnaryOperatorNode(String operator, Operand operand) {
		this.operator = Functions.validateOperator(operator);
		this.operand = operand;
	}
	
	@Override
	public String toString() {
		return operator + operand;
	}
}