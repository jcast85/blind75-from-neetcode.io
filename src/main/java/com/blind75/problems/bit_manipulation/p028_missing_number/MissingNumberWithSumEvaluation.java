package com.blind75.problems.bit_manipulation.p028_missing_number;

public class MissingNumberWithSumEvaluation implements MissingNumber {
  @Override
  public int missingNumber(int[] nums) {
    int expectedSum = nums.length * (nums.length+1)/2;
    int actualSum = 0;
    for (int i=0; i<nums.length; i++) {
      actualSum += nums[i];
    }
    return expectedSum - actualSum;
  }
}
