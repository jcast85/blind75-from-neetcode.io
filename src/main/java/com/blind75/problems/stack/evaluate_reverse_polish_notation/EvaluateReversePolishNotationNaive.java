package com.blind75.problems.stack.evaluate_reverse_polish_notation;

public class EvaluateReversePolishNotationNaive implements EvaluateReversePolishNotation {
  @Override
  public int evalRPN(String[] tokens) {
    return evalRPN(tokens, 0, tokens.length-1).result;
  }

  private InnerCalculationOutput evalRPN(String[] tokens, int from, int to) {
    if (from == to) {
      return new InnerCalculationOutput(Integer.parseInt(tokens[from]), -1);
    }
    try {
      return new InnerCalculationOutput(Integer.parseInt(tokens[to]), to-1);
    } catch (Exception ignored) {}

    String operator = tokens[to];
    InnerCalculationOutput operand2innerCalculationOutput = evalRPN(tokens, from, to - 1);
    Integer operand2 = operand2innerCalculationOutput.result;
    InnerCalculationOutput operand1innerCalculationOutput = evalRPN(tokens, from, operand2innerCalculationOutput.lastUnusedIndex);
    Integer operand1 = operand1innerCalculationOutput.result;
    int calculate = EvaluateReversePolishNotationCommonStaticMethods.calculate(operand1, operand2, operator);
    return new InnerCalculationOutput(calculate, operand1innerCalculationOutput.lastUnusedIndex);
  }

  private record InnerCalculationOutput(int result, int lastUnusedIndex) {
  }
}
