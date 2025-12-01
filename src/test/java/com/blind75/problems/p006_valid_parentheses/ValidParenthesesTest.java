package com.blind75.problems.p006_valid_parentheses;

import com.blind75.problems.common.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class ValidParenthesesTest {

  private static final List<ValidParentheses> validParenthesesList = List.of(
    new ValidParenthesesFirstTry()
  );

  private static final List<InputAndOutput> validParenthesesInputAndOutputList = List.of(
    new SingleInputAndOutputBuilder<>()
      .input("[]")
      .output(true)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input("([{}])")
      .output(true)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input("[(])")
      .output(false)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input("[")
      .output(false)
      .build()
  );

  static Stream<TestConfig<ValidParentheses>> testConfigs() {
    Stream.Builder<TestConfig<ValidParentheses>> streamBuilder = Stream.builder();
    for (ValidParentheses validParentheses : validParenthesesList) {
      for (InputAndOutput validParenthesesInputAndOutput : validParenthesesInputAndOutputList) {
        streamBuilder.add(new TestConfigBuilder<ValidParentheses>()
          .interfaceToTest(validParentheses)
          .inputAndOutput(validParenthesesInputAndOutput)
          .build());
      }
    }
    return streamBuilder.build();
  }

  @ParameterizedTest
  @MethodSource("testConfigs")
  void testExample(TestConfig<ValidParentheses> testConfig) {
    SingleInputAndOutput<String, Boolean> inputAndOutput = (SingleInputAndOutput) testConfig.inputAndOutput();
    boolean result = testConfig.interfaceToTest().isValid(inputAndOutput.input());
    Assertions.assertEquals(inputAndOutput.output(), result);
  }
}
