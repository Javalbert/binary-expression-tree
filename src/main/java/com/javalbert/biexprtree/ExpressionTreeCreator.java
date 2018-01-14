package com.javalbert.biexprtree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ExpressionTreeCreator {
	private final Expression expr;
	private BinaryOperatorPrecedence operatorPrecedence;
	
	// processing
	//
	private Node currentNode;
	private Deque<Node> nodeDeque;
	private Map<Integer, BinaryOperatorNode> operatorsByPrecedence;
	private Operator operatorWithMissingOperand;
	
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
		setupCreateProcess();
		
		while (popStack() &&
				(handleOperand()
				|| handleBinaryOperatorDefinition()
				|| handleUnaryOperatorDefinition())
				) {
			; // empty while loop body
		}
		
		cleanUp();
		return this;
	}
	
	private void addOperandToNewBinaryNode(BinaryOperatorDefinition binaryOpDef, Operand operand) {
		BinaryOperatorNode binaryNode = new BinaryOperatorNode(binaryOpDef.getOperator());
		binaryNode.setLeftOperand(operand);
		updateOperatorByPrecedenceMap(binaryNode);
		operatorWithMissingOperand = binaryNode;
		
		rootNode = binaryNode;
	}
	
	private void cleanUp() {
		currentNode = null;
		nodeDeque = null;
		operatorsByPrecedence = null;
		operatorWithMissingOperand = null;
	}
	
	private BinaryOperatorNode getLowerPriorityNode(int priority) {
		priority--;
		if (priority < operatorPrecedence().getLowestPriority()) {
			return null;
		}
		
		BinaryOperatorNode binaryNode = operatorsByPrecedence.get(priority);
		if (binaryNode != null) {
			return binaryNode;
		}
		return getLowerPriorityNode(priority);
	}
	
	private BinaryOperatorNode getSameOrHigherPriorityNode(int priority) {
		if (priority > 0) {
			return null;
		}
		
		BinaryOperatorNode binaryNode = operatorsByPrecedence.get(priority);
		if (binaryNode != null) {
			return binaryNode;
		}
		return getSameOrHigherPriorityNode(priority + 1);
	}
	
	private boolean handleBinaryOperatorDefinition() {
		if (!(currentNode instanceof BinaryOperatorDefinition)) {
			return false;
		}
		BinaryOperatorDefinition binaryOpDef = (BinaryOperatorDefinition)currentNode;
		
		Node node = rootNode;
		if (node instanceof BinaryOperatorNode) {
			joinBinaryNodes(binaryOpDef);
			return true;
		} else if (node instanceof Operand) {
			addOperandToNewBinaryNode(binaryOpDef, (Operand) node);
			return true;
		} else if (node instanceof UnaryOperatorNode) {
			addOperandToNewBinaryNode(binaryOpDef, new Operand(UnaryOperatorNode.class, node));
			return true;
		}
		
		return false;
	}

	private boolean handleOperand() {
		if (!(currentNode instanceof Operand)) {
			return false;
		} else if (rootNode == null) {
			rootNode = currentNode;
			return true;
		}
		
		Operand operand = (Operand)currentNode;
		
		if (operatorWithMissingOperand instanceof BinaryOperatorNode) {
			BinaryOperatorNode binaryNode = (BinaryOperatorNode)operatorWithMissingOperand;
			binaryNode.setRightOperand(operand);
		} else if (operatorWithMissingOperand instanceof UnaryOperatorNode) {
			UnaryOperatorNode unaryNode = (UnaryOperatorNode)operatorWithMissingOperand;
			unaryNode.setOperand(operand);
		}
		
		return true;
	}
	
	private boolean handleUnaryOperatorDefinition() {
		if (!(currentNode instanceof UnaryOperatorDefinition)) {
			return false;
		}
		
		UnaryOperatorDefinition unaryOpDef = (UnaryOperatorDefinition)currentNode;
		UnaryOperatorNode unaryNode = new UnaryOperatorNode(unaryOpDef.getOperator());
		
		operatorWithMissingOperand = unaryNode;
		rootNode = unaryNode;
		
		return true;
	}
	
	private void joinBinaryNodes(BinaryOperatorDefinition binaryOpDef) {
		BinaryOperatorNode newBinaryNode = new BinaryOperatorNode(binaryOpDef.getOperator());
		int newOperatorPriority = operatorPrecedence().getPriority(binaryOpDef.getOperator());
		
		BinaryOperatorNode binaryNode = getLowerPriorityNode(newOperatorPriority);
		
		if (binaryNode != null) {
			newBinaryNode.setLeftOperand(binaryNode.getRightOperand());
			binaryNode.setRightOperand(new Operand(BinaryOperatorNode.class, newBinaryNode));
			
			rootNode = binaryNode;
		} else {
			binaryNode = getSameOrHigherPriorityNode(newOperatorPriority);
			newBinaryNode.setLeftOperand(new Operand(BinaryOperatorNode.class, binaryNode));
			rootNode = newBinaryNode;
		}
		
		operatorWithMissingOperand = newBinaryNode;
	}
	
	private BinaryOperatorPrecedence operatorPrecedence() {
		if (operatorPrecedence == null) {
			operatorPrecedence = new BinaryOperatorPrecedence();
		}
		return operatorPrecedence;
	}
	
	private boolean popStack() {
		if (nodeDeque.isEmpty()) {
			return false;
		}
		currentNode = nodeDeque.removeFirst();
		return true;
	}
	
	private void setupCreateProcess() {
		nodeDeque = new ArrayDeque<>(expr.getNodes());
		operatorsByPrecedence = new HashMap<>();
	}
	
	private void updateOperatorByPrecedenceMap(BinaryOperatorNode binaryNode) {
		int priority = operatorPrecedence().getPriority(binaryNode.getOperator());
		operatorsByPrecedence.put(priority, binaryNode);
	}
}
