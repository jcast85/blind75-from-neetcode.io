package com.blind75.problems.stack.minimum_stack;

import java.util.*;

public class MinimumStackNaive implements MinimumStack {
  private final List<Integer> minValueIndexList;
  private final Map<Integer, Integer> stack;

  public MinimumStackNaive() {
    minValueIndexList = new ArrayList<>();
    stack = new HashMap<>();
  }

  @Override
  public void push(int val) {
    int key = stack.size();
    stack.put(key, val);
    if(minValueIndexList.isEmpty()) {
      minValueIndexList.add(key);
    } else {
      if(val < stack.get(minValueIndexList.getLast())) {
        minValueIndexList.add(key);
      }
    }
  }

  @Override
  public void pop() {
    int key = stack.size() - 1;
    stack.remove(key);
    if(minValueIndexList.getLast() == key) {
      minValueIndexList.removeLast();
    }
  }

  @Override
  public int top() {
    return stack.get(stack.size()-1);
  }

  @Override
  public int getMin() {
    if(minValueIndexList.isEmpty()) {
      return 0;
    }
    return stack.get(minValueIndexList.getLast());
  }
}
