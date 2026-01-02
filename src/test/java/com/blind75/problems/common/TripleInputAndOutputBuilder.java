package com.blind75.problems.common;

public final class TripleInputAndOutputBuilder<I1, I2, I3, O> {
  private I1 input1;
  private I2 input2;
  private I3 input3;
  private O output;

  public TripleInputAndOutputBuilder() {
  }

  public TripleInputAndOutputBuilder<I1, I2, I3, O> input1(I1 input1) {
    this.input1 = input1;
    return this;
  }

  public TripleInputAndOutputBuilder<I1, I2, I3, O> input2(I2 input2) {
    this.input2 = input2;
    return this;
  }

  public TripleInputAndOutputBuilder<I1, I2, I3, O> input3(I3 input3) {
    this.input3 = input3;
    return this;
  }

  public TripleInputAndOutputBuilder<I1, I2, I3, O> output(O output) {
    this.output = output;
    return this;
  }

  public TripleInputAndOutput<I1, I2, I3, O> build() {
    return new TripleInputAndOutput<>(input1, input2, input3, output);
  }
}
