package com.javalbert.biexprtree;

import java.util.HashMap;
import java.util.Map;

public class FunctionRegistry {
	private final Map<String, Func> functions = new HashMap<>();
	
	public void register(BinaryFunc bifunc) {
		functions.put(bifunc.getOperator(), bifunc);
	}
	
	public void register(UnaryFunc ufunc) {
		functions.put(ufunc.getOperator(), ufunc);
	}
}
