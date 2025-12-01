package com.blind75.problems.common;

public final class TestConfigBuilder<I> {
  private I interfaceToTest;
  private InputAndOutput inputAndOutput;

  public TestConfigBuilder() {
  }

  public TestConfigBuilder<I> interfaceToTest(I interfaceToTest) {
    this.interfaceToTest = interfaceToTest;
    return this;
  }

  public TestConfigBuilder<I> inputAndOutput(InputAndOutput inputAndOutput) {
    this.inputAndOutput = inputAndOutput;
    return this;
  }

  public TestConfig<I> build() {
    return new TestConfig<>(interfaceToTest, inputAndOutput);
  }
}
