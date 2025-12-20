package com.blind75.problems.stack.p004_valid_palindrome;

import com.blind75.problems.common.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class ValidPalindromeTest {

  private static final List<ValidPalindrome> validPalindromeList = List.of(
    new ValidPalindromeNaive()
  );

  private static final List<InputAndOutput> validPalindromeInputAndOutputList = List.of(
    new SingleInputAndOutputBuilder<>()
      .input("Was it a car or a cat I saw?")
      .output(true)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input("tab a cat")
      .output(false)
      .build()
  );

  static Stream<SingleMethodTestConfig<ValidPalindrome>> testConfigs() {
    Stream.Builder<SingleMethodTestConfig<ValidPalindrome>> streamBuilder = Stream.builder();
    for (ValidPalindrome validPalindrome : validPalindromeList) {
      for (InputAndOutput validPalindromeInputAndOutput : validPalindromeInputAndOutputList) {
        streamBuilder.add(new SingleMethodTestConfigBuilder<ValidPalindrome>()
          .implementationToTest(validPalindrome)
          .inputAndOutput(validPalindromeInputAndOutput)
          .build());
      }
    }
    return streamBuilder.build();
  }

  @ParameterizedTest
  @MethodSource("testConfigs")
  void testExample(SingleMethodTestConfig<ValidPalindrome> singleMethodTestConfig) {
    SingleInputAndOutput<String, Boolean> inputAndOutput = (SingleInputAndOutput) singleMethodTestConfig.inputAndOutput();
    boolean result = singleMethodTestConfig.implementationToTest().isPalindrome(inputAndOutput.input());
    CommonStaticTestMethods.assertions(result, inputAndOutput.output());
  }
}
