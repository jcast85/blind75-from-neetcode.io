package com.blind75.problems.common;

import java.util.List;

public final class ConstructorAndMethodTestConfigBuilder {
  private Class<?> implementationToTest;
  private InputAndOutput constructorInputAndOutput;
  private List<InputAndOutput> inputAndOutputList;

  private ConstructorAndMethodTestConfigBuilder() {
  }

  public static ConstructorAndMethodTestConfigBuilder builder() {
    return new ConstructorAndMethodTestConfigBuilder();
  }

  public ConstructorAndMethodTestConfigBuilder implementationToTest(Class<?> implementationToTest) {
    this.implementationToTest = implementationToTest;
    return this;
  }

  public ConstructorAndMethodTestConfigBuilder constructorInputAndOutput(
    InputAndOutput constructorInputAndOutput) {
    this.constructorInputAndOutput = constructorInputAndOutput;
    return this;
  }

  public ConstructorAndMethodTestConfigBuilder inputAndOutputList(
    List<InputAndOutput> inputAndOutputList) {
    this.inputAndOutputList = inputAndOutputList;
    return this;
  }

  public ConstructorAndMethodTestConfig build() {
    return new ConstructorAndMethodTestConfig(implementationToTest, constructorInputAndOutput,
      inputAndOutputList);
  }
}
