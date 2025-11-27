package com.blind75.problems.p02_valid_anagram;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ValidAnagramTest {
  @Test
  void isAnagram() {
    ValidAnagram validAnagram = new ValidAnagram();
    boolean actualOutcome = validAnagram.isAnagram("racecar", "carrace");
    Assertions.assertTrue(actualOutcome);
  }

  @Test
  void isNotAnagram() {
    ValidAnagram validAnagram = new ValidAnagram();
    boolean actualOutcome = validAnagram.isAnagram("jar", "jam");
    Assertions.assertFalse(actualOutcome);
  }
}
