package com.javalbert.biexprtree

import spock.lang.Specification

class ExpressionPrinterSpec extends Specification {
	def 'Prints "foobar"'() {
		given: 'an Expression "foobar"'
		Expression expr = new Expression().val('foobar')
		
		when: 'printed'
		String str = new ExpressionPrinter().print(expr)
		
		then: '"foobar" (including the quotes) is returned'
		str == '"foobar"'
	}
	
	def 'Prints 1 + 2'() {
		given: 'an Expression 1 + 2'
		Expression expr = new Expression().val(1).plus().val(2)
		
		when: 'printed'
		String str = new ExpressionPrinter().print(expr)
		
		then: '1 + 2 is returned'
		str == '1 + 2'
	}
	
	def 'Prints unary operator'() {
		given: 'an Expression -2'
		Expression expr = new Expression().negate().val(2)
		
		when: 'printed'
		String str = new ExpressionPrinter().print(expr)
		
		then: '-2 is returned'
		str == '-2'
	}
	
	def 'Prints 1 + -2'() {
		given: 'an Expression 1 + -2'
		Expression expr = new Expression().val(1)
		.plus().negate().val(2)
		
		when: 'printed'
		String str = new ExpressionPrinter().print(expr)
		
		then: '1 + -2 is returned'
		str == '1 + -2'
	}
	
	def 'Prints nested expression'() {
		given: 'an Expression 2 * (3 + 4)'
		Expression expr = new Expression()
		.val(2).times()
		.expr(new Expression().val(3).plus().val(4))
		
		when: 'printed'
		String str = new ExpressionPrinter().print(expr)
		
		then: '2 * (3 + 4) is returned'
		str == '2 * (3 + 4)'
	}
}
