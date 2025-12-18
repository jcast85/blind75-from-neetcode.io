package com.blind75.problems.p027_reverse_bits;

public class BitUtility {
  private BitUtility() {}

  public static String getBitRepresentation(int n, int maxBitNumber) {
    StringBuilder bitRepresentation = new StringBuilder();
    boolean isNegative = n < 0;
    int actualBitNumber = maxBitNumber - (isNegative ? 1 : 0);
    for(int i = 0; i < actualBitNumber; i++) {
      bitRepresentation.insert(0, Math.abs(n % 2));
      if(isNegative && Math.abs(n % 2) == 1) {
        n += 1;
      }
      n = n >> 1;
    }
    if(isNegative) {
      bitRepresentation.insert(0, 1);
    }
    return bitRepresentation.toString();
  }

  public static int fromBitRepresentation(String bitRepresentation) {
    int result = 0;
    for(int i = 1; i < bitRepresentation.length(); i++) {
      result = (result << 1) | (bitRepresentation.charAt(i) - '0');
    }
    return -1*(bitRepresentation.charAt(0) == '1' ? 1 : 0) *result;
  }
}
