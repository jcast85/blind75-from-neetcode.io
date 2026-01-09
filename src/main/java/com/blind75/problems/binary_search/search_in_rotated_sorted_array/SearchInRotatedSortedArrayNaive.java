package com.blind75.problems.binary_search.search_in_rotated_sorted_array;

public class SearchInRotatedSortedArrayNaive implements SearchInRotatedSortedArray {
  @Override
  public int search(int[] nums, int target) {
    if(nums.length == 1) {
      if(nums[0] == target) {
        return 0;
      } else {
        return -1;
      }
    }
    int i = 0;
    int step = nums.length;
    while(step > 0) {
      if(nums[i] == target) {
        return i;
      }
      int iBefore = (i + nums.length - 1) % nums.length;
      if(nums[iBefore] == target) {
        return iBefore;
      }
      int iAfter = (i + 1) % nums.length;
      if(nums[iAfter] == target) {
        return iAfter;
      }

      step /= 2;
      if(nums[i] > target) {
        if(nums[iBefore] < target) {
          return -1;
        }
        i = (i +nums.length - step) % nums.length;
      }
      if(nums[i] < target) {
        if(nums[iAfter] > target) {
          return -1;
        }
        i = (i + step) % nums.length;
      }
    }
    return -1;
  }
}
