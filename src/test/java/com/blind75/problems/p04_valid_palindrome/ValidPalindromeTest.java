package com.blind75.problems.p04_valid_palindrome;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ValidPalindromeTest {
  @Test
  void testExample() {
    ValidPalindrome validPalindrome = new ValidPalindrome();
    boolean actialOutcome = validPalindrome.isPalindrome("Was it a car or a cat I saw?");
    Assertions.assertTrue(actialOutcome);
  }

  @Test
  void testExample2() {
    ValidPalindrome validPalindrome = new ValidPalindrome();
    boolean actialOutcome = validPalindrome.isPalindrome("tab a cat");
    Assertions.assertFalse(actialOutcome);
  }
}
