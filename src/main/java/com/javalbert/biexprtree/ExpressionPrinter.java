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

public class ExpressionPrinter {
	private BinaryOperatorPrecedence operatorPrecedence;
	
	// processing
	//
	private StringBuilder builder;
	private boolean unaryOperatorPreviously;
	
	public BinaryOperatorPrecedence getOperatorPrecedence() {
		return operatorPrecedence;
	}
	
	public void setOperatorPrecedence(BinaryOperatorPrecedence operatorPrecedence) {
		this.operatorPrecedence = operatorPrecedence != null ? operatorPrecedence : BinaryOperatorPrecedence.INSTANCE;
	}
	
	public ExpressionPrinter() {
		this(null);
	}
	
	public ExpressionPrinter(BinaryOperatorPrecedence operatorPrecedence) {
		setOperatorPrecedence(operatorPrecedence);
	}
	
	public String print(Expression expr) {
		builder = new StringBuilder();
		expr.getNodes().forEach(this::handleNode);
		String str = builder.toString();
		builder = null;
		return str.trim();
	}
	
	private void handleNode(Node node) {
		if (node instanceof Operand) {
			handleOperand((Operand) node);
		} else if (node instanceof BinaryOperatorDefinition) {
			printOperator((Operator) node);
			unaryOperatorPreviously = false;
		} else if (node instanceof UnaryOperatorDefinition) {
			printOperator((Operator) node);
			unaryOperatorPreviously = true;
		}
	}

	private void handleOperand(Operand operand) {
		Object value = operand.getValue();
		
		if (!unaryOperatorPreviously) {
			builder.append(" ");
		}
		
		if (value instanceof String) {
			builder.append("\"")
			.append(value.toString().replaceAll("\"", "\\\\\""))
			.append("\"");
		} else if (value instanceof Expression) {
			builder.append("(")
			.append(new ExpressionPrinter().print((Expression)value))
			.append(")");
		} else {
			builder.append(value);
		}
	}
	
	private void printOperator(Operator operator) {
		builder.append(" ")
		.append(operator.getOperator());
	}
}
