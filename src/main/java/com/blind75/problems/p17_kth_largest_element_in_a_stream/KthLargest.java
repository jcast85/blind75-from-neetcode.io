package com.blind75.problems.p17_kth_largest_element_in_a_stream;

public class KthLargest {
  private int k;
  private int[] nums;

  public KthLargest(int k, int[] nums) {
    this.k = k;
    this.nums = nums;
  }

  public int add(int val) {
    this.nums = insertTail(this.nums, val);
    Integer[] kLargestValues = new Integer[k];
    for (int elem : nums) {
      boolean isUsed = false;
      for(int i = 0; i < k; i++) {
        if ((kLargestValues[i] == null || elem > kLargestValues[i]) && !isUsed) {
          kLargestValues = push(kLargestValues, elem, i);
          isUsed = true;
        }
      }
    }
    return kLargestValues[k - 1];
  }

  private int[] insertTail(int[] nums, int val) {
    int[] newNums = new int[nums.length + 1];
    System.arraycopy(nums, 0, newNums, 0, nums.length);
    newNums[nums.length] = val;
    return newNums;
  }

  private Integer[] push(Integer[] kLargestValues, int elem, int startIndex) {
    for (int i = kLargestValues.length - 1; i > startIndex; i--) {
      kLargestValues[i] = kLargestValues[i - 1];
    }
    kLargestValues[startIndex] = elem;
    return kLargestValues;
  }
}
