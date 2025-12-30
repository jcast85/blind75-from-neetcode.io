package com.blind75.problems.stack.evaluate_reverse_polish_notation;

public class EvaluateReversePolishNotationNaive implements EvaluateReversePolishNotation {
  @Override
  public int evalRPN(String[] tokens) {
    Integer result = null;
    int i = 0;
    Integer operand1 = null;
    Integer operand2 = null;
    String operator = null;
    while(i<tokens.length) {
      if(operand1 == null) {
        operand1 = Integer.parseInt(tokens[i]);
        i++;
        continue;
      }
      if(operand2 == null) {
        operand2 = Integer.parseInt(tokens[i]);
        i++;
        continue;
      }
      if(operator == null) {
        operator = tokens[i];
        i++;
      }
      if(operand1 != null && operand2 != null && operator != null) {
        switch (operator) {
          case "+": {
            result = operand1 + operand2;
            break;
          }
          case "-": {
            result = operand1 - operand2;
            break;
          }
          case "*": {
            result = operand1 * operand2;
            break;
          }
          case "/": {
            result = operand1 / operand2;
            break;
          }
        }
        operand1 = result;
        operand2 = null;
        operator = null;
      }
    }

    if(result == null) {
      return 0;
    }
    return result;
  }
}
