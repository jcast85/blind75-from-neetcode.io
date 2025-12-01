package com.blind75.problems.common;

public final class SingleInputAndOutputBuilder<I, O> {
  private I input;
  private O output;

  public SingleInputAndOutputBuilder() {
  }

  public SingleInputAndOutputBuilder<I, O> input(I input) {
    this.input = input;
    return this;
  }

  public SingleInputAndOutputBuilder<I, O> output(O output) {
    this.output = output;
    return this;
  }

  public SingleInputAndOutput<I, O> build() {
    return new SingleInputAndOutput<>(input, output);
  }
}
