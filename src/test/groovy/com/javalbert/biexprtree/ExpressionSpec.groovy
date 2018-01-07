package com.javalbert.biexprtree

import spock.lang.Specification

import static com.javalbert.biexprtree.Expression.*;

class ExpressionSpec extends Specification {
	def 'Static method newExpr() returns new Expression object'() {
		given: 'a declared Expression variable'
		Expression expr = null
		
		when: 'newExpr() is called'
		expr = newExpr()
		
		then: 'the variable is assigned the new Expression'
		expr != null
	}
}
