package com.blind75.problems.common;

public record TripleInputAndOutput<I1, I2, I3, O>(I1 input1, I2 input2, I3 input3, O output) implements InputAndOutput {
  @Override
  public String toString() {
    return "input1: " + input1 + ", input2: " + input2 + ", input3: " + input3 + ", output: " + output;
  }
}
