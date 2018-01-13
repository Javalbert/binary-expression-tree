package com.javalbert.biexprtree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class BinaryOperatorPrecedence {
	private static final Map<String, Integer> DEFAULT_OPERATOR_MAP;
	private static final List<Set<String>> DEFAULT_PRIORITY_LIST;

	private static List<Set<String>> createDefaultPriorityList() {
		List<Set<String>> priorityList = new ArrayList<>();
		
		priorityList.add(Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
				Operators.POWER.getOperator()
				))));
		
		priorityList.add(Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
				Operators.MULTIPLY.getOperator(),
				Operators.DIVIDE.getOperator(),
				Operators.MODULO.getOperator()
				))));
		
		priorityList.add(Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
				Operators.ADD.getOperator(),
				Operators.SUBTRACT.getOperator()
				))));

		priorityList.add(Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
				Operators.LT.getOperator(),
				Operators.LTEQ.getOperator(),
				Operators.GT.getOperator(),
				Operators.GTEQ.getOperator()
				))));
		
		priorityList.add(Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
				Operators.EQ.getOperator(),
				Operators.NOTEQ.getOperator()
				))));
		
		priorityList.add(Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
				Operators.AND.getOperator()
				))));
		
		priorityList.add(Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
				Operators.OR.getOperator()
				))));
		
		return priorityList;
	}
	
	private static Map<String, Integer> createDefaultPriorityMap() {
		Map<String, Integer> priorityMap = new HashMap<>();
		
		priorityMap.put(Operators.POWER.getOperator(), 0);
		
		priorityMap.put(Operators.MULTIPLY.getOperator(), 1);
		priorityMap.put(Operators.DIVIDE.getOperator(), 1);
		priorityMap.put(Operators.MODULO.getOperator(), 1);
		
		priorityMap.put(Operators.ADD.getOperator(), 2);
		priorityMap.put(Operators.SUBTRACT.getOperator(), 2);
		
		priorityMap.put(Operators.LT.getOperator(), 3);
		priorityMap.put(Operators.LTEQ.getOperator(), 3);
		priorityMap.put(Operators.GT.getOperator(), 3);
		priorityMap.put(Operators.GTEQ.getOperator(), 3);
		
		priorityMap.put(Operators.EQ.getOperator(), 4);
		priorityMap.put(Operators.NOTEQ.getOperator(), 4);
		
		priorityMap.put(Operators.AND.getOperator(), 5);
		
		priorityMap.put(Operators.OR.getOperator(), 6);
		
		return priorityMap;
	}
	
	static {
		DEFAULT_PRIORITY_LIST = Collections.unmodifiableList(createDefaultPriorityList());
		DEFAULT_OPERATOR_MAP = Collections.unmodifiableMap(createDefaultPriorityMap());
	}
	
	private List<Set<String>> priorityList = DEFAULT_PRIORITY_LIST;
	private Map<String, Integer> priorityMap = DEFAULT_OPERATOR_MAP;
	
	public int getPriority(String operator) {
		return Math.negateExact(priorityMap.get(operator));
	}
	
	public BinaryOperatorPrecedence move(String operator, int priority) {
		return move(operator, priority, true);
	}
	
	public BinaryOperatorPrecedence move(String operator, int priority, boolean siblings) {
		checkOperatorExistence(operator);
		priority = Math.abs(priority);
		
		int currentPriority = priorityMap.get(operator);
		int priorityComparison = Integer.compare(priority, currentPriority);
		boolean justRemoveSiblings = priorityComparison == 0 && !siblings && operatorHasSiblings(operator);
		boolean movingUp = priorityComparison < 0 && currentPriority > 0;
		boolean movingDown = priorityComparison > 0 && priority <= priorityList.size();
		
		if (!justRemoveSiblings && !movingUp && !movingDown) {
			return this;
		}
		initCollections();
		
		if (movingUp) {
			// remove from old priority
			//
			removeFromPriorityList(operator);
			
			// move to new priority
			//
			Set<String> operatorSet = priorityList.get(priority);
			operatorSet.add(operator);
			priorityMap.put(operator, priority);
			if (!siblings) {
				shiftOperatorsDown(operator);
			}
		} else if (movingDown) {
			// remove from old priority
			//
			if (removeFromPriorityList(operator)) {
				priority--;
			}
			
			// move to new priority
			//
			Set<String> operatorSet = priorityList.get(priority);
			operatorSet.add(operator);
			priorityMap.put(operator, priority);
			if (!siblings) {
				shiftOperatorsDown(operator);
			}
		} else if (justRemoveSiblings) {
			shiftOperatorsDown(operator);
		}
		
		return this;
	}
	
	private void checkOperatorExistence(String operator) {
		if (!priorityMap.containsKey(operator)) {
			throw new IllegalStateException("Operator " + operator + " does not exist."
					+ " Call add() method.");
		}
	}
	
	private void fixPriorityMap(int toPriority) {
		for (int priority = priorityList.size() - 1; priority >= toPriority; priority--) {
			for (String operator : priorityList.get(priority)) {
				priorityMap.put(operator, priority);
			}
		}
	}
	
	private void initCollections() {
		if (priorityList == DEFAULT_PRIORITY_LIST) {
			priorityList = priorityList.stream()
					.map(HashSet::new)
					.collect(toList());
		}
		if (priorityMap == DEFAULT_OPERATOR_MAP) {
			priorityMap = new HashMap<>(priorityMap);
		}
	}

	private boolean operatorHasSiblings(String operator) {
		int priority = priorityMap.get(operator);
		return priorityList.get(priority).size() > 1;
	}
	
	private boolean removeFromPriorityList(String operator) {
		int priority = priorityMap.get(operator);
		Set<String> operatorSet = priorityList.get(priority);
		operatorSet.remove(operator);
		
		if (operatorSet.isEmpty()) {
			priorityList.remove(priority);
			fixPriorityMap(priority);
			return true;
		}
		return false;
	}
	
	private void shiftOperatorsDown(String exceptOperator) {
		int priority = priorityMap.get(exceptOperator);
		Set<String> operatorSet = priorityList.get(priority);
		
		Set<String> subset = operatorSet.stream()
				.filter(operator -> !operator.equals(exceptOperator))
				.collect(Collectors.toSet());
		shiftOperatorsDown(subset, priority + 1);
	}
	
	private void shiftOperatorsDown(Set<String> operatorsFromAbove, int priority) {
		operatorsFromAbove.forEach(operator -> priorityMap.put(operator, priority));
		
		if (priority >= priorityList.size()) {
			priorityList.add(operatorsFromAbove);
		} else {
			Set<String> removedOperators = priorityList.set(priority, operatorsFromAbove);
			shiftOperatorsDown(removedOperators, priority + 1);
		}
	}
}
