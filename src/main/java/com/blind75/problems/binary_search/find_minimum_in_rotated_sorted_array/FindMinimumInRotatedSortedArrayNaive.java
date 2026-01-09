package com.blind75.problems.binary_search.find_minimum_in_rotated_sorted_array;

public class FindMinimumInRotatedSortedArrayNaive implements FindMinimumInRotatedSortedArray {
  @Override
  public int findMin(int[] nums) {
    if(nums.length == 1) {
      return nums[0];
    }
    int i = 0;
    int step = nums.length;
    int prevNum = 0;
    while(true) {
      int iAfter = (i + 1) % nums.length;
      int iBefore = (i + nums.length - 1) % nums.length;
      if(nums[i] < nums[iBefore]) {
        return nums[i];
      }
      if(nums[i] > nums[iAfter]) {
        return nums[iAfter];
      }


      step = (step + 1) / 2;
      if(prevNum > 0 && nums[i] > prevNum) {
        prevNum = nums[i];
        i = (i + step) % nums.length;
      } else {
        prevNum = nums[i];
        i = (i +nums.length - step) % nums.length;
      }
    }
  }
}
