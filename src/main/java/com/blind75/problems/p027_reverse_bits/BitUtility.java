package com.blind75.problems.p027_reverse_bits;

public class BitUtility {
  private BitUtility() {}

  public static String getBitRepresentation(int n, int maxBitNumber) {
    if(n>=0) {
      return padLeftZeros(Integer.toBinaryString(n), maxBitNumber);
    } else {
      return padLeftZeros("1" + Integer.toBinaryString(-1*n), maxBitNumber);
    }
  }

  private static String padLeftZeros(String inputString, int length) {
    if (inputString.length() >= length) {
      return inputString;
    }
    StringBuilder sb = new StringBuilder();
    while (sb.length() < length - inputString.length()) {
      sb.append('0');
    }
    sb.append(inputString);

    return sb.toString();
  }

  public static int fromBitRepresentation(String bitRepresentation) {
    int result = 0;
    for(int i = 1; i < bitRepresentation.length(); i++) {
      result = (result << 1) | (bitRepresentation.charAt(i) - '0');
    }
    return (bitRepresentation.charAt(0) == '1' ? -1 : 1) *result;
  }
}
