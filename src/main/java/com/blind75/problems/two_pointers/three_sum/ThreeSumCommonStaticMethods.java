package com.blind75.problems.two_pointers.three_sum;

public class ThreeSumCommonStaticMethods {
  private ThreeSumCommonStaticMethods() {}


  static String getDigest(int[] nums, int i, int j, int k) {
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
