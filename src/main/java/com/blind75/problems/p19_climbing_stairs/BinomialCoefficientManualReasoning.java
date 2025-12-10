package com.blind75.problems.p19_climbing_stairs;

import java.math.BigInteger;

public class BinomialCoefficientManualReasoning implements BinomialCoefficient {
  @Override
  public int binomialCoefficient(int n) {
    int count = 1;
    System.out.print(count);
    for(int k = 0; k < n; k++) {
      BigInteger currentValue = BigInteger.ONE;
      boolean isValueToAdd = false;
      for(int j = 0; j <= k; j++) {
        if(n-j>0) {
          currentValue = currentValue.multiply(BigInteger.valueOf(n-j));
          isValueToAdd = true;
        }
      }
      if(isValueToAdd) {
        BigInteger value = currentValue.divide(ClimbingStairsCommonStaticMethods.getFattoriale(k+1));
        System.out.print(" + " + value);
        count += value.intValue();
      }
    }
    System.out.println(" = " + count);
    return count;
  }
}
