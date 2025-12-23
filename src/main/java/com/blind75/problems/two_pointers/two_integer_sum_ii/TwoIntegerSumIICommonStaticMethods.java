package com.blind75.problems.two_pointers.two_integer_sum_ii;

public class TwoIntegerSumIICommonStaticMethods {
  private TwoIntegerSumIICommonStaticMethods() {}

  static int[] returnIndex(int index1, int index2) {
    if(index1 < index2) {
      return new int[] {index1+1, index2+1};
    } else {
      return new int[] {index2+1, index1+1};
    }
  }
}
