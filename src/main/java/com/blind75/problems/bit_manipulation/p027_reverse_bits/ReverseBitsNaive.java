package com.blind75.problems.bit_manipulation.p027_reverse_bits;

public class ReverseBitsNaive implements ReverseBits {
  @Override
  public int reverseBits(int n) {
    boolean isNegative = n < 0;
    int reverseBits = 0;
    for (int i = 0; i < 31; i++) {
      reverseBits = reverseBits + Math.abs(n % 2);
      if(isNegative && Math.abs(n % 2) == 1) {
        n -= 1;
      }
      reverseBits *= 2;
      n /= 2;
    }
    reverseBits = reverseBits + (isNegative ? 1 : 0);
    return reverseBits;
  }
}
