package com.javalbert.biexprtree

import spock.lang.Specification

class EvaluateVariableSpec extends Specification {
	def 'Expression with integer variable evaluates to 3'() {
		given: 'integer variable called "myInt" with value 2'
		IntVariable intVar = new IntVariable('myInt', 2)
		
		and: 'expression 1 + myInt'
		Expression expr = new Expression()
		.val(1).plus().val(intVar)
		
		when: 'evaluated'
		Object result = ExpressionEvaluator.eval(expr)
		
		then: 'result is 3'
		result == 3
	}
	
	def 'Expression evaluates to 4 the first time then 6 the second time'() {
		given: 'integer variable called "myInt" with value 2'
		IntVariable intVar = new IntVariable('myInt', 2)
		
		and: 'expression 2 * myInt'
		Expression expr = new Expression()
		.val(2).times().val(intVar)
		
		and: 'expression tree root node and evaluator'
		Node node = new ExpressionTreeCreator(expr).create()
		ExpressionEvaluator evaluator = new ExpressionEvaluator()
		
		when: 'evaluated for the first time'
		Object result = evaluator.eval(node)
		
		then: 'result is 4'
		result == 4
		
		when: 'integer variable is changed to 3'
		intVar.setInt(3)
		
		and: 'evaluated for the second time'
		result = evaluator.eval(node)
		
		then: 'result is 6'
		result == 6
	}
	
	def 'Variable in nested expression changes result'() {
		given: 'integer variable called "myInt" with value 2'
		IntVariable intVar = new IntVariable('myInt', 2)
		
		and: 'expression (1 + myInt) * 3'
		Expression expr = new Expression()
		.expr(new Expression().val(1).plus().val(intVar))
		.times().val(3)
		
		and: 'expression tree root node and evaluator'
		Node node = new ExpressionTreeCreator(expr).create()
		ExpressionEvaluator evaluator = new ExpressionEvaluator()
		
		when: 'evaluated for the first time'
		Object result = evaluator.eval(node)
		
		then: 'result is 9'
		result == 9
		
		when: 'integer variable is changed to 3'
		intVar.setInt(3)
		
		and: 'evaluated for the second time'
		result = evaluator.eval(node)
		
		then: 'result is 12'
		result == 12
	}
}
