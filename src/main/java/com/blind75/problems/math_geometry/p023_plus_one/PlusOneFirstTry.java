package com.blind75.problems.math_geometry.p023_plus_one;

public class PlusOneFirstTry implements PlusOne {
  @Override
  public int[] plusOne(int[] digits) {
    for(int i = digits.length - 1; i >= 0; i--) {
      if(digits[i] < 9) {
        digits[i] = digits[i] + 1;
        return digits;
      } else {
        digits[i] = 0;
      }
    }

    return java.util.stream.IntStream
      .concat(java.util.stream.IntStream.of(1),
        java.util.stream.IntStream.of(digits))
      .toArray();
  }
}
