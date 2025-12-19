package com.blind75.problems.bit_manipulation.p024_single_number;

public class SingleNumberWithSet implements SingleNumber {
  @Override
  public int singleNumber(int[] nums) {
    java.util.Set<Integer> list = new java.util.HashSet<>();
    for (int num : nums) {
      if (!list.contains(num)) {
        list.add(num);
      } else {
        list.remove(num);
      }
    }
    return list.iterator().next();
  }
}
