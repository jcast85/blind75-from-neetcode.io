package com.blind75.problems.bit_manipulation.p025_number_of_one_bits;

public class NumberOfOneBitsWithMod implements NumberOfOneBits {
  @Override
  public int hammingWeight(int n) {
    int count = 0;
    while (n!=0) {
      count += n % 2;
      n /= 2;
    }
    return count;
  }
}
