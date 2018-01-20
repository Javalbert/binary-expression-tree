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
	private Map<Integer, BinaryOperatorNode> operatorsByPrecedence;
	private Operator operatorWithMissingOperand;
	
	// output
	//
	private Node rootNode;
	
	public BinaryOperatorPrecedence getOperatorPrecedence() {
		return operatorPrecedence;
	}
	
	public void setOperatorPrecedence(BinaryOperatorPrecedence operatorPrecedence) {
		this.operatorPrecedence = operatorPrecedence != null ? operatorPrecedence : BinaryOperatorPrecedence.INSTANCE;
	}
	
	public Node getRootNode() {
		return rootNode;
	}
	
	public ExpressionTreeCreator(Expression expr) {
		this(expr, null);
	}
	
	public ExpressionTreeCreator(Expression expr, BinaryOperatorPrecedence operatorPrecedence) {
		this.expr = Objects.requireNonNull(expr, "expr must not be null");
		setOperatorPrecedence(operatorPrecedence);
	}
	
	public ExpressionTreeCreator create() {
		setupCreateProcess();
		
		for (Node node : expr.getNodes()) {
			currentNode = node;
			if (handleOperand()
					|| handleBinaryOperatorDefinition()
					|| handleUnaryOperatorDefinition()) {
				; // empty statement
			}
		}
		
		cleanUp();
		return this;
	}
	
	private void addOperandToNewBinaryNode(BinaryOperatorDefinition binaryOpDef, Operand operand) {
		operand = checkNestedExpression(operand);
		
		BinaryOperatorNode binaryNode = new BinaryOperatorNode(binaryOpDef.getOperator());
		binaryNode.setLeftOperand(operand);
		updateOperatorByPrecedenceMap(binaryNode);
		operatorWithMissingOperand = binaryNode;
		
		rootNode = binaryNode;
	}
	
	private Operand checkNestedExpression(Operand operand) {
		if (operand.getValue() instanceof Expression) {
			Expression nestedExpr = (Expression)operand.getValue();
			
			Node node = new ExpressionTreeCreator(nestedExpr, operatorPrecedence)
			.create()
			.getRootNode();
			return new Operand(node.getClass(), node);
		}
		return operand;
	}

	private void cleanUp() {
		currentNode = null;
		operatorsByPrecedence = null;
		operatorWithMissingOperand = null;
	}
	
	private BinaryOperatorNode getLowerPriorityNode(int priority) {
		priority--;
		if (priority < operatorPrecedence.getLowestPriority()) {
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
		
		operand = checkNestedExpression(operand);
		
		if (operatorWithMissingOperand instanceof BinaryOperatorNode) {
			BinaryOperatorNode binaryNode = (BinaryOperatorNode)operatorWithMissingOperand;
			binaryNode.setRightOperand(operand);
		} else if (operatorWithMissingOperand instanceof UnaryOperatorNode) {
			UnaryOperatorNode unaryNode = (UnaryOperatorNode)operatorWithMissingOperand;
			unaryNode.setOperand(operand);
		}
		
		operatorWithMissingOperand = null;
		
		return true;
	}
	
	private boolean handleUnaryOperatorDefinition() {
		if (!(currentNode instanceof UnaryOperatorDefinition)) {
			return false;
		}
		
		UnaryOperatorDefinition unaryOpDef = (UnaryOperatorDefinition)currentNode;
		UnaryOperatorNode unaryNode = new UnaryOperatorNode(unaryOpDef.getOperator());
		
		if (operatorWithMissingOperand instanceof BinaryOperatorNode) {
			((BinaryOperatorNode)operatorWithMissingOperand)
			.setRightOperand(new Operand<>(UnaryOperatorNode.class, unaryNode));
		}
		
		operatorWithMissingOperand = unaryNode;
		if (rootNode == null) {
			rootNode = unaryNode;
		}
		return true;
	}
	
	private void joinBinaryNodes(BinaryOperatorDefinition binaryOpDef) {
		BinaryOperatorNode newBinaryNode = new BinaryOperatorNode(binaryOpDef.getOperator());
		int newOperatorPriority = operatorPrecedence.getPriority(binaryOpDef.getOperator());
		
		BinaryOperatorNode binaryNode = getLowerPriorityNode(newOperatorPriority);
		
		if (binaryNode != null) {
			newBinaryNode.setLeftOperand(binaryNode.getRightOperand());
			binaryNode.setRightOperand(new Operand(BinaryOperatorNode.class, newBinaryNode));
			
			updateRootNode(binaryNode);
		} else {
			binaryNode = getSameOrHigherPriorityNode(newOperatorPriority);
			newBinaryNode.setLeftOperand(new Operand(BinaryOperatorNode.class, binaryNode));
			updateRootNode(newBinaryNode);
		}
		
		updateOperatorByPrecedenceMap(newBinaryNode);
		operatorWithMissingOperand = newBinaryNode;
	}
	
	private void setupCreateProcess() {
		operatorsByPrecedence = new HashMap<>();
	}
	
	private void updateOperatorByPrecedenceMap(BinaryOperatorNode binaryNode) {
		int priority = operatorPrecedence.getPriority(binaryNode.getOperator());
		operatorsByPrecedence.put(priority, binaryNode);
	}
	
	private void updateRootNode(BinaryOperatorNode newRootNode) {
		if (rootNode == newRootNode) {
			return;
		}
		
		int newRootNodePriority = operatorPrecedence.getPriority(newRootNode.getOperator());
		int currentRootNodePriority = operatorPrecedence.getPriority(
				((BinaryOperatorNode)rootNode).getOperator());
		
		if (newRootNodePriority <= currentRootNodePriority) {
			rootNode = newRootNode;
		}
	}
}
