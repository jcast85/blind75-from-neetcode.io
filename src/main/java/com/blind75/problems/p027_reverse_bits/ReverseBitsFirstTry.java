package com.blind75.problems.p027_reverse_bits;

public class ReverseBitsFirstTry implements ReverseBits {
  @Override
  public int reverseBits(int n) {
    int reverseBits = 0;
    int sign = (n % 2 == 1) ? -1 : 1;
    n = n >> 1;
    for (int i = 0; i < 31; i++) {
      reverseBits = reverseBits + n % 2;
      if( i < 30) {
        reverseBits = reverseBits << 1;
      }
      n = n >> 1;
    }
    return sign * reverseBits;
  }
}