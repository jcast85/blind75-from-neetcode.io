package com.blind75.problems.p04_valid_palindrome;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ValidPalindromeTest {
  @Test
  void testExample() {
    ValidPalindrome validPalindrome = new ValidPalindrome();
    boolean actualOutcome = validPalindrome.isPalindrome("Was it a car or a cat I saw?");
    Assertions.assertTrue(actualOutcome);
  }

  @Test
  void testExample2() {
    ValidPalindrome validPalindrome = new ValidPalindrome();
    boolean actualOutcome = validPalindrome.isPalindrome("tab a cat");
    Assertions.assertFalse(actualOutcome);
  }
}
