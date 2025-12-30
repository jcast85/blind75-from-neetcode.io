package com.blind75.problems.stack.minimum_stack;

public interface MinimumStack {
  void push(int val);

  void pop();

  int top();

  int getMin();
}
