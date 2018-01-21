package com.javalbert.biexprtree

import spock.lang.Specification

class ExpressionTreeCreatorSpec extends Specification {
	def 'Create binary node adding 1 and 2'() {
		given: 'an Expression: 1 + 2'
		Expression expr = new Expression().val(1).plus().val(2)
		ExpressionTreeCreator creator = new ExpressionTreeCreator(expr)
		
		when: 'expression tree is created'
		Node node = creator.create()
		
		then: 'root node is binary operator +'
		node instanceof BinaryOperatorNode
		node.getOperator() == '+'
		
		and: 'left operand is 1'
		node.getLeftOperand().getValue() == 1
		
		and: 'right operand is 2'
		node.getRightOperand().getValue() == 2
	}
	
	def 'Create unary node -2'() {
		given: 'an Expression: -2'
		Expression expr = new Expression().negate().val(2)
		ExpressionTreeCreator creator = new ExpressionTreeCreator(expr)
		
		when: 'expression tree is created'
		Node node = creator.create()
		
		then: 'root node is unary operator -'
		node instanceof UnaryOperatorNode
		node.getOperator() == '-'
		
		and: 'operand is 2'
		node.getOperand().getValue() == 2
	}
	
	def 'Modified binary operator precedence makes addition node a child of multiplication node'() {
		given: 'an Expression: 1 + 2 * 3'
		Expression expr = new Expression().val(1).plus().val(2).times().val(3)
		ExpressionTreeCreator creator = new ExpressionTreeCreator(expr)
		
		when: 'order of operations is modified so that addition is performed before multiplication'
		BinaryOperatorPrecedence operatorPrecedence = new BinaryOperatorPrecedence()
		operatorPrecedence.move('+', operatorPrecedence.getPriority('*'), false)
		creator.setOperatorPrecedence(operatorPrecedence)
		
		and: 'expression tree is created'
		BinaryOperatorNode node = creator.create()
		
		then: 'addition is child node of multiplication node'
		node.getLeftOperand().getValue().getOperator() == '+'
	}
	
	def 'Left operand is additive inverse unary operator for expression -1 + 2'() {
		given: 'an Expression: -1 + 2'
		Expression expr = new Expression().negate().val(1).plus().val(2)
		ExpressionTreeCreator creator = new ExpressionTreeCreator(expr)
		
		when: 'expression tree is created'
		BinaryOperatorNode node = creator.create()
		
		then: 'left operand is additive inverse unary operator'
		node.getLeftOperand().getValue() instanceof UnaryOperatorNode
		node.getLeftOperand().getValue().getOperator() == '-'
	}
	
	def 'Root node subtraction operator\'s left operand is addition operator for expression 1 + 2 * 3 - 4'() {
		given: 'an Expression 1 + 2 * 3 - 4'
		Expression expr = new Expression()
		.val(1).plus().val(2)
		.times().val(3)
		.minus().val(4)
		ExpressionTreeCreator creator = new ExpressionTreeCreator(expr)
		
		when: 'expression tree is created'
		BinaryOperatorNode node = creator.create()
		
		then: 'left operand of root node is the addition operator node'
		node.getLeftOperand().getValue().getOperator() == '+'
	}
	
	def 'Root node\'s right operand is second multiplication, and second multiplication\'s left operand is first multiplication'() {
		given: 'an Expression 1 + 2 * 3 * 4'
		Expression expr = new Expression()
		.val(1).plus().val(2)
		.times().val(3)
		.times().val(4)
		ExpressionTreeCreator creator = new ExpressionTreeCreator(expr)
		
		when: 'expression tree is created'
		BinaryOperatorNode node = creator.create()
		
		then: 'root node\'s right operand is second multiplication * 4'
		BinaryOperatorNode secondMultiplication = node.getRightOperand().getValue()
		secondMultiplication.getOperator() == '*'
		secondMultiplication.getRightOperand().getValue() == 4
		
		and: 'second multiplication\'s left operand is first multiplication 2 * 3'
		BinaryOperatorNode firstMultiplication = secondMultiplication.getLeftOperand().getValue()
		firstMultiplication.getOperator() == '*'
		firstMultiplication.getLeftOperand().getValue() == 2
		firstMultiplication.getRightOperand().getValue() == 3
	}
	
	def 'Root node\'s right operand is multiplication, and multiplication\'s left operand is exponentiation'() {
		given: 'an Expression 1 + 2 ** 3 * 4'
		Expression expr = new Expression()
		.val(1).plus().val(2)
		.powerOf().val(3)
		.times().val(4)
		ExpressionTreeCreator creator = new ExpressionTreeCreator(expr)
		
		when: 'expression tree is created'
		BinaryOperatorNode node = creator.create()
		
		then: 'root node\'s right operand is multiplication * 4'
		BinaryOperatorNode multiplication = node.getRightOperand().getValue()
		multiplication.getOperator() == '*'
		multiplication.getRightOperand().getValue() == 4
		
		and: 'multiplication\'s left operand is exponentiation 2 ** 3'
		BinaryOperatorNode exponentiation = multiplication.getLeftOperand().getValue()
		exponentiation.getOperator() == '**'
		exponentiation.getLeftOperand().getValue() == 2
		exponentiation.getRightOperand().getValue() == 3
	}
	
	def 'Right operand is additive inverse for expression 1 + -2'() {
		given: 'an Expression 1 + -2'
		Expression expr = new Expression().val(1).plus().negate().val(2)
		ExpressionTreeCreator creator = new ExpressionTreeCreator(expr)
		
		when: 'expression tree is created'
		BinaryOperatorNode node = creator.create()
		
		then: 'right operand is additive inverse'
		node.getRightOperand().getValue().getOperator() == '-'
	}
}
