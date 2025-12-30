package com.blind75.problems.common;

public final class ZeroInputAndOutputBuilder<O> {
  private O output;

  public ZeroInputAndOutputBuilder() {
  }

  public ZeroInputAndOutputBuilder<O> output(O output) {
    this.output = output;
    return this;
  }

  public ZeroInputAndOutput<O> build() {
    return new ZeroInputAndOutput<>(output);
  }
}
