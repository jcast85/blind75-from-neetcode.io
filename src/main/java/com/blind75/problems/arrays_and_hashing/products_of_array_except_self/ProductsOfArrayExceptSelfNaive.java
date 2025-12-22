package com.blind75.problems.arrays_and_hashing.products_of_array_except_self;

public class ProductsOfArrayExceptSelfNaive implements ProductsOfArrayExceptSelf {
  @Override
  public int[] productExceptSelf(int[] nums) {
    int overallProduct = 1;
    boolean isThereAtLeastAZero = false;
    boolean areThereAtLeast2Zero = false;
    boolean isThereAtLeastANotZero = false;
    for (int num : nums) {
      if(num != 0) {
        overallProduct *= num;
        isThereAtLeastANotZero = true;
      } else {
        if(isThereAtLeastAZero) {
          areThereAtLeast2Zero = true;
        }
        isThereAtLeastAZero = true;
      }
    }
    int[] result = new int[nums.length];
    for(int i=0; i<nums.length; i++) {
      if(isThereAtLeastANotZero && !areThereAtLeast2Zero) {
        if(nums[i] == 0) {
          result[i] = overallProduct;
        } else {
          if(isThereAtLeastAZero) {
            result[i] = 0;
          } else {
            result[i] = overallProduct/nums[i];
          }
        }
      } else {
        result[i] = 0;
      }
    }
    return result;
  }
}
