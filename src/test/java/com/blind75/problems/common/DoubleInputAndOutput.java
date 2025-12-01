package com.blind75.problems.common;

public record DoubleInputAndOutput<I1, I2, O>(I1 input1, I2 input2, O output) implements InputAndOutput {
  @Override
  public String toString() {
    return "input1: " + input1 + ", input2: " + input2 + ", output: " + output;
  }
}
