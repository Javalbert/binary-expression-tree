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

	public UnaryOperatorNode(String operator) {
		this.operator = Functions.validateOperator(operator);
	}
	
	@Override
	public String toString() {
		if (operand == null) {
			return operator;
		}
		
		StringBuilder str = new StringBuilder(operator);
		
		Object operandValue = operand.getValue();
		
		boolean nestedExpression = operandValue instanceof Operator;
		if (nestedExpression) {
			str.append("(");
		}
		
		if (operandValue != null) {
			if (operandValue instanceof Variable) {
				Variable variable = (Variable)operandValue;
				str.append(variable.getName())
				.append("(").append(variable.getValue()).append(")");
			} else {
				str.append(operandValue);
			}
		}
		
		if (nestedExpression) {
			str.append(")");
		}
		return str.toString();
	}
}
