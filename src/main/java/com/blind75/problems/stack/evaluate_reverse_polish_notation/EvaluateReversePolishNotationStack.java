package com.blind75.problems.stack.evaluate_reverse_polish_notation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EvaluateReversePolishNotationStack implements EvaluateReversePolishNotation {
  @Override
  public int evalRPN(String[] tokens) {
    java.util.Stack<Integer> stack = new java.util.Stack<>();
    Set<String> operators = new HashSet<>(List.of("+", "-", "*", "/"));
    for (String token : tokens) {
      if (operators.contains(token)) {
        int operand2 = stack.pop();
        int operand1 = stack.pop();
        stack.push(EvaluateReversePolishNotationCommonStaticMethods.calculate(operand1, operand2, token));
      } else {
        stack.push(Integer.parseInt(token));
      }
    }
    return stack.pop();
  }
}
