package com.blind75.problems.p17_kth_largest_element_in_a_stream;

import java.util.PriorityQueue;

public class KthLargestPriorityQueue implements KthLargest {
  private final int k;
  private final PriorityQueue<Integer> nums;

  public KthLargestPriorityQueue(int k, int[] nums) {
    this.k = k;
    this.nums = new PriorityQueue<>(k);
    for(int num : nums) {
      add(num);
    }
  }

  @Override
  public int add(int val) {
    this.nums.offer(val);
    if(this.nums.size() > this.k) {
      this.nums.poll();
    }
    Integer result = this.nums.peek();
    if (result == null) {
      throw new IllegalStateException("Queue unexpectedly empty");
    }
    return result;
  }
}
