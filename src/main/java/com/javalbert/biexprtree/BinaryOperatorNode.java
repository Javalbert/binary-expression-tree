/*
   Copyright 2018 Albert Shun-Dat Chan

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

 */
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
		
		Object operandValue = operand.getValue();
		
		if (operandValue instanceof BinaryOperatorNode) {
			builder.append("<binary-operator ")
			.append(((Operator)operandValue).getOperator())
			.append(">");
		} else if (operandValue instanceof UnaryOperatorNode) {
			builder.append("<unary-operator ")
			.append(((Operator)operandValue).getOperator())
			.append(">");
		} else if (operandValue instanceof Variable) {
			Variable variable = (Variable)operandValue;
			builder.append(variable.getName())
			.append("(").append(variable.getValue()).append(")");
		} else {
			builder.append(operandValue);
		}
	}
}
