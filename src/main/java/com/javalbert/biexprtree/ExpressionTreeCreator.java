package com.javalbert.biexprtree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

public class ExpressionTreeCreator {
	private final Expression expr;
	
	// processing
	//
	private Node currentNode;
	private Deque<Node> nodeDeque;
	private Deque<Node> processDeque;
	
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
		setupStacks();
		
		while (!nodeDeque.isEmpty() || processDeque.size() != 1) {
			popStack();
			
			if (handleOperand()) {;}
			else if (handleOperator()) {;}
		}
		
		rootNode = processDeque.removeLast();
		cleanUp();
		return this;
	}
	
	private void cleanUp() {
		currentNode = null;
		nodeDeque = null;
		processDeque = null;
	}
	
	private boolean handleBinaryOperatorDefinition() {
		if (!(currentNode instanceof BinaryOperatorDefinition)) {
			return false;
		}
		
		Node node = processDeque.peekLast();
		if (!(node instanceof Operand)) {
			return false;
		}
		processDeque.removeLast();
		
		BinaryOperatorDefinition binaryOpDef = (BinaryOperatorDefinition)currentNode;
		BinaryOperatorNode binaryNode = new BinaryOperatorNode(binaryOpDef.getOperator());
		binaryNode.setLeftOperand((Operand)node);
		processDeque.addLast(binaryNode);
		
		return true;
	}
	
	private boolean handleOperand() {
		if (!(currentNode instanceof Operand)) {
			return false;
		} else if (processDeque.isEmpty()) {
			processDeque.addLast(currentNode);
			return true;
		}
		
		Operand operand = (Operand)currentNode;
		
		Operator operatorNode = (Operator)processDeque.peekLast();
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
		
		UnaryOperatorDefinition unaryOpDef = (UnaryOperatorDefinition)currentNode;
		UnaryOperatorNode unaryNode = new UnaryOperatorNode(unaryOpDef.getOperator());
		processDeque.addLast(unaryNode);
		
		return true;
	}
	
	private void popStack() {
		currentNode = !nodeDeque.isEmpty() ? nodeDeque.removeFirst() : processDeque.removeFirst();
	}
	
	private void setupStacks() {
		nodeDeque = new ArrayDeque<>(expr.getNodes());
		processDeque = new ArrayDeque<>(3);
	}
}
