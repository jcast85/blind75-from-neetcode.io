package com.blind75.problems.p17_kth_largest_element_in_a_stream;

import java.util.ArrayList;
import java.util.List;

public class KthLargestEfficient implements KthLargest {
  private final int k;
  private final List<Integer> nums;

  public KthLargestEfficient(int k, int[] nums) {
    this.k = k;
    this.nums = new ArrayList<>();
    for(int num : nums) {
      this.nums.add(num);
    }
  }

  @Override
  public int add(int val) {
    this.nums.add(val);
    List<Integer> kLargestValues = new ArrayList<>(k);
    for (int elem : nums) {
      boolean isUsed = false;
      for(int i = 0; i < k; i++) {
        if ((kLargestValues.size() < i+1 || kLargestValues.get(i) == null || elem > kLargestValues.get(i)) && !isUsed) {
          kLargestValues.add(i, elem);
          isUsed = true;
        }
      }
    }
    return kLargestValues.get(k - 1);
  }
}
