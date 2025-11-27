package com.blind75.problems.p02_valid_anagram;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ValidAnagramTest {
  @Test
  void isAnagram() {
    ValidAnagram validAnagram = new ValidAnagram();
    boolean actialOutcome = validAnagram.isAnagram("racecar", "carrace");
    Assertions.assertTrue(actialOutcome);
  }

  @Test
  void isNotAnagram() {
    ValidAnagram validAnagram = new ValidAnagram();
    boolean actialOutcome = validAnagram.isAnagram("jar", "jam");
    Assertions.assertFalse(actialOutcome);
  }
}
