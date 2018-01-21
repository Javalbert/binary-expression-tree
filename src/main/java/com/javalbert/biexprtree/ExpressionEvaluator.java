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

import java.util.Objects;

public class ExpressionEvaluator {
	public static Object eval(Expression expr) {
		return new ExpressionEvaluator().eval(
				new ExpressionTreeCreator(expr).create()
				);
	}
	
	private final FunctionRegistry functionRegistry;
	
	public ExpressionEvaluator() {
		this(null);
	}
	
	public ExpressionEvaluator(FunctionRegistry functionRegistry) {
		this.functionRegistry = functionRegistry != null ? functionRegistry : DefaultFunctions.INSTANCE;
	}
	
	private BinaryOperatorInfo binaryOperatorInfoHashKey;
	private UnaryOperatorInfo unaryOperatorInfoHashKey;
	
	public Object eval(Node node) {
		Objects.requireNonNull(node, "node must not be null");
		setupEval();
		Operand result = eval0(node);
		cleanUpEval();
		return result.getValue();
	}
	
	private boolean canShortCircuit(Operand leftOperand, BinaryOperatorNode binaryNode) {
		if (leftOperand instanceof BooleanOperand) {
			BooleanOperand booleanOperand = (BooleanOperand)leftOperand;
			
			return !booleanOperand.getBooleanValue()
					&& binaryNode.getOperator().equals(Operators.AND.getOperator())
					|| booleanOperand.getBooleanValue()
					&& binaryNode.getOperator().equals(Operators.OR.getOperator());
		}
		return false;
	}
	
	private void cleanUpEval() {
		binaryOperatorInfoHashKey = null;
		unaryOperatorInfoHashKey = null;
	}
	
	private Operand eval0(Node node) {
		if (node instanceof BinaryOperatorNode) {
			return evalBinaryOperation((BinaryOperatorNode) node);
		} else if (node instanceof UnaryOperatorNode) {
			return evalUnaryOperation((UnaryOperatorNode) node);
		} else if (node instanceof Operand) {
			return evalOperand((Operand) node);
		}
		return null;
	}
	
	private Operand evalBinaryOperation(BinaryOperatorNode binaryNode) {
		Operand leftOperand = evalOperand(binaryNode.getLeftOperand());
		
		if (canShortCircuit(leftOperand, binaryNode)) {
			return leftOperand;
		}
		
		Operand rightOperand = evalOperand(binaryNode.getRightOperand());
		BinaryFunc binaryFunc = getBinaryFunc(binaryNode, leftOperand, rightOperand);
		
		if (binaryOperatorInfoHashKey.getLeftOperandClass() == leftOperand.getOperandClass()) {
			return (Operand)binaryFunc.getFunction().apply(leftOperand, rightOperand);
		}
		return (Operand)binaryFunc.getFunction().apply(rightOperand, leftOperand);
	}

	private Operand evalOperand(Operand operand) {
		Object operandValue = operand.getValue();
		
		if (operandValue instanceof BinaryOperatorNode) {
			return evalBinaryOperation((BinaryOperatorNode) operandValue);
		} else if (operandValue instanceof UnaryOperatorNode) {
			return evalUnaryOperation((UnaryOperatorNode) operandValue);
		} else if (operandValue instanceof Variable) {
			return ((Variable)operandValue).toOperand();
		}
		
		return operand;
	}
	
	private Operand evalUnaryOperation(UnaryOperatorNode unaryNode) {
		Operand operand = evalOperand(unaryNode.getOperand());
		return (Operand)getUnaryFunc(unaryNode, operand)
				.getFunction()
				.apply(operand);
	}
	
	private BinaryFunc getBinaryFunc(
			BinaryOperatorNode binaryNode,
			Operand leftOperand,
			Operand rightOperand) {
		binaryOperatorInfoHashKey.forHash(binaryNode, leftOperand, rightOperand);
		BinaryFunc binaryFunc = functionRegistry.getBinaryFunc(binaryOperatorInfoHashKey);
		
		if (binaryFunc == null) {
			binaryOperatorInfoHashKey.forHash(binaryNode, rightOperand, leftOperand);
			binaryFunc = functionRegistry.getBinaryFunc(binaryOperatorInfoHashKey);
			
			if (binaryFunc == null) {
				binaryFunc = DefaultFunctions.INSTANCE.getBinaryFunc(binaryOperatorInfoHashKey);
				
				if (binaryFunc == null) {
					throw new IllegalStateException(
							"no binary function exists for operator (" + binaryOperatorInfoHashKey.getOperator()
							+ "), left operand (" + binaryOperatorInfoHashKey.getLeftOperandClass() + ")"
							+ ", and right operand (" + binaryOperatorInfoHashKey.getRightOperandClass() + ")");
				}
			}
		}
		
		return binaryFunc;
	}
	
	private UnaryFunc getUnaryFunc(UnaryOperatorNode unaryNode, Operand operand) {
		unaryOperatorInfoHashKey.forHash(unaryNode, operand);
		UnaryFunc unaryFunc = functionRegistry.getUnaryFunc(unaryOperatorInfoHashKey);
		
		if (unaryFunc == null) {
			unaryFunc = DefaultFunctions.INSTANCE.getUnaryFunc(unaryOperatorInfoHashKey);
			
			if (unaryFunc == null) {
				throw new IllegalStateException(
						"no unary function exists for operator (" + unaryOperatorInfoHashKey.getOperator()
						+ ") and operand (" + unaryOperatorInfoHashKey.getOperandClass() + ")");
			}
		}
		
		return unaryFunc;
	}
	
	private void setupEval() {
		binaryOperatorInfoHashKey = new BinaryOperatorInfo();
		unaryOperatorInfoHashKey = new UnaryOperatorInfo();
	}
}
