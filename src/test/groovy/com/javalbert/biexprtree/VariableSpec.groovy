package com.javalbert.biexprtree

import spock.lang.Specification

class VariableSpec extends Specification {
	def 'String Variable called "name"'() {
		given: 'a String Variable called "name"'
		Variable v = new Variable(String, 'name')
		
		expect: 'its type is equal to String.class'
		v.type == String
		
		and: 'its name is equal to "name"'
		v.name == 'name'
	}
	
	def 'String Variable is initialized with value of "Albert"'() {
		given: 'a String Variable initialized with value "Albert"'
		Variable v = new Variable(String, 'name', 'Albert')
		
		expect: 'its value is equal to "Albert"'
		v.value == 'Albert'
	}
	
	def 'Assigning Integer value to String Variable throws IllegalArgumentExcpetion'() {
		given: 'a String Variable'
		Variable v = new Variable(String, 'name')
		
		when: 'it is assigned an Integer value via setter'
		v.value = 123
		
		then: 'IllegalArgumentException is thrown'
		thrown(IllegalArgumentException)
	}
	
	def 'Constructor throws NPE when name is null'() {
		given: 'a Variable'
		Variable v = null
		
		when: 'it is initialized with a null name'
		v = new Variable(String, null)
		
		then: 'constructor threw NPE'
		thrown(NullPointerException)
	}
	
	def 'Constructor throws IllegalArgumentException when name contains invalid characters'() {
		given: 'a Variable'
		Variable v = null
		
		when: 'it is initialized with a name "!nvalid-name"'
		v = new Variable(String, '!nvalid-name')
		
		then: 'constructor threw IllegalArgumentException'
		thrown(IllegalArgumentException)
	}
}
