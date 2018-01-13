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
	
	public BinaryOperatorNode(String operator) {
		this.operator = Functions.validateOperator(operator);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();

		toStringOperandHelper(builder, leftOperand);
		builder.append(" ")
		.append(operator)
		.append(" ");
		toStringOperandHelper(builder, rightOperand);
		
		return builder.toString();
	}
	
	private void toStringOperandHelper(StringBuilder builder, Operand operand) {
		if (operand == null) {
			return;
		}
		
		if (operand.getValue() instanceof BinaryOperatorNode) {
			builder.append("<binary-operator ")
			.append(((Operator)operand.getValue()).getOperator())
			.append(">");
		} else if (operand.getValue() instanceof UnaryOperatorNode) {
			builder.append("<unary-operator ")
			.append(((Operator)operand.getValue()).getOperator())
			.append(">");
		} else {
			builder.append(operand.getValue());
		}
	}
}
