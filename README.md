# Binary Expression Tree

A [binary expression tree](https://en.wikipedia.org/wiki/Binary_expression_tree) library for Java.

## Design & Features

- Infix notation
- Supported types: `String, int, long, float, double, BigInteger, BigDecimal`
- Basic math operators: `+, -, /, *, %, ** (exponentiation)`
- Basic boolean operators: `=, !=, <, <=, >, >=`
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
