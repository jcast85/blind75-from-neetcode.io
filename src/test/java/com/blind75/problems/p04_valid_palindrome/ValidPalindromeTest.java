package com.blind75.problems.p04_valid_palindrome;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class ValidPalindromeTest {

  private static final List<ValidPalindrome> validPalindromeList = List.of(
      new ValidPalindromeFirstTry());

  private static final List<ValidPalindromeInputAndOutput> validPalindromeInputAndOutputList = List.of(
      ValidPalindromeInputAndOutput.builder()
          .s("Was it a car or a cat I saw?")
          .expectedIsPalindrome(true)
          .build(),
      ValidPalindromeInputAndOutput.builder()
          .s("tab a cat")
          .expectedIsPalindrome(false)
          .build());

  static Stream<ValidPalindromeTestConfig> testConfigs() {
    Stream.Builder<ValidPalindromeTestConfig> streamBuilder = Stream.builder();
    for (ValidPalindrome validPalindrome : validPalindromeList) {
      for (ValidPalindromeInputAndOutput validPalindromeInputAndOutput : validPalindromeInputAndOutputList) {
        streamBuilder.add(ValidPalindromeTestConfig.builder()
            .validPalindrome(validPalindrome)
            .inputAndOutput(validPalindromeInputAndOutput).build());
      }
    }
    return streamBuilder.build();
  }

  @ParameterizedTest
  @MethodSource("testConfigs")
  void testExample(ValidPalindromeTestConfig testConfig) {
    boolean result = testConfig.validPalindrome().isPalindrome(testConfig.inputAndOutput().s());
    Assertions.assertEquals(testConfig.inputAndOutput().expectedIsPalindrome(), result);
  }
}
