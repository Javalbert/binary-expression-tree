package com.javalbert.biexprtree

import spock.lang.Specification

import static com.javalbert.biexprtree.Expression.*;

class ExpressionTreeCreatorSpec extends Specification {
	def 'Create binary node adding 1 and 2'() {
		given: 'an Expression: 1 + 2'
		Expression expr = newExpr().val((int)1).plus().val((int)2)
		ExpressionTreeCreator creator = new ExpressionTreeCreator(expr)
		
		when: 'expression tree is created'
		Node node = creator.create().getRootNode()
		
		then: 'root node is binary operator +'
		node instanceof BinaryOperatorNode
		node.getOperator() == '+'
		
		and: 'left operand is 1'
		node.getLeftOperand().value == 1
		
		and: 'right operand is 2'
		node.getRightOperand().value == 2
	}
	
	def 'Create unary node -2'() {
		given: 'an Expression: -2'
		Expression expr = newExpr().negate().val(2)
		ExpressionTreeCreator creator = new ExpressionTreeCreator(expr)
		
		when: 'expression tree is created'
		Node node = creator.create().getRootNode()
		
		then: 'root node is unary operator -'
		node instanceof UnaryOperatorNode
		node.getOperator() == '-'
		
		and: 'operand is 2'
		node.getOperand().value == 2
	}
}
