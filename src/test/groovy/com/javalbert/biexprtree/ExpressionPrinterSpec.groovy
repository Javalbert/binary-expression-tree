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
	
	def 'Print variable name'() {
		given: 'a Variable named "x"'
		Variable x = new IntVariable('x')
		
		and: 'an Expression 1 + x'
		Expression expr = new Expression().val(1).plus().val(x)
		
		when: 'printed'
		String str = new ExpressionPrinter().print(expr)
		
		then: '1 + x is returned'
		str == '1 + x'
	}
	
	def 'Print variable value'() {
		given: 'a Variable named "x" with an integer value of 2'
		Variable x = new IntVariable('x', 2)
		
		and: 'an Expression 1 + x'
		Expression expr = new Expression().val(1).plus().val(x)
		
		and: 'an ExpressionPrinter configured to print values of Variables'
		ExpressionPrinter printer = new ExpressionPrinter()
		printer.setPrintVariableValues(true)
		
		when: 'printed'
		String str = printer.print(expr)
		
		then: '1 + 2 is returned'
		str == '1 + 2'
	}
	
	def 'Print value of string variable'() {
		given: 'a Variable named "name" with an string value of \'Albert "Javalbert" Chan\''
		Variable name = new RefVariable(String, 'name', 'Albert "Javalbert" Chan')
		
		and: 'an Expression'
		Expression expr = new Expression().val(name)
		
		and: 'an ExpressionPrinter configured to print values of Variables'
		ExpressionPrinter printer = new ExpressionPrinter()
		printer.setPrintVariableValues(true)
		
		when: 'printed'
		String str = printer.print(expr)
		
		then: '"Albert \\"Javalbert" Chan\\" is returned'
		str == '"Albert \\"Javalbert\\" Chan"'
	}
	
	def 'Expression string with unary operator and nested expression can be parsed back'() {
		given: '-1 * (2 + 3)'
		String exprString = '-1 * (2 + 3)'
		
		when: 'parsed'
		Expression expr = new ExpressionParser().parse(exprString)
		
		and: 'parsed Expression is printed'
		String exprString2 = new ExpressionPrinter().print(expr)
		
		then: 'the resulting expression string is equal to the original expression string: -1 * (2 + 3)'
		exprString == exprString2
	}
	
	def 'Expression string with a variable and quotes within string value can be parsed back'() {
		given: 'name = "Albert \\"Javalbert\\" Chan"'
		String exprString = 'name = "Albert \\"Javalbert\\" Chan"'
		
		when: 'parsed'
		ExpressionParser parser = new ExpressionParser()
		parser.addVariable(new RefVariable(String, 'name'))
		Expression expr = parser.parse(exprString)
		
		and: 'parsed Expression is printed'
		String exprString2 = new ExpressionPrinter().print(expr)
		
		then: 'the resulting expression string is equal to the original expression string: name = "Albert \\"Javalbert\\" Chan"'
		exprString == exprString2
	}
}
