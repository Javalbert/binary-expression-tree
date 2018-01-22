package com.javalbert.biexprtree

import spock.lang.Specification

class ExpressionParserSpec extends Specification {
	def 'Parsed expression contains "foobar"'() {
		given: '"foobar"'
		String exprString = '"foobar"'
		
		when: 'parsed'
		Expression expr = new ExpressionParser().parse(exprString)
		
		then: 'Expression contained "foobar"'
		expr.getNodes()[0].getValue() == 'foobar'
	}
	
	def 'Parsed expression contains "Albert Shun-Dat Chan"'() {
		given: '"Albert Shun-Dat Chan"'
		String exprString = '"Albert Shun-Dat Chan"'
		
		when: 'parsed'
		Expression expr = new ExpressionParser().parse(exprString)
		
		then: 'Expression contains "Albert Shun-Dat Chan"'
		expr.getNodes()[0].getValue() == 'Albert Shun-Dat Chan'
	}
	
	def 'Parsed expression contains "Albert \\\"Javalbert\\\" Chan"'() {
		given: '"Albert \\\"Javalbert\\\" Chan"'
		String exprString = '"Albert \\\"Javalbert\\\" Chan"' // Albert "Javalbert" Chan
		
		when: 'parsed'
		Expression expr = new ExpressionParser().parse(exprString)
		
		then: 'Expression contains "Albert Shun-Dat Chan"'
		expr.getNodes()[0].getValue() == 'Albert "Javalbert" Chan'
	}
}
