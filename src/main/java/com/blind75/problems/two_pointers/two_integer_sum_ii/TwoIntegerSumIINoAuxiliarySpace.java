package com.blind75.problems.two_pointers.two_integer_sum_ii;

public class TwoIntegerSumIINoAuxiliarySpace implements TwoIntegerSumII {
  @Override
  public int[] twoSum(int[] numbers, int target) {
    int indexFromBegin = 0;
    int indexFromEnd = numbers.length-1;
    while (indexFromBegin<indexFromEnd) {
      if(numbers[indexFromBegin] + numbers[indexFromEnd] == target) {
        return TwoIntegerSumIICommonStaticMethods.returnIndex(indexFromBegin, indexFromEnd);
      }
      if(numbers[indexFromBegin] + numbers[indexFromEnd] > target) {
        indexFromEnd--;
      }
      if(numbers[indexFromBegin] + numbers[indexFromEnd] < target) {
        indexFromBegin++;
      }
    }
    return new int[0];
  }
}
