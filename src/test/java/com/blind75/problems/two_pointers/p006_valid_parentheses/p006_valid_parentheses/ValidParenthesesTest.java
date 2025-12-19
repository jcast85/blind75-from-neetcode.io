package com.blind75.problems.two_pointers.p006_valid_parentheses.p006_valid_parentheses;

import com.blind75.problems.common.*;
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

  static Stream<SingleMethodTestConfig<ValidParentheses>> testConfigs() {
    Stream.Builder<SingleMethodTestConfig<ValidParentheses>> streamBuilder = Stream.builder();
    for (ValidParentheses validParentheses : validParenthesesList) {
      for (InputAndOutput validParenthesesInputAndOutput : validParenthesesInputAndOutputList) {
        streamBuilder.add(new SingleMethodTestConfigBuilder<ValidParentheses>()
          .implementationToTest(validParentheses)
          .inputAndOutput(validParenthesesInputAndOutput)
          .build());
      }
    }
    return streamBuilder.build();
  }

  @ParameterizedTest
  @MethodSource("testConfigs")
  void testExample(SingleMethodTestConfig<ValidParentheses> singleMethodTestConfig) {
    SingleInputAndOutput<String, Boolean> inputAndOutput = (SingleInputAndOutput) singleMethodTestConfig.inputAndOutput();
    boolean result = singleMethodTestConfig.implementationToTest().isValid(inputAndOutput.input());
    org.hamcrest.MatcherAssert.assertThat(result, org.hamcrest.Matchers.equalTo(inputAndOutput.output()));
  }
}
