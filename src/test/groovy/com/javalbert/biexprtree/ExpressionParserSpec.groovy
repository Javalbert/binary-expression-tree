package com.javalbert.biexprtree

import spock.lang.Specification
import spock.lang.Unroll

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
	
	@Unroll("Operator #expectedOperator is added")
	def 'Some operator is added'() {
		given: 'an expression with an operator'
		
		when: 'parsed'
		Expression expr = new ExpressionParser().parse(exprString)
		
		then: 'the operator was added'
		expr.getNodes()[1].getOperator() == expectedOperator
		
		where: 'an expression produces an operator'
		exprString	||	expectedOperator
		'1 + 2'		||	'+'
		'1 - 2'		||	'-'
		'1 * 2'		||	'*'
		'1 / 2'		||	'/'
		'1 % 2'		||	'%'
		'1 ** 2'	||	'**'
		'1 = 2'		||	'='
		'1 != 2'	||	'!='
		'1 < 2'		||	'<'
		'1 <= 2'	||	'<='
		'1 > 2'		||	'>'
		'1 >= 2'	||	'>='
	}
	
	def 'Additive inverse operator is added'() {
		given: '1 + -2'
		String exprString = '1 + -2'
		
		when: 'parsed'
		Expression expr = new ExpressionParser().parse(exprString)
		
		then: 'unary operator - was added'
		expr.getNodes()[2] instanceof UnaryOperatorDefinition
		expr.getNodes()[2].getOperator() == '-'
	}
	
	def 'Throw error when there is an invalid token'() {
		given: '"1 @ 2" where the at sign is the invalid token'
		String exprString = '1 @ 2'
		
		when: 'parsed'
		Expression expr = new ExpressionParser().parse(exprString)
		
		then: 'error was thrown'
		thrown(IllegalArgumentException)
	}
	
	def 'Throw error on unrecognized binary operator'() {
		given: '1 ! 2'
		String exprString = '1 ! 2'
		
		when: 'parsed'
		Expression expr = new ExpressionParser().parse(exprString)
		
		then: 'error was thrown'
		thrown(IllegalArgumentException)
	}
	
	def 'Throw error on unrecognized unary operator'() {
		given: '*1'
		String exprString = '*1'
		
		when: 'parsed'
		Expression expr = new ExpressionParser().parse(exprString)
		
		then: 'error was thrown'
		thrown(IllegalArgumentException)
	}
	
	def 'Unary operator is added as the first token'() {
		given: '-2'
		String exprString = '-2'
		
		when: 'parsed'
		Expression expr = new ExpressionParser().parse(exprString)
		
		then: 'first node is the additive inverse unary operator'
		expr.getNodes()[0] instanceof UnaryOperatorDefinition
		expr.getNodes()[0].getOperator() == '-'
	}
	
	def 'Custom binary operator was added'() {
		given: '1 @ 2'
		String exprString = '1 @ 2'
		
		and: 'a custom binary operator definition @'
		BinaryOperatorDefinition binaryOperator = new BinaryOperatorDefinition('@')
		
		when: 'the binary operator definition is added to the parser'
		ExpressionParser parser = new ExpressionParser()
		parser.addBinaryOperator(binaryOperator)
		
		and: 'then the expression "1 @ 2" is parsed'
		Expression expr = parser.parse(exprString)
		
		then: 'second node is the binary operator @'
		expr.getNodes()[1] == binaryOperator
	}
	
	def 'Custom unary operator was added'() {
		given: '*1'
		String exprString = '*1'
		
		and: 'a custom unary operator definition *'
		UnaryOperatorDefinition unaryOperator = new UnaryOperatorDefinition('*')
		
		when: 'the unary operator definition is added to the parser'
		ExpressionParser parser = new ExpressionParser()
		parser.addUnaryOperator(unaryOperator)
		
		and: 'then the expression "*1" is parsed'
		Expression expr = parser.parse(exprString)
		
		then: 'first node is the unary operator *'
		expr.getNodes()[0] == unaryOperator
	}
	
	def 'Variable was added'() {
		given: '1 + x'
		String exprString = '1 + x'
		
		and: 'Variable "x"'
		Variable x = new IntVariable('x')
		
		when: 'x is added to parser'
		ExpressionParser parser = new ExpressionParser()
		parser.addVariable(x)
		
		and: 'then the expression "1 + x" is parsed'
		Expression expr = parser.parse(exprString)
		
		then: 'second operand is a Variable named "x"'
		Operand operand = expr.getNodes()[2]
		operand.getValue() instanceof Variable
		operand.getValue().getName() == 'x'
	}
	
	def 'Nested expression is parsed'() {
		given: '(1 + 2) * 3'
		String exprString = '(1 + 2) * 3'
		
		when: 'parsed'
		Expression expr = new ExpressionParser().parse(exprString)
		
		then: 'first operand is an Expression object'
		Operand operand = expr.getNodes()[0]
		operand.getValue() instanceof Expression
	}
	
	def 'Second-level nested expression is parsed'() {
		given: '2 * (3 + 4 * (5 + 6))'
		String exprString = '2 * (3 + 4 * (5 + 6))'
		
		when: 'parsed'
		Expression expr = new ExpressionParser().parse(exprString)
		
		then: 'second-level nested expression was added'
		Expression nestedExpr1 = expr.getNodes()[2].getValue()
		nestedExpr1.getNodes()[4].getValue() instanceof Expression
	}
}
