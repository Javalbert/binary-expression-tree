package com.javalbert.biexprtree;

import java.util.HashMap;
import java.util.Map;

public class FunctionRegistry {
	private final Map<OperatorInfo, Func> functions = new HashMap<>();
	
	public <T, U> void register(BinaryFunc<T, U> bifunc) {
		functions.put(bifunc.getOperatorInfo(), bifunc);
	}
	
	public <T> void register(UnaryFunc<T> ufunc) {
		functions.put(ufunc.getOperatorInfo(), ufunc);
	}
}
