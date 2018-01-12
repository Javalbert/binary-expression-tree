package com.javalbert.biexprtree;

public class BinaryOperatorNode implements Operator {
	private final String operator;
	private Operand leftOperand;
	private Operand rightOperand;
	
	@Override
	public String getOperator() {
		return operator;
	}
	
	public Operand getLeftOperand() {
		return leftOperand;
	}
	
	void setLeftOperand(Operand leftOperand) {
		this.leftOperand = leftOperand;
	}
	
	public Operand getRightOperand() {
		return rightOperand;
	}
	
	void setRightOperand(Operand rightOperand) {
		this.rightOperand = rightOperand;
	}
	
	public BinaryOperatorNode(String operator, Operand leftOperand, Operand rightOperand) {
		this.operator = Functions.validateOperator(operator);
		this.leftOperand = leftOperand;
		this.rightOperand = rightOperand;
	}
	
	@Override
	public String toString() {
		return "(left: " + leftOperand + ") " + operator + " (right: " + rightOperand + ")";
	}
}
