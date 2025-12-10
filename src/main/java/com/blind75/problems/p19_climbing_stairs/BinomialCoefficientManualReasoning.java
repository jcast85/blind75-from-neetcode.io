package com.blind75.problems.p19_climbing_stairs;

public class BinomialCoefficientManualReasoning implements BinomialCoefficient {
  @Override
  public int binomialCoefficient(int n) {
    int count = 1;
    System.out.print(count);
    for(int k = 0; k < n; k++) {
      int currentValue = 1;
      boolean isValueToAdd = false;
      for(int j = 0; j <= k; j++) {
        if(n-j>0) {
          currentValue *= (n-j);
          isValueToAdd = true;
        }
      }
      if(isValueToAdd) {
        int value = currentValue / getFattoriale(k+1);
        System.out.print(" + " + value);
        count += value;
      }
    }
    System.out.println(" = " + count);
    return count;
  }

  private int getFattoriale(int n) {
    return n == 0 ? 1 : n * getFattoriale(n-1);
  }

}
