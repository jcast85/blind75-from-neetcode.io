package com.blind75.problems.arrays_and_hashing.valid_anagram.valid_anagram;

import com.blind75.problems.arrays_and_hashing.common.CommonStaticMethods;

public class ValidAnagramFirstTry implements ValidAnagram {
  @Override
  public boolean isAnagram(String s, String t) {
    return CommonStaticMethods.isAnagram(s, t);
  }

}
