package com.javalbert.biexprtree

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZonedDateTime

import spock.lang.Specification

class ExpressionSpec extends Specification {
	def 'boolean primitive operand is added'() {
		given: 'an Expression'
		Expression expr = new Expression()
		
		when: 'boolean primitive is added'
		expr.val((boolean)true)
		
		then: 'boolean operand was added'
		expr.getNodes().get(0).booleanValue == true
	}
	
	def 'char operand is added'() {
		given: 'an Expression'
		Expression expr = new Expression()
		
		when: 'char is added'
		expr.val('a' as char)
		
		then: 'char operand was added'
		expr.getNodes().get(0).charValue == 'a' as char
	}
	
	def 'double primitive operand is added'() {
		given: 'an Expression'
		Expression expr = new Expression()
		
		when: 'double primitive is added'
		expr.val((double)1.23d)
		
		then: 'double operand was added'
		expr.getNodes().get(0).doubleValue == 1.23d
	}
	
	def 'float primitive operand is added'() {
		given: 'an Expression'
		Expression expr = new Expression()
		
		when: 'float primitive is added'
		expr.val((float)1.23f)
		
		then: 'float operand was added'
		expr.getNodes().get(0).floatValue == 1.23f
	}
	
	def 'int operand is added'() {
		given: 'an Expression'
		Expression expr = new Expression()
		
		when: 'int is added'
		expr.val((int)123)
		
		then: 'int operand was added'
		expr.getNodes().get(0).intValue == 123
	}
	
	def 'long primitive operand is added'() {
		given: 'an Expression'
		Expression expr = new Expression()
		
		when: 'long primitive is added'
		expr.val((long)123L)
		
		then: 'long operand was added'
		expr.getNodes().get(0).longValue == 123L
	}
	
	def 'BigDecimal operand is added'() {
		given: 'an Expression'
		Expression expr = new Expression()
		
		when: 'BigDecimal is added'
		expr.val(1.23)
		
		then: 'BigDecimal operand was added'
		expr.getNodes().get(0).getValue() == 1.23
	}
	
	def 'BigInteger operand is added'() {
		given: 'an Expression'
		Expression expr = new Expression()
		
		when: 'BigInteger is added'
		expr.val(123G)
		
		then: 'BigInteger operand was added'
		expr.getNodes().get(0).getValue() == 123G
	}
	
	def 'Date operand is added'() {
		given: 'an Expression'
		Expression expr = new Expression()
		
		when: 'Date is added'
		Date date = new Date().parse('yyyy-MM-dd HH:mm:ss.SSS', '2018-01-14 11:34:43.986')
		expr.val(date)
		
		then: 'Date operand was added'
		expr.getNodes().get(0).getValue() == new Date().parse('yyyy-MM-dd HH:mm:ss.SSS', '2018-01-14 11:34:43.986')
	}
	
	def 'LocalDate operand is added'() {
		given: 'an Expression'
		Expression expr = new Expression()
		
		when: 'LocalDate is added'
		expr.val(LocalDate.of(2018, 1, 14))
		
		then: 'LocalDate operand was added'
		expr.getNodes().get(0).getValue() == LocalDate.of(2018, 1, 14)
	}
	
	def 'LocalDateTime operand is added'() {
		given: 'an Expression'
		Expression expr = new Expression()
		
		when: 'LocalDateTime is added'
		expr.val(LocalDateTime.of(2018, 1, 14, 11, 38))
		
		then: 'LocalDateTime operand was added'
		expr.getNodes().get(0).getValue() == LocalDateTime.of(2018, 1, 14, 11, 38)
	}
	
	def 'String operand is added'() {
		given: 'an Expression'
		Expression expr = new Expression()
		
		when: 'String is added'
		expr.val('this library is awesome')
		
		then: 'String operand was added'
		expr.getNodes().get(0).getValue() == 'this library is awesome'
	}
	
	def 'Variable operand is added'() {
		given: 'an Expression'
		Expression expr = new Expression()
		
		when: 'Variable is added'
		Variable<String> fullName = new RefVariable<>(String, 'fullName', 'Albert Shun-Dat Chan')
		expr.val(fullName)
		
		then: 'Variable operand was added'
		expr.getNodes().get(0).getValue() == new RefVariable<>(String, 'fullName', 'Albert Shun-Dat Chan')
	}
	
	def 'ZonedDateTime operand is added'() {
		given: 'an Expression'
		Expression expr = new Expression()
		
		when: 'ZonedDateTime is added'
		expr.val(ZonedDateTime.of(2018, 1, 14, 11, 54, 51, 0, ZoneId.of('America/Toronto')))
		
		then: 'ZonedDateTime operand was added'
		expr.getNodes().get(0).getValue() == ZonedDateTime.of(2018, 1, 14, 11, 54, 51, 0, ZoneId.of('America/Toronto'))
	}
	
	def 'Expression operand is added'() {
		given: 'an Expression'
		Expression expr = new Expression()
		
		when: 'another Expression is added as a nested expression'
		expr.expr(new Expression())
		
		then: 'Expression operand was added'
		expr.getNodes().get(0).getValue() instanceof Expression
	}
	
	def 'Expression -1 + 2 added as individual nodes instead of nesting the expression'() {
		given: 'an Expression'
		Expression expr = new Expression()
		
		when: 'Expression -1 + 2 is added as individual nodes'
		expr.flatExpr(new Expression().negate().val(1).plus().val(2))
		
		then: 'first node is unary operator -'
		expr.getNodes().get(0).getOperator() == '-'
		
		and: 'second node is operand 1'
		expr.getNodes().get(1).getValue() == 1
		
		and: 'third node is binary operator +'
		expr.getNodes().get(2).getOperator() == '+'
		
		and: 'fourth node is operand 2'
		expr.getNodes().get(3).getValue() == 2
	}
	
	def 'Variable retrieved from Expression after inserting it'() {
		given: 'an Expression'
		Expression expr = new Expression()
		
		expect: 'Expression does not have a Variable called "fullName"'
		expr.getVariable('fullName') == null
		
		when: 'Variable called "fullName" is added'
		Variable<String> fullName = new RefVariable<>(String, 'fullName', 'Albert Shun-Dat Chan')
		expr.val(fullName)
		
		then: 'Variable called "fullName" can be retrieved by its name, from the Expression'
		expr.getVariable('fullName') != null
	}
	
	def 'Throw error when Expression added to general val() method'() {
		given: 'an Expression'
		Expression expr = new Expression()
		
		when: 'another Expression is added by invoking general val() method'
		expr.val(expr, Expression)
		
		then: 'error is thrown'
		thrown(IllegalArgumentException)
	}
	
	def 'Variable operand is added via general val() method'() {
		given: 'An Expression'
		Expression expr = new Expression()
		
		when: 'Variable is added by invoking general val() method'
		Variable<String> fullName = new RefVariable<>(String, 'fullName', 'Albert Shun-Dat Chan')
		expr.val(fullName, RefVariable)
		
		then: 'Variable operand was added'
		expr.getNodes().get(0).getValue() == new RefVariable<>(String, 'fullName', 'Albert Shun-Dat Chan')
	}
	
	def 'boolean primitive operand is added via general val() method'() {
		given: 'an Expression'
		Expression expr = new Expression()
		
		when: 'boolean primitive is added by invoking general val() method'
		expr.val((boolean)true, boolean)
		
		then: 'boolean operand was added'
		expr.getNodes().get(0).booleanValue == true
	}
	
	def 'char operand is added via general val() method'() {
		given: 'an Expression'
		Expression expr = new Expression()
		
		when: 'char is added by invoking general val() method'
		expr.val('a' as char, char)
		
		then: 'char operand was added'
		expr.getNodes().get(0).charValue == 'a' as char
	}
	
	def 'double primitive operand is added via general val() method'() {
		given: 'an Expression'
		Expression expr = new Expression()
		
		when: 'double primitive is added by invoking general val() method'
		expr.val((double)1.23d, double)
		
		then: 'double operand was added'
		expr.getNodes().get(0).doubleValue == 1.23d
	}
	
	def 'float primitive operand is added via general val() method'() {
		given: 'an Expression'
		Expression expr = new Expression()
		
		when: 'float primitive is added by invoking general val() method'
		expr.val((float)1.23f, float)
		
		then: 'float operand was added'
		expr.getNodes().get(0).floatValue == 1.23f
	}
	
	def 'int operand is added via general val() method'() {
		given: 'an Expression'
		Expression expr = new Expression()
		
		when: 'int is added by invoking general val() method'
		expr.val((int)123, int)
		
		then: 'int operand was added'
		expr.getNodes().get(0).intValue == 123
	}
	
	def 'long primitive operand is added via general val() method'() {
		given: 'an Expression'
		Expression expr = new Expression()
		
		when: 'long primitive is added by invoking general val() method'
		expr.val((long)123L, long)
		
		then: 'long operand was added'
		expr.getNodes().get(0).longValue == 123L
	}
	
	def 'List object operand is added via general val() method'() {
		given: 'an Expression'
		Expression expr = new Expression()
		
		when: 'a List object is added by invoking general val() method'
		expr.val([ 1, 2, 3 ], ArrayList)
		
		then: 'long operand was added'
		expr.getNodes().get(0).getValue() == [ 1, 2, 3 ]
	}
	
	def 'Plus operator is added'() {
		given: 'an Expression'
		Expression expr = new Expression()
		
		when: 'plus operator is added'
		expr.plus()
		
		then: '+ operator was added'
		expr.getNodes().get(0).getOperator() == '+'
	}
	
	def 'Minus operator is added'() {
		given: 'an Expression'
		Expression expr = new Expression()
		
		when: 'minus operator is added'
		expr.minus()
		
		then: '- operator was added'
		expr.getNodes().get(0).getOperator() == '-'
	}
	
	def 'Multiply operator is added'() {
		given: 'an Expression'
		Expression expr = new Expression()
		
		when: 'multiply operator is added'
		expr.times()
		
		then: '* operator was added'
		expr.getNodes().get(0).getOperator() == '*'
	}
	
	def 'Divide operator is added'() {
		given: 'an Expression'
		Expression expr = new Expression()
		
		when: 'divide operator is added'
		expr.dividedBy()
		
		then: '/ operator was added'
		expr.getNodes().get(0).getOperator() == '/'
	}
	
	def 'Modulo operator is added'() {
		given: 'an Expression'
		Expression expr = new Expression()
		
		when: 'modulo operator is added'
		expr.modulo()
		
		then: '% operator was added'
		expr.getNodes().get(0).getOperator() == '%'
	}
	
	def 'Exponentiation operator is added'() {
		given: 'an Expression'
		Expression expr = new Expression()
		
		when: 'exponentiation operator is added'
		expr.powerOf()
		
		then: '** operator was added'
		expr.getNodes().get(0).getOperator() == '**'
	}
	
	def 'Additive inverse operator is added'() {
		given: 'an Expression'
		Expression expr = new Expression()
		
		when: 'additive inverse operator is added'
		expr.negate()
		
		then: '- operator was added'
		expr.getNodes().get(0).getOperator() == '-'
	}
	
	def 'Equals operator is added'() {
		given: 'an Expression'
		Expression expr = new Expression()
		
		when: 'equals operator is added'
		expr.eq()
		
		then: '= operator was added'
		expr.getNodes().get(0).getOperator() == '='
	}
	
	def 'Not equals operator is added'() {
		given: 'an Expression'
		Expression expr = new Expression()
		
		when: 'not equals operator is added'
		expr.noteq()
		
		then: '!= operator was added'
		expr.getNodes().get(0).getOperator() == '!='
	}
	
	def 'Less-than operator is added'() {
		given: 'an Expression'
		Expression expr = new Expression()
		
		when: 'less-than operator is added'
		expr.lt()
		
		then: '< operator was added'
		expr.getNodes().get(0).getOperator() == '<'
	}
	
	def 'Less-than equals operator is added'() {
		given: 'an Expression'
		Expression expr = new Expression()
		
		when: 'less-than equals operator is added'
		expr.lteq()
		
		then: '<= operator was added'
		expr.getNodes().get(0).getOperator() == '<='
	}
	
	def 'Greater-than operator is added'() {
		given: 'an Expression'
		Expression expr = new Expression()
		
		when: 'greater-than operator is added'
		expr.gt()
		
		then: '> operator was added'
		expr.getNodes().get(0).getOperator() == '>'
	}
	
	def 'Greater-than equals operator is added'() {
		given: 'an Expression'
		Expression expr = new Expression()
		
		when: 'greater-than equals operator is added'
		expr.gteq()
		
		then: '>= operator was added'
		expr.getNodes().get(0).getOperator() == '>='
	}
	
	def 'Logical AND operator is added'() {
		given: 'an Expression'
		Expression expr = new Expression()
		
		when: 'logical AND operator is added'
		expr.and()
		
		then: '&& operator was added'
		expr.getNodes().get(0).getOperator() == '&&'
	}
	
	def 'Logical OR operator is added'() {
		given: 'an Expression'
		Expression expr = new Expression()
		
		when: 'logical OR operator is added'
		expr.or()
		
		then: '|| operator was added'
		expr.getNodes().get(0).getOperator() == '||'
	}
	
	def 'Logical NOT operator is added'() {
		given: 'an Expression'
		Expression expr = new Expression()
		
		when: 'logical NOT operator is added'
		expr.not()
		
		then: '! operator was added'
		expr.getNodes().get(0).getOperator() == '!'
	}
	
	def 'Variable of nested Expression is retrievable from containing Expression'() {
		given: 'a Variable named "myVar"'
		IntVariable myVar = new IntVariable('myVar')
		
		when: 'a Expression 1 + (myVar) is created'
		Expression expr = new Expression().val(1)
		.plus().expr(new Expression().val(myVar))
		
		then: 'Variable "myVar" can be retrieved from containing Expression'
		expr.getVariable('myVar') != null
	}
	
	def 'Throw error if nested Expression contains a different Variable with the same name as containing Expression'() {
		given: 'two Variables with the same name "myVar"'
		IntVariable myVar1 = new IntVariable('myVar')
		IntVariable myVar2 = new IntVariable('myVar')
		
		and: 'an unfinished Expression myVar +'
		Expression expr = new Expression().val(myVar1).plus()
		
		when: 'nested Expression (myVar) is added'
		expr.expr(new Expression().val(myVar2))
		
		then: 'error was thrown'
		thrown(IllegalStateException)
	}
	
	def 'Nested Expression is not mutatable after its been added to a containing Expression'() {
		given: 'the nested Expression 1 + 2'
		Expression nestedExpr = new Expression().val(1).plus().val(2)
		
		and: 'the containing Expression (1 + 2) * 3'
		Expression expr = new Expression().expr(nestedExpr).times().val(3)
		
		when: '+ 3 is added to the nested Expression 1 + 2'
		nestedExpr.plus().val(3)
		
		then: 'the nested Expression inside the containing Expression still has the 3 nodes of 1, +, and 2'
		Operand operandWithNestedExpr = expr.getNodes()[0]
		operandWithNestedExpr.getValue().getNodes().size() == 3
	}
	
	def 'Nested Expression is added as an individual node after the containing Expression has been "flattened" into another Expression'() {
		given: 'a containing Expression (1 + 2) * 3 where the 1 + 2 is the nested expression'
		Expression containingExpr = new Expression()
		.expr(new Expression().val(1).plus().val(2))
		.times().val(3)
		
		and: 'an unfinished Expression 4 +'
		Expression expr = new Expression().val(4).plus()
		
		when: 'the containing Expression is "flattened" into the unfinished Expression where the latter becomes 4 + (1 + 2) * 3'
		expr.flatExpr(containingExpr)
		
		then: 'the now finished Expression\'s third node is the nested Expression 1 + 2'
		Expression nestedExpr = expr.getNodes()[2].getValue()
		nestedExpr.getNodes()[0].getValue() == 1
		nestedExpr.getNodes()[1].getOperator() == '+'
		nestedExpr.getNodes()[2].getValue() == 2
	}
}
