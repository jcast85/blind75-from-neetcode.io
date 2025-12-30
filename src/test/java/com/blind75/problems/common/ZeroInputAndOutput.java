package com.blind75.problems.common;

public record ZeroInputAndOutput<O>(O output) implements InputAndOutput {
  @Override
  public String toString() {
    return "output: " + output;
  }
}
