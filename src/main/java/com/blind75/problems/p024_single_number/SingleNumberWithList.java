package com.blind75.problems.p024_single_number;

public class SingleNumberWithList implements SingleNumber {
  @Override
  public int singleNumber(int[] nums) {
    java.util.List<Integer> list = new java.util.ArrayList<>();
    for (int num : nums) {
      if (!list.contains(num)) {
        list.add(num);
      } else {
        list.remove((Integer) num);
      }
    }
    return list.get(0);
  }
}
