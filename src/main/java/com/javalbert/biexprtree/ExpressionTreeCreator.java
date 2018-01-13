package com.javalbert.biexprtree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

public class ExpressionTreeCreator {
	private final Expression expr;
	private BinaryOperatorPrecedence operatorPrecedence;
	
	// processing
	//
	private Node currentNode;
	private Deque<Node> nodeDeque;
	private Deque<Node> processDeque;
	
	// output
	//
	private Node rootNode;
	
	public BinaryOperatorPrecedence getOperatorPrecedence() {
		return operatorPrecedence;
	}
	
	public void setOperatorPrecedence(BinaryOperatorPrecedence operatorPrecedence) {
		this.operatorPrecedence = operatorPrecedence;
	}
	
	public Node getRootNode() {
		return rootNode;
	}
	
	public ExpressionTreeCreator(Expression expr) {
		this(expr, null);
	}
	
	public ExpressionTreeCreator(Expression expr, BinaryOperatorPrecedence operatorPrecedence) {
		this.expr = Objects.requireNonNull(expr, "expr must not be null");
		this.operatorPrecedence = operatorPrecedence;
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
	
	private void addOperandToNewBinaryNode(BinaryOperatorDefinition binaryOpDef, Operand operand) {
		processDeque.removeLast();
		
		BinaryOperatorNode binaryNode = new BinaryOperatorNode(binaryOpDef.getOperator());
		binaryNode.setLeftOperand(operand);
		processDeque.addLast(binaryNode);
	}
	
	private void addUnaryNodeToNewBinaryNode(BinaryOperatorDefinition binaryOpDef, UnaryOperatorNode node) {
		processDeque.removeLast();
		
		BinaryOperatorNode binaryNode = new BinaryOperatorNode(binaryOpDef.getOperator());
		binaryNode.setLeftOperand(new Operand(UnaryOperatorNode.class, node));
		processDeque.addLast(binaryNode);
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
		BinaryOperatorDefinition binaryOpDef = (BinaryOperatorDefinition)currentNode;
		
		Node node = processDeque.peekLast();
		if (node instanceof BinaryOperatorNode) {
			joinBinaryNodes(binaryOpDef, (BinaryOperatorNode)node);
			return true;
		} else if (node instanceof Operand) {
			addOperandToNewBinaryNode(binaryOpDef, (Operand)node);
			return true;
		} else if (node instanceof UnaryOperatorNode) {
			addUnaryNodeToNewBinaryNode(binaryOpDef, (UnaryOperatorNode)node);
			return true;
		}
		
		return false;
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
		return handleBinaryOperatorDefinition()
				|| handleUnaryOperatorDefinition();
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
	
	private void joinBinaryNodes(BinaryOperatorDefinition binaryOpDef, BinaryOperatorNode binaryNode) {
		processDeque.removeLast();
		
		int newOperatorPriority = operatorPrecedence.getPriority(binaryOpDef.getOperator());
		int binaryNodePriority = operatorPrecedence.getPriority(binaryNode.getOperator());

		BinaryOperatorNode newBinaryNode = new BinaryOperatorNode(binaryOpDef.getOperator());
		
		if (newOperatorPriority >= binaryNodePriority) {
			newBinaryNode.setLeftOperand(binaryNode.getRightOperand());
			binaryNode.setRightOperand(new Operand(BinaryOperatorNode.class, newBinaryNode));
		} else {
			newBinaryNode.setLeftOperand(new Operand(BinaryOperatorNode.class, binaryNode));
		}
		
		processDeque.addLast(newBinaryNode);
	}
	
	private void popStack() {
		currentNode = !nodeDeque.isEmpty() ? nodeDeque.removeFirst() : processDeque.removeFirst();
	}
	
	private void setupStacks() {
		nodeDeque = new ArrayDeque<>(expr.getNodes());
		processDeque = new ArrayDeque<>(3);
	}
}
