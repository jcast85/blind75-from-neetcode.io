package com.blind75.problems.binary_search.p007_binary_search;

public class BinarySearchFirstTry implements BinarySearch {
  @Override
  public int search(int[] nums, int target) {
    return search(nums, target, 0, nums.length - 1);
  }

  public int search(int[] nums, int target, int left, int right) {
    if (left > right) {
      return -1;
    }
    int centralNodeIndex = left + (right - left + 1) / 2;
    if (nums[centralNodeIndex] == target) {
      return centralNodeIndex;
    }
    if (left == right) {
      return -1;
    }
    if (nums[centralNodeIndex] > target) {
      return search(nums, target, left, centralNodeIndex -1);
    } else {
      return search(nums, target, centralNodeIndex +1, right);
    }
  }
}
