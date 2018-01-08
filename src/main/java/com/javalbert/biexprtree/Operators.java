package com.javalbert.biexprtree;

public final class Operators {
	// Math operators
	//
	public static final BinaryOperatorNode ADD = new BinaryOperatorNode("+");
	public static final BinaryOperatorNode SUBTRACT = new BinaryOperatorNode("-");
	public static final BinaryOperatorNode MULTIPLY = new BinaryOperatorNode("*");
	public static final BinaryOperatorNode DIVIDE = new BinaryOperatorNode("/");
	public static final BinaryOperatorNode MODULO = new BinaryOperatorNode("%");
	public static final UnaryOperatorNode POWER = new UnaryOperatorNode("^");
	public static final UnaryOperatorNode NEGATE = new UnaryOperatorNode("-");
	
	// Boolean operators
	//
	public static final BinaryOperatorNode EQ = new BinaryOperatorNode("=");
	public static final BinaryOperatorNode NOTEQ = new BinaryOperatorNode("!=");
	public static final BinaryOperatorNode LT = new BinaryOperatorNode("<");
	public static final BinaryOperatorNode LTEQ = new BinaryOperatorNode("<=");
	public static final BinaryOperatorNode GT = new BinaryOperatorNode(">");
	public static final BinaryOperatorNode GTEQ = new BinaryOperatorNode(">=");
	public static final BinaryOperatorNode AND = new BinaryOperatorNode("&&");
	public static final BinaryOperatorNode OR = new BinaryOperatorNode("||");
	public static final UnaryOperatorNode NOT = new UnaryOperatorNode("!");
	
	private Operators() {}
}
