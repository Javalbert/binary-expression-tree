# Binary Expression Tree

A [binary expression tree](https://en.wikipedia.org/wiki/Binary_expression_tree) library for Java.

## Design & Features

- Infix notation
- Supported types: `String, int, long, float, double, BigInteger, BigDecimal`
- Basic math operators: `+, -, /, *, %, ** (exponentiation)`
- Basic boolean operators: `&&, ||, =, !=, <, <=, >, >=`
- Unary operators: `-, !`
- Expressions are built by chaining method calls instead of passing a string
- Nested (i.e. parenthesized) expressions
- Variables are mutable objects that can change the result of the next evaluation
- User-definable functions based on operator and operands' type
- Order of operations for binary operators can be reordered
- Left-to-right evaluation
- Short-circuit evaluation
- Expression parser uses the same Expression API to build an expression
- Expression printer outputs strings that can be parsed back

## Installation

Gradle

```groovy
dependencies {
	api 'com.javalbert:binary-expression-tree:1.0.0'
}
```

or Maven

```xml
<dependency>
	<groupId>com.javalbert</groupId>
	<artifactId>binary-expression-tree</artifactId>
	<version>1.0.0</version>
</dependency>
```

## Basic Usage

Build expression, create tree, and evaluate:

```java
// -2 * (3 + 4)
Expression expr = new Expression()
.negate().val(2).times()
.expr(new Expression()
	.val(3).plus().val(4));

Node node = new ExpressionTreeCreator(expr).create();

// -14
Object result = new ExpressionEvaluator().eval(node);
```

Variables

```java
Variable<Integer> x = new IntVariable("x", 3);
// x ** 2
Expression expr = new Expression().val(x).powerOf().val(2);
// 9
Object result = new ExpressionEvaluator().eval(expr);
```

Parse expression from string:

```java
Expression expr = new ExpressionParser().parse("1 < 2 && 3 < 4");
```

Print expression:

```java
// 1 < 2 && 3 < 4
String exprString = new ExpressionPrinter().print(expr);
```
