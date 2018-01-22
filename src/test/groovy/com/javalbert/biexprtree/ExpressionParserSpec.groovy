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
	
	def 'Parsed expression contains integer value 123'() {
		given: '123'
		String exprString = '123'
		
		when: 'parsed'
		Expression expr = new ExpressionParser().parse(exprString)
		
		then: 'Expression contains integer value 123'
		expr.getNodes()[0].getValue() == 123
	}
	
	def 'Parsed expression contains long value 2147483648'() {
		given: '2147483648'
		String exprString = '2147483648'
		
		when: 'parsed'
		Expression expr = new ExpressionParser().parse(exprString)
		
		then: 'Expression contains long value 2147483648'
		expr.getNodes()[0].getValue() == 2147483648L
	}
	
	def 'Parsed expression contains float value 1.23'() {
		given: '1.23'
		String exprString = '1.23'
		
		when: 'parsed'
		Expression expr = new ExpressionParser().parse(exprString)
		
		then: 'Expression contains float value 1.23'
		expr.getNodes()[0].getValue() == 1.23f
	}
	
	def 'Parsed expression contains double value 123E8'() {
		given: '123E8'
		String exprString = '123E8'
		
		when: 'parsed'
		Expression expr = new ExpressionParser().parse(exprString)
		
		then: 'Expression contains double value 123E8'
		expr.getNodes()[0].getValue() == 123E8
	}
	
	def 'Parsed expression contains BigInteger 9223372036854775808'() {
		given: '9223372036854775808'
		String exprString = '9223372036854775808'
		
		when: 'parsed'
		Expression expr = new ExpressionParser().parse(exprString)
		
		then: 'Expression contains BigInteger 9223372036854775808'
		expr.getNodes()[0].getValue() == 9223372036854775808
	}
	
	def 'Parsed expression contains BigDecimal 1234567890E300'() {
		given: '1234567890E300'
		String exprString = '1234567890E300'
		
		when: 'parsed'
		Expression expr = new ExpressionParser().parse(exprString)
		
		then: 'Expression contains BigDecimal 1234567890E300'
		expr.getNodes()[0].getValue() == 1234567890E300
	}
}
