package com.blind75.problems.stack.evaluate_reverse_polish_notation;

public class EvaluateReversePolishNotationCommonStaticMethods {
  static int calculate(Integer operand1, Integer operand2, String operator) {
    if (operand1 != null && operand2 != null && operator != null) {
      return switch (operator) {
        case "+" -> operand1 + operand2;
        case "-" -> operand1 - operand2;
        case "*" -> operand1 * operand2;
        case "/" -> operand1 / operand2;
        default -> 0;
      };
    }
    return 0;
  }
}
