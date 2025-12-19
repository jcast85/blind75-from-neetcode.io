package com.blind75.problems.arrays_and_hashing.valid_anagram.valid_anagram;

import com.blind75.problems.common.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class ValidAnagramTest {

  private static final List<ValidAnagram> validAnagramList = List.of(
    new ValidAnagramFirstTry()
  );

  private static final List<InputAndOutput> validAnagramInputAndOutputList = List.of(
    new DoubleInputAndOutputBuilder<>()
      .input1("racecar")
      .input2("carrace")
      .output(true)
      .build(),
    new DoubleInputAndOutputBuilder<>()
      .input1("jar")
      .input2("jam")
      .output(false)
      .build()
  );

  static Stream<SingleMethodTestConfig<ValidAnagram>> testConfigs() {
    Stream.Builder<SingleMethodTestConfig<ValidAnagram>> streamBuilder = Stream.builder();
    for (ValidAnagram validAnagram : validAnagramList) {
      for (InputAndOutput validAnagramInputAndOutput : validAnagramInputAndOutputList) {
        streamBuilder.add(new SingleMethodTestConfigBuilder<ValidAnagram>()
          .implementationToTest(validAnagram)
          .inputAndOutput(validAnagramInputAndOutput)
          .build());
      }
    }
    return streamBuilder.build();
  }

  @ParameterizedTest
  @MethodSource("testConfigs")
  void testExample(SingleMethodTestConfig<ValidAnagram> singleMethodTestConfig) {
    DoubleInputAndOutput<String, String, Boolean> inputAndOutput = (DoubleInputAndOutput) singleMethodTestConfig.inputAndOutput();
    boolean result = singleMethodTestConfig.implementationToTest().isAnagram(inputAndOutput.input1(), inputAndOutput.input2());
    org.hamcrest.MatcherAssert.assertThat(result, org.hamcrest.Matchers.equalTo(inputAndOutput.output()));
  }
}
