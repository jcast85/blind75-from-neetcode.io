package com.blind75.problems.p03_two_sum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TwoSumTest {
  @Test
  void testExample() {
    TwoSum twoSum = new TwoSum();
    int[] actualTwoSum = twoSum.twoSum(new int[] {3, 4, 5, 6}, 7);
    Assertions.assertArrayEquals(new int[] {0, 1}, actualTwoSum);
  }

  @Test
  void testExample2() {
    TwoSum twoSum = new TwoSum();
    int[] actualTwoSum = twoSum.twoSum(new int[] {4, 5, 6}, 10);
    Assertions.assertArrayEquals(new int[] {0, 2}, actualTwoSum);
  }

  @Test
  void testExample3() {
    TwoSum twoSum = new TwoSum();
    int[] actualTwoSum = twoSum.twoSum(new int[] {5,5}, 10);
    Assertions.assertArrayEquals(new int[] {0,1}, actualTwoSum);
  }
}
