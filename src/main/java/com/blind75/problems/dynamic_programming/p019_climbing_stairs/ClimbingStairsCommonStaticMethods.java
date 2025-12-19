package com.blind75.problems.dynamic_programming.p019_climbing_stairs;

import java.math.BigInteger;

public class ClimbingStairsCommonStaticMethods {
  static BigInteger getFattoriale(int n) {
    return n == 0 ? BigInteger.ONE : BigInteger.valueOf(n).multiply(getFattoriale(n-1));
  }
}
