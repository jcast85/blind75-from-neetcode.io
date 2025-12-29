package com.blind75.problems.bit_manipulation.reverse_bits;

public class ReverseBitsWithShift implements ReverseBits {
  @Override
  public int reverseBits(int n) {
    int result = 0;

    for (int i = 0; i < 32; ++i) {
      result <<= 1;
      result |= (n & 1);
      n >>= 1;
    }

    return result;
  }
}
