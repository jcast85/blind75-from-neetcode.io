package com.blind75.problems.p024_single_number;

public class SingleNumberWithXor implements SingleNumber {
  @Override
  public int singleNumber(int[] nums) {
    for (int i=1; i<nums.length; i++) {
      nums[i] ^= nums[i-1];
    }
    return nums[nums.length-1];
  }
}
