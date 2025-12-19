package com.blind75.problems.p027_reverse_bits;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BitUtilityTest {
  @Test
  void getBitRepresentation1Test2() {
    int n = 10;
    int maxBitNumber = 5;
    String expected = "01010";
    String actual = BitUtility.getBitRepresentation(n, maxBitNumber);
    Assertions.assertEquals(expected, actual);

    int reversedActual = BitUtility.fromBitRepresentation(expected);
    Assertions.assertEquals(n, reversedActual);
  }

  @Test
  void getBitRepresentation1Test() {
    int n = 10;
    int maxBitNumber = 5;
    String expected = "01010";
    String actual = BitUtility.getBitRepresentation(n, maxBitNumber);
    Assertions.assertEquals(expected, actual);

    int reversedActual = BitUtility.fromBitRepresentation(expected);
    Assertions.assertEquals(n, reversedActual);
  }

  @Test
  void negativeValue_getBitRepresentation1Test() {
    int n = -10;
    int maxBitNumber = 5;
    String expected = "11010";
    String actual = BitUtility.getBitRepresentation(n, maxBitNumber);
    Assertions.assertEquals(expected, actual);

    int reversedActual = BitUtility.fromBitRepresentation(expected);
    Assertions.assertEquals(n, reversedActual);
  }
}
