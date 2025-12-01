package com.blind75.problems.common;

public record SingleInputAndOutput<I, O>(I input, O output) implements InputAndOutput {
  @Override
  public String toString() {
    return "input: " + input + ", output: " + output;
  }
}
