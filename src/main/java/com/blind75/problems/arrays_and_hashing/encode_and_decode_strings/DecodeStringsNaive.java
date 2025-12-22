package com.blind75.problems.arrays_and_hashing.encode_and_decode_strings;

import java.util.ArrayList;
import java.util.List;

public class DecodeStringsNaive implements DecodeStrings {
  @Override
  public List<String> decode(String str) {
    if(str.isEmpty()) {
      return List.of();
    }
    List<String> result = new ArrayList<>();
    int currentLengthIndex;
    int currentIndex;
    currentLengthIndex = 0;
    while(currentLengthIndex < str.length()) {
      int openingBracketIndex = str.indexOf("[", currentLengthIndex);
      currentIndex = Integer.parseInt(str.substring(currentLengthIndex, openingBracketIndex));
      result.add(str.substring(openingBracketIndex + 1, openingBracketIndex + 1 + currentIndex));
      currentLengthIndex = openingBracketIndex + currentIndex + 2;
    }
    return result;
  }
}
