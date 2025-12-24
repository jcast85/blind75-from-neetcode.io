package com.blind75.problems.two_pointers.three_sum;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSumNaive implements ThreeSum {
  @Override
  public List<List<Integer>> threeSum(int[] nums) {
    Set<String> result = new HashSet<>();
    for(int i=0; i<nums.length; i++) {
      for(int j=0; j<nums.length; j++) {
        if(i==j) {
          continue;
        }
        for(int k=0; k<nums.length; k++) {
          if(j == k || i == k) {
            continue;
          }
          if(nums[i] + nums[j] + nums[k] == 0) {
            result.add(getDigest(nums, i, j, k));
          }
        }
      }
    }
    return result.stream()
      .map(s -> List.of(
        Integer.parseInt(s.split("_")[0]),
        Integer.parseInt(s.split("_")[1]),
        Integer.parseInt(s.split("_")[2])
      ))
      .toList();
  }

  private static String getDigest(int[] nums, int i, int j, int k) {
    if(nums[i] >=nums[j] && nums[i] >=nums[k] && nums[j] >=nums[k]) {
      return nums[i] + "_" + nums[j] + "_" + nums[k];
    }
    if(nums[i] >=nums[j] && nums[i] >=nums[k] && nums[k] >=nums[j]) {
      return nums[i] + "_" + nums[k] + "_" + nums[j];
    }
    if(nums[j] >=nums[i] && nums[j] >=nums[k] && nums[i] >=nums[k]) {
      return nums[j] + "_" + nums[i] + "_" + nums[k];
    }
    if(nums[j] >=nums[i] && nums[j] >=nums[k] && nums[k] >=nums[i]) {
      return nums[j] + "_" + nums[k] + "_" + nums[i];
    }
    if(nums[k] >=nums[i] && nums[k] >=nums[j] && nums[i] >=nums[j]) {
      return nums[k] + "_" + nums[i] + "_" + nums[j];
    }
    if(nums[k] >=nums[i] && nums[k] >=nums[j] && nums[j] >=nums[i]) {
      return nums[k] + "_" + nums[j] + "_" + nums[i];
    }
    return null;
  }
}
