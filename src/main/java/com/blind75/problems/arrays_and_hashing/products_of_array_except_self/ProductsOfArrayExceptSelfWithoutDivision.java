package com.blind75.problems.arrays_and_hashing.products_of_array_except_self;

public class ProductsOfArrayExceptSelfWithoutDivision implements ProductsOfArrayExceptSelf {
  @Override
  public int[] productExceptSelf(int[] nums) {
    int[] prodFromBegin = new int[nums.length];
    int[] prodFromEnd = new int[nums.length];
    int[] result = new int[nums.length];

    prodFromBegin[0] = nums[0];
    prodFromEnd[nums.length - 1] = nums[nums.length - 1];

    for (int i = 1; i < nums.length - 1; i++) {
      prodFromBegin[i] = nums[i] * prodFromBegin[i - 1];
      prodFromEnd[nums.length - 1 - i] = nums[nums.length - 1 - i] * prodFromEnd[nums.length - i];
    }

    result[0] = prodFromEnd[1];
    result[nums.length - 1] = prodFromBegin[nums.length - 2];

    for (int i = 1; i < nums.length - 1; i++) {
      result[i] = prodFromBegin[i - 1] * prodFromEnd[i + 1];
    }

    return result;
  }
}
