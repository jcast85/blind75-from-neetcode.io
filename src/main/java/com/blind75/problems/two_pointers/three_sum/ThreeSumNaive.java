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
            result.add(ThreeSumCommonStaticMethods.getDigest(nums, i, j, k));
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
}
