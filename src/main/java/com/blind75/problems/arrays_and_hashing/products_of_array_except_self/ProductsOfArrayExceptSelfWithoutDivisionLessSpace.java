package com.blind75.problems.arrays_and_hashing.products_of_array_except_self;

public class ProductsOfArrayExceptSelfWithoutDivisionLessSpace implements ProductsOfArrayExceptSelf {
  @Override
  public int[] productExceptSelf(int[] nums) {
    int[] result = new int[nums.length];

    result[0] = 1;
    for (int i = 1; i < nums.length; i++) {
      result[i] = nums[i-1] * result[i - 1];
    }

    int suffixProd = 1;
    for (int i = nums.length - 1; i>=0; i--) {
      result[i] = result[i] * suffixProd;
      suffixProd = suffixProd * nums[i];
    }

    return result;
  }
}
