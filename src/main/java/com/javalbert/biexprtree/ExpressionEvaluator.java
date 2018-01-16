package com.javalbert.biexprtree;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;

public class ExpressionEvaluator {
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
	
	private void cleanUpEval() {
		binaryOperatorInfoHashKey = null;
		unaryOperatorInfoHashKey = null;
	}
	
	private Operand eval0(Node node) {
		if (node instanceof BinaryOperatorNode) {
			BinaryOperatorNode binaryNode = (BinaryOperatorNode)node;
			return (Operand)getBinaryFunction(binaryNode)
					.apply(binaryNode.getLeftOperand(), binaryNode.getRightOperand());
		} else if (node instanceof UnaryOperatorNode) {
			UnaryOperatorNode unaryNode = (UnaryOperatorNode)node;
			return (Operand)getUnaryFunction(unaryNode).apply(unaryNode.getOperand());
		} else if (node instanceof Operand) {
			return (Operand)node;
		}
		return null;
	}
	
	private BiFunction getBinaryFunction(BinaryOperatorNode binaryNode) {
		binaryOperatorInfoHashKey.forHash(binaryNode);
		BiFunction binaryFunction = functionRegistry.getBinaryFunction(binaryOperatorInfoHashKey);
		
		if (binaryFunction == null) {
			binaryFunction = DefaultFunctions.INSTANCE.getBinaryFunction(binaryOperatorInfoHashKey);
			
			if (binaryFunction == null) {
				throw new IllegalStateException(
						"no binary function exists for operator (" + unaryOperatorInfoHashKey.getOperator()
						+ "), left operand (" + binaryOperatorInfoHashKey.getLeftOperandClass() + ")"
						+ ", and right operand (" + binaryOperatorInfoHashKey.getRightOperandClass() + ")");
			}
		}
		
		return binaryFunction;
	}
	
	private Function getUnaryFunction(UnaryOperatorNode unaryNode) {
		unaryOperatorInfoHashKey.forHash(unaryNode);
		Function unaryFunction = functionRegistry.getUnaryFunction(unaryOperatorInfoHashKey);
		
		if (unaryFunction == null) {
			unaryFunction = DefaultFunctions.INSTANCE.getUnaryFunction(unaryOperatorInfoHashKey);
			
			if (unaryFunction == null) {
				throw new IllegalStateException(
						"no unary function exists for operator (" + unaryOperatorInfoHashKey.getOperator()
						+ ") and operand (" + unaryOperatorInfoHashKey.getOperandClass() + ")");
			}
		}
		
		return unaryFunction;
	}
	
	private void setupEval() {
		binaryOperatorInfoHashKey = new BinaryOperatorInfo();
		unaryOperatorInfoHashKey = new UnaryOperatorInfo();
	}
}
