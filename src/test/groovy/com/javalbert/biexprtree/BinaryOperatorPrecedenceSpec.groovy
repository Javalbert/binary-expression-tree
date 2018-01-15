package com.javalbert.biexprtree

import spock.lang.Specification

import static com.javalbert.biexprtree.Expression.*;

class BinaryOperatorPrecedenceSpec extends Specification {
	def 'Move addition + up to the same priority as multiplication *'() {
		given: 'a BinaryOperatorPrecendence'
		BinaryOperatorPrecedence operatorPrecedence = new BinaryOperatorPrecedence()
		
		expect: 'by default, addition has lower priority than multiplication'
		operatorPrecedence.getPriority('+') < operatorPrecedence.getPriority('*')
		
		when: 'addition is moved up to multiplication'
		operatorPrecedence.move('+', operatorPrecedence.getPriority('*'))
		
		then: 'addition has the same priority as multiplication'
		operatorPrecedence.getPriority('+') == operatorPrecedence.getPriority('*')
	}
	
	def 'Move power ** down to the same priority as multiplication *'() {
		given: 'a BinaryOperatorPrecendence'
		BinaryOperatorPrecedence operatorPrecedence = new BinaryOperatorPrecedence()
		
		expect: 'by default, power has higher priority than multiplication'
		operatorPrecedence.getPriority('**') > operatorPrecedence.getPriority('*')
		
		when: 'power is moved down to multiplication'
		operatorPrecedence.move('**', operatorPrecedence.getPriority('*'))
		
		then: 'power has the same priority as multiplication'
		operatorPrecedence.getPriority('**') == operatorPrecedence.getPriority('*')
	}
	
	def 'Move priorities of multiplication\'s siblings down, and division/modulo will have less priority than multiplication'() {
		given: 'a BinaryOperatorPrecendence'
		BinaryOperatorPrecedence operatorPrecedence = new BinaryOperatorPrecedence()
		
		expect: 'division/modulo operators have the same priority as multiplication'
		operatorPrecedence.getPriority('/') == operatorPrecedence.getPriority('*')
		operatorPrecedence.getPriority('%') == operatorPrecedence.getPriority('*')
		
		when: 'priority of multiplication\'s sibling operators are moved down'
		operatorPrecedence.move('*', operatorPrecedence.getPriority('*'), false)
		
		then: 'division/modulo operators have less priority than multiplication'
		operatorPrecedence.getPriority('/') < operatorPrecedence.getPriority('*')
		operatorPrecedence.getPriority('%') < operatorPrecedence.getPriority('*')
	}
}
