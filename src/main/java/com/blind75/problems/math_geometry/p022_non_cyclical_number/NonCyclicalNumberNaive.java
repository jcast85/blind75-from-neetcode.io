package com.blind75.problems.math_geometry.p022_non_cyclical_number;

import java.util.ArrayList;
import java.util.List;

public class NonCyclicalNumberNaive implements NonCyclicalNumber {
  @Override
  public boolean isHappy(int n) {
    java.util.Set<Integer> seen = new java.util.HashSet<>();
    while(seen.add(n)) {
      n = getDigits(n).stream()
        .mapToInt(i -> i * i)
        .sum();
      if(n==1) {
        return true;
      }
    }
    return false;
  }

  private List<Integer> getDigits(int n) {
    List<Integer> digits = new ArrayList<>();
    while(n > 0) {
      digits.add(n % 10);
      n /= 10;
    }
    return digits;
  }
}
