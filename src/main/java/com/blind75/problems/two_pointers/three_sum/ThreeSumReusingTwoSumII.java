package com.blind75.problems.two_pointers.three_sum;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSumReusingTwoSumII implements ThreeSum {
  @Override
  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums); // since the time complexity is O(n^2), sorting is ok because it is O(nlogn)
    Set<String> result = new HashSet<>();
    for(int i=0; i<nums.length; i++) {

      int indexFromBegin = 0;
      int indexFromEnd = nums.length-1;
      while (indexFromBegin<indexFromEnd) {
        if(indexFromBegin == i) {
          indexFromBegin++;
          if(indexFromBegin == nums.length) {
            continue;
          }
        }
        if(indexFromEnd == i) {
          indexFromEnd--;
          if(indexFromEnd == 0) {
            continue;
          }
        }
        if(indexFromBegin == indexFromEnd) {
          break;
        }
        if(nums[indexFromBegin] + nums[indexFromEnd] == -nums[i]) {
          if(nums[i] + nums[indexFromBegin] + nums[indexFromEnd] == 0) {
            result.add(ThreeSumCommonStaticMethods.getDigest(nums, i, indexFromBegin, indexFromEnd));
            indexFromBegin++;
            indexFromEnd = nums.length-1;
          }
        }
        if(nums[indexFromBegin] + nums[indexFromEnd] > -nums[i]) {
          indexFromEnd--;
        }
        if(nums[indexFromBegin] + nums[indexFromEnd] < -nums[i]) {
          indexFromBegin++;
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
