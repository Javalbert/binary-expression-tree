package com.javalbert.biexprtree

import spock.lang.Specification

class ExpressionEvaluatorSpec extends Specification {
	def 'Expression evaluates to 1'() {
		given: 'an Expression 1'
		Expression expr = new Expression().val(1)
		Node node = new ExpressionTreeCreator(expr).create().getRootNode()
		
		when: 'evaluated'
		Object result = new ExpressionEvaluator().eval(node)
		
		then: 'result is 1'
		result == 1
	}
	
	def 'Expression evaluates to -2'() {
		given: 'an Expression -2'
		Expression expr = new Expression().negate().val(2)
		Node node = new ExpressionTreeCreator(expr).create().getRootNode()
		
		when: 'evaluated'
		Object result = new ExpressionEvaluator().eval(node)
		
		then: 'result is -2'
		result == -2
	}
	
	def '1 + 2 evaluates to 3'() {
		given: 'an Expression 1 + 2'
		Expression expr = new Expression().val(1).plus().val(2)
		Node node = new ExpressionTreeCreator(expr).create().getRootNode()
		
		when: 'evaluated'
		Object result = new ExpressionEvaluator().eval(node)
		
		then: 'result is 3'
		result == 3
	}
	
	def '1 + 2 * 3 evaluates to 7'() {
		given: 'an Expression 1 + 2 * 3'
		Expression expr = new Expression().val(1)
		.plus().val(2)
		.times().val(3)
		Node node = new ExpressionTreeCreator(expr).create().getRootNode()
		
		when: 'evaluated'
		Object result = new ExpressionEvaluator().eval(node)
		
		then: 'result is 7'
		result == 7
	}
	
	def '(1 + 2) * 3 evaluates to 9'() {
		given: 'an Expression (1 + 2) * 3'
		Expression expr = new Expression()
		.expr(new Expression().val(1)
			.plus().val(2))
		.times().val(3)
		Node node = new ExpressionTreeCreator(expr).create().getRootNode()
		
		when: 'evaluated'
		Object result = new ExpressionEvaluator().eval(node)
		
		then: 'result is 9'
		result == 9
	}
	
	def '4 * 3 - 2 evaluates to 10'() {
		given: 'an Expression 4 * (3 - 2)'
		Expression expr = new Expression().val(4)
		.times().val(3)
		.minus().val(2)
		Node node = new ExpressionTreeCreator(expr).create().getRootNode()
		
		when: 'evaluated'
		Object result = new ExpressionEvaluator().eval(node)
		
		then: 'result is 10'
		result == 10
	}
	
	def '4 * (3 - 2) evaluates to 4'() {
		given: 'an Expression 4 * (3 - 2)'
		Expression expr = new Expression().val(4)
		.times().expr(new Expression().val(3)
			.minus().val(2))
		Node node = new ExpressionTreeCreator(expr).create().getRootNode()
		
		when: 'evaluated'
		Object result = new ExpressionEvaluator().eval(node)
		
		then: 'result is 4'
		result == 4
	}
	
	def 'Commutative expressions 1 + 0.5 and 0.5 + 1 both evaluate to 1.5'() {
		given: 'Expressions 0.5 + 1 and 1 + 0.5'
		Expression expr1 = new Expression().val(1).plus().val(0.5)
		Expression expr2 = new Expression().val(0.5).plus().val(1)
		Node node1 = new ExpressionTreeCreator(expr1).create().getRootNode()
		Node node2 = new ExpressionTreeCreator(expr2).create().getRootNode()
		
		when: 'both are evaluated'
		Object result1 = new ExpressionEvaluator().eval(node1)
		Object result2 = new ExpressionEvaluator().eval(node2)
		
		then: 'result for both expressions is 1.5'
		result1 == 1.5
		result2 == 1.5
	}
	
	def 'Expression 1 > 2 && 3 < 4 is false'() {
		given: 'an Expression 1 > 2 && 3 < 4'
		Expression expr = new Expression().val(1).gt().val(2)
		.and().val(3).lt().val(4)
		Node node = new ExpressionTreeCreator(expr).create().getRootNode()
		
		when: 'evaluated'
		Object result = new ExpressionEvaluator().eval(node)
		
		then: 'result is false'
		result == false
	}
	
	def 'Expression 1 < 2 && 3 > 4 is false'() {
		given: 'an Expression 1 < 2 && 3 > 4'
		Expression expr = new Expression().val(1).lt().val(2)
		.and().val(3).gt().val(4)
		Node node = new ExpressionTreeCreator(expr).create().getRootNode()
		
		when: 'evaluated'
		Object result = new ExpressionEvaluator().eval(node)
		
		then: 'result is false'
		result == false
	}
	
	def 'Expression 1 < 2 && 3 < 4 is true'() {
		given: 'an Expression 1 < 2 && 3 > 4'
		Expression expr = new Expression().val(1).lt().val(2)
		.and().val(3).lt().val(4)
		Node node = new ExpressionTreeCreator(expr).create().getRootNode()
		
		when: 'evaluated'
		Object result = new ExpressionEvaluator().eval(node)
		
		then: 'result is true'
		result == true
	}
	
	def 'Expression 1 < 2 || 3 > 4 is true'() {
		given: 'an Expression 1 < 2 || 4 < 3'
		Expression expr = new Expression().val(1).lt().val(2)
		.or().val(3).gt().val(4)
		Node node = new ExpressionTreeCreator(expr).create().getRootNode()
		
		when: 'evaluated'
		Object result = new ExpressionEvaluator().eval(node)
		
		then: 'result is true'
		result == true
	}
	
	def 'Expression 1 > 2 || 3 < 4 is true'() {
		given: 'an Expression 1 > 2 || 3 < 4'
		Expression expr = new Expression().val(1).gt().val(2)
		.or().val(3).lt().val(4)
		Node node = new ExpressionTreeCreator(expr).create().getRootNode()
		
		when: 'evaluated'
		Object result = new ExpressionEvaluator().eval(node)
		
		then: 'result is true'
		result == true
	}
	
	def 'Expression 1 > 2 || 3 > 4 is false'() {
		given: 'an Expression 1 > 2 || 3 > 4'
		Expression expr = new Expression().val(1).gt().val(2)
		.or().val(3).gt().val(4)
		Node node = new ExpressionTreeCreator(expr).create().getRootNode()
		
		when: 'evaluated'
		Object result = new ExpressionEvaluator().eval(node)
		
		then: 'result is false'
		result == false
	}
	
	def 'Expression 1 < 2 || 3 > 4 && 5 > 6 is true'() {
		given: 'an Expression 1 < 2 || 3 > 4 && 5 > 6'
		Expression expr = new Expression().val(1).lt().val(2)
		.or().val(3).gt().val(4)
		.and().val(5).gt().val(6)
		Node node = new ExpressionTreeCreator(expr).create().getRootNode()
		
		when: 'evaluated'
		Object result = new ExpressionEvaluator().eval(node)
		
		then: 'result is true'
		result == true
	}

	def 'Expression (1 < 2 || 3 > 4) && 5 > 6 is false'() {
		given: 'an Expression (1 < 2 || 3 > 4) && 5 > 6'
		Expression expr = new Expression()
		.expr(new Expression().val(1).lt().val(2)
			.or().val(3).gt().val(4))
		.and().val(5).gt().val(6)
		Node node = new ExpressionTreeCreator(expr).create().getRootNode()
		
		when: 'evaluated'
		Object result = new ExpressionEvaluator().eval(node)
		
		then: 'result is false'
		result == false
	}
}
