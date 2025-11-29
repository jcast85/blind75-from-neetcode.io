package com.blind75.problems.p06_valid_parentheses;

import com.blind75.problems.p05_best_time_to_buy_and_sell_stock.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class ValidParenthesesTest {

  private static final List<ValidParentheses> validParenthesesList = List.of(
    new ValidParenthesesFirstTry());

  private static final List<ValidParenthesesInputAndOutput> validParenthesesInputAndOutputList = List.of(
    ValidParenthesesInputAndOutput.builder()
      .s("[]")
      .expected(true)
      .build(),
    ValidParenthesesInputAndOutput.builder()
      .s("([{}])")
      .expected(true)
      .build(),
    ValidParenthesesInputAndOutput.builder()
      .s("[(])")
      .expected(false)
      .build(),
    ValidParenthesesInputAndOutput.builder()
      .s("[")
      .expected(false)
      .build()
  );

  static Stream<ValidParenthesesTestConfig> testConfigs() {
    Stream.Builder<ValidParenthesesTestConfig> streamBuilder = Stream.builder();
    for (ValidParentheses validParentheses : validParenthesesList) {
      for (ValidParenthesesInputAndOutput validParenthesesInputAndOutput : validParenthesesInputAndOutputList) {
        streamBuilder.add(ValidParenthesesTestConfig.builder()
          .validParentheses(validParentheses)
          .inputAndOutput(validParenthesesInputAndOutput).build());
      }
    }
    return streamBuilder.build();
  }

  @ParameterizedTest
  @MethodSource("testConfigs")
  void testExample(ValidParenthesesTestConfig testConfig) {
    boolean result = testConfig.validParentheses().isValid(testConfig.inputAndOutput().s());
    Assertions.assertEquals(testConfig.inputAndOutput().expected(), result);
  }
}
