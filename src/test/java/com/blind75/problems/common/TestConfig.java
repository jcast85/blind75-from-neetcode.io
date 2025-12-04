package com.blind75.problems.common;

public record TestConfig<I>(I implementationToTest, InputAndOutput inputAndOutput) {
  @Override
  public String toString() {
    return "InterfaceToTest: " + implementationToTest + ", inputAndOutput: " + inputAndOutput;
  }
}
