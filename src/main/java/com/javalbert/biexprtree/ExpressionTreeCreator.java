package com.javalbert.biexprtree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

public class ExpressionTreeCreator {
	private final Expression expr;
	
	// processing
	//
	private Node currentNode;
	private Deque<Node> nodeStack;
	private Deque<Node> processStack;
	
	// output
	//
	private Node rootNode;
	
	public Node getRootNode() {
		return rootNode;
	}
	
	public ExpressionTreeCreator(Expression expr) {
		this.expr = Objects.requireNonNull(expr, "expr must not be null");
	}
	
	public ExpressionTreeCreator create() {
		nodeStack = new ArrayDeque<>(expr.getNodes());
		processStack = new ArrayDeque<>();
		
		while (!nodeStack.isEmpty() || processStack.size() != 1) {
			popStack();
			
			if (handleOperand()) {;}
			else if (handleOperator()) {;}
		}
		
		rootNode = processStack.removeFirst();
		cleanUp();
		return this;
	}
	
	private void cleanUp() {
		currentNode = null;
		nodeStack = null;
		processStack = null;
	}
	
	private boolean handleBinaryOperatorDefinition() {
		if (!(currentNode instanceof BinaryOperatorDefinition)) {
			return false;
		}
		
		Node node = processStack.peekFirst();
		if (!(node instanceof Operand)) {
			return false;
		}
		processStack.removeFirst();
		
		BinaryOperatorDefinition binaryOpDef = (BinaryOperatorDefinition)currentNode;
		BinaryOperatorNode binaryNode = new BinaryOperatorNode(
				binaryOpDef.getOperator(), (Operand)node, null);
		processStack.addFirst(binaryNode);
		
		return true;
	}
	
	private boolean handleOperand() {
		if (!(currentNode instanceof Operand)) {
			return false;
		} else if (processStack.isEmpty()) {
			processStack.addFirst(currentNode);
			return true;
		}
		
		Operand operand = (Operand)currentNode;
		
		Operator operatorNode = (Operator)processStack.peekFirst();
		if (operatorNode instanceof BinaryOperatorNode) {
			BinaryOperatorNode binaryNode = (BinaryOperatorNode)operatorNode;
			binaryNode.setRightOperand(operand);
		} else if (operatorNode instanceof UnaryOperatorNode) {
			UnaryOperatorNode unaryNode = (UnaryOperatorNode)operatorNode;
			unaryNode.setOperand(operand);
		}
		
		return true;
	}
	
	private boolean handleOperator() {
		if (handleBinaryOperatorDefinition()) {
			return true;
		} else if (handleUnaryOperatorDefinition()) {
			return true;
		}
		
		return false;
	}
	
	private boolean handleUnaryOperatorDefinition() {
		if (!(currentNode instanceof UnaryOperatorDefinition)) {
			return false;
		}
		
		Node node = processStack.peekFirst();
		if (!(node instanceof Operand)) {
			return false;
		}
		processStack.removeFirst();
		
		UnaryOperatorDefinition unaryOpDef = (UnaryOperatorDefinition)currentNode;
		UnaryOperatorNode unaryNode = new UnaryOperatorNode(
				unaryOpDef.getOperator(), (Operand)node);
		processStack.addFirst(unaryNode);
		
		return true;
	}
	
	private void popStack() {
		currentNode = !nodeStack.isEmpty() ? nodeStack.removeFirst() : processStack.removeFirst();
	}
}
