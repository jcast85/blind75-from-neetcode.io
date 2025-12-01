package com.blind75.problems.common;

public record TestConfig<I>(I interfaceToTest, InputAndOutput inputAndOutput) {
  @Override
  public String toString() {
    return "InterfaceToTest: " + interfaceToTest + ", inputAndOutput: " + inputAndOutput;
  }
}
