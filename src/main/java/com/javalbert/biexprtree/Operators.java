package com.javalbert.biexprtree;

public final class Operators {
	// Math operators
	//
	public static final BinaryOperatorDefinition ADD = new BinaryOperatorDefinition("+");
	public static final BinaryOperatorDefinition SUBTRACT = new BinaryOperatorDefinition("-");
	public static final BinaryOperatorDefinition MULTIPLY = new BinaryOperatorDefinition("*");
	public static final BinaryOperatorDefinition DIVIDE = new BinaryOperatorDefinition("/");
	public static final BinaryOperatorDefinition MODULO = new BinaryOperatorDefinition("%");
	public static final BinaryOperatorDefinition POWER = new BinaryOperatorDefinition("^");
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
