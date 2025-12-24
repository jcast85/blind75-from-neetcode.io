package com.blind75.problems.two_pointers.three_sum;

import java.util.*;

public class ThreeSumOptimized implements ThreeSum {
  @Override
  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums); // since the time complexity is O(n^2), sorting is ok because it is O(nlogn)
    List<List<Integer>> result = new ArrayList<>();
    for(int i=0; i<nums.length-2; i++) {
      int j=i+1;
      int k=nums.length-1;
      while(j<k) {
        int sum = nums[i] + nums[j] + nums[k];
        if(sum == 0) {
          result.add(List.of(nums[i],nums[j],nums[k]));
          while(j<nums.length-1 && nums[j] == nums[j+1]) {
            j++;
          }
          j++;
          while(k<nums.length-1 && nums[k] == nums[k-1]) {
            k--;
          }
          k--;
          while(i<nums.length-1 && nums[i] == nums[i+1]) {
            i++;
          }
        } else {
          if(sum > 0) {
            k--;
          }
          if(sum < 0) {
            j++;
          }
        }
      }
    }
    return result;
  }
}
