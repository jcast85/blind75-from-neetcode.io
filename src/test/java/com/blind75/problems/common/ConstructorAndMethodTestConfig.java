package com.blind75.problems.common;

import java.util.List;
import java.util.stream.Collectors;

public record ConstructorAndMethodTestConfig(Class<?> implementationToTest, InputAndOutput constructorInputAndOutput, List<InputAndOutput> inputAndOutputList) {
  @Override
  public String toString() {
    return "ImplementationToTest: " + implementationToTest + ", constructorInputAndOutput: " + constructorInputAndOutput + ", inputAndOutputList: " + inputAndOutputList.stream().map(InputAndOutput::toString).collect(Collectors.joining(", "));
  }
}
