package com.blind75.problems.arrays_and_hashing.encode_and_decode_strings;

import java.util.List;

public class EncodeStringsNaive implements EncodeStrings {
  @Override
  public String encode(List<String> strs) {
    if(strs.isEmpty()) {
      return "";
    }
    StringBuilder sb = new StringBuilder();
    for (String str : strs) {
      sb.append(str.length()).append("[").append(str).append("]");
    }
    return sb.toString();
  }
}
