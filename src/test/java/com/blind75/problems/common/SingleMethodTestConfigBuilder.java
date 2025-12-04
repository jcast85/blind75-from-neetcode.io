package com.blind75.problems.common;

public final class SingleMethodTestConfigBuilder<I> {
  private I implementationToTest;
  private InputAndOutput inputAndOutput;

  public SingleMethodTestConfigBuilder() {
  }

  public SingleMethodTestConfigBuilder<I> implementationToTest(I interfaceToTest) {
    this.implementationToTest = interfaceToTest;
    return this;
  }

  public SingleMethodTestConfigBuilder<I> inputAndOutput(InputAndOutput inputAndOutput) {
    this.inputAndOutput = inputAndOutput;
    return this;
  }

  public SingleMethodTestConfig<I> build() {
    return new SingleMethodTestConfig<>(implementationToTest, inputAndOutput);
  }
}
