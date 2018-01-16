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
}
