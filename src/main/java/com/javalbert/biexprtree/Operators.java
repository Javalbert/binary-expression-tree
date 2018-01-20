/*
   Copyright 2018 Albert Shun-Dat Chan

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

 */
package com.javalbert.biexprtree;

public final class Operators {
	// Math operators
	//
	public static final BinaryOperatorDefinition ADD = new BinaryOperatorDefinition("+");
	public static final BinaryOperatorDefinition SUBTRACT = new BinaryOperatorDefinition("-");
	public static final BinaryOperatorDefinition MULTIPLY = new BinaryOperatorDefinition("*");
	public static final BinaryOperatorDefinition DIVIDE = new BinaryOperatorDefinition("/");
	public static final BinaryOperatorDefinition MODULO = new BinaryOperatorDefinition("%");
	public static final BinaryOperatorDefinition POWER = new BinaryOperatorDefinition("**");
	public static final UnaryOperatorDefinition NEGATE = new UnaryOperatorDefinition("-");
	
	// Boolean operators
	//
	public static final BinaryOperatorDefinition EQ = new BinaryOperatorDefinition("=");
	public static final BinaryOperatorDefinition NOTEQ = new BinaryOperatorDefinition("!=");
	public static final BinaryOperatorDefinition LT = new BinaryOperatorDefinition("<");
	public static final BinaryOperatorDefinition LTEQ = new BinaryOperatorDefinition("<=");
	public static final BinaryOperatorDefinition GT = new BinaryOperatorDefinition(">");
	public static final BinaryOperatorDefinition GTEQ = new BinaryOperatorDefinition(">=");
	public static final BinaryOperatorDefinition AND = new BinaryOperatorDefinition("&&");
	public static final BinaryOperatorDefinition OR = new BinaryOperatorDefinition("||");
	public static final UnaryOperatorDefinition NOT = new UnaryOperatorDefinition("!");
	
	private Operators() {}
}
