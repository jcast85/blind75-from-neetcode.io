package com.blind75.problems.p19_climbing_stairs;

import java.math.BigInteger;

public class ClimbingStairsCommonStaticMethods {
  static BigInteger getFattoriale(int n) {
    return n == 0 ? BigInteger.ONE : BigInteger.valueOf(n).multiply(getFattoriale(n-1));
  }
}
