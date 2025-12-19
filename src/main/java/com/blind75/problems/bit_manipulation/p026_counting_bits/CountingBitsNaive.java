package com.blind75.problems.bit_manipulation.p026_counting_bits;

public class CountingBitsNaive implements CountingBits {
  @Override
  public int[] countBits(int n) {
    int[] result = new int[n+1];
    for(int i = 0; i <= n; i++) {
      result[i] = getOnesCount(i);
    }
    return result;
  }

  private int getOnesCount(int n) {
    return Integer.bitCount(n);
  }
}
