package com.javalbert.biexprtree;

public class CharOperand extends Operand<Character> {
	private char charValue;
	
	@Override
	public Character getValue() {
		return charValue;
	}
	
	@Override
	public void setValue(Character value) {
		charValue = value;
	}
	
	public char getCharValue() {
		return charValue;
	}
	
	public void setCharValue(char charValue) {
		this.charValue = charValue;
	}

	public CharOperand(char charValue) {
		super(char.class, null);
		this.charValue = charValue;
	}
	
	@Override
	public String toString() {
		return "[CharOperand " + String.valueOf(charValue) + "]";
	}
}
