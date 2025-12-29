package com.blind75.problems.bit_manipulation.counting_bits;

public class CountingBitsDynamicProgramming implements CountingBits {
  @Override
  public int[] countBits(int n) {
    int[] result = new int[n+1];
    int currentExponent = 0;
    int currentPowerByFour = (int) Math.pow(4, currentExponent);
    for(int i = 0; i <= n; i++) {
      if(currentExponent == 0) {
        if(i == 0) {
          result[i] = 0;
        }
        if(i == 1 || i == 2) {
          result[i] = 1;
        }
        if(i == 3) {
          result[i] = 2;
        }
      } else {
        if(i / currentPowerByFour == 1) {
          result[i] = result[i-currentPowerByFour] + 1;
        }
        if(i / currentPowerByFour == 2) {
          result[i] = result[i-currentPowerByFour];
        }
        if(i / currentPowerByFour == 3) {
          result[i] = result[i-currentPowerByFour] + 1;
        }
      }
      if(i == Math.pow(4, currentExponent+1)-1) {
        currentExponent += 1;
        currentPowerByFour = (int) Math.pow(4, currentExponent);
      }
    }
    return result;
  }
}
