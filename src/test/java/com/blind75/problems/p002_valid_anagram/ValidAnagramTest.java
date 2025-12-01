package com.blind75.problems.p002_valid_anagram;

import com.blind75.problems.common.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class ValidAnagramTest {

  private static final List<ValidAnagram> validAnagramList = List.of(
      new ValidAnagramFirstTry());

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
          .build());

  static Stream<TestConfig<ValidAnagram>> testConfigs() {
    Stream.Builder<TestConfig<ValidAnagram>> streamBuilder = Stream.builder();
    for (ValidAnagram validAnagram : validAnagramList) {
      for (InputAndOutput validAnagramInputAndOutput : validAnagramInputAndOutputList) {
        streamBuilder.add(new TestConfigBuilder<ValidAnagram>()
          .interfaceToTest(validAnagram)
          .inputAndOutput(validAnagramInputAndOutput)
          .build());
      }
    }
    return streamBuilder.build();
  }

  @ParameterizedTest
  @MethodSource("testConfigs")
  void testExample(TestConfig<ValidAnagram> testConfig) {
    DoubleInputAndOutput<String, String, Boolean> inputAndOutput = (DoubleInputAndOutput) testConfig.inputAndOutput();
    boolean result = testConfig.interfaceToTest().isAnagram(inputAndOutput.input1(), inputAndOutput.input2());
    Assertions.assertEquals(inputAndOutput.output(), result);
  }
}
