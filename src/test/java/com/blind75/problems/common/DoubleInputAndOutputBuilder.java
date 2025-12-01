package com.blind75.problems.common;

public final class DoubleInputAndOutputBuilder<I1, I2, O> {
  private I1 input1;
  private I2 input2;
  private O output;

  public DoubleInputAndOutputBuilder() {
  }

  public DoubleInputAndOutputBuilder<I1, I2, O> input1(I1 input1) {
    this.input1 = input1;
    return this;
  }

  public DoubleInputAndOutputBuilder<I1, I2, O> input2(I2 input2) {
    this.input2 = input2;
    return this;
  }

  public DoubleInputAndOutputBuilder<I1, I2, O> output(O output) {
    this.output = output;
    return this;
  }

  public DoubleInputAndOutput<I1, I2, O> build() {
    return new DoubleInputAndOutput<>(input1, input2, output);
  }
}
