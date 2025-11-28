package com.blind75.problems.p02_valid_anagram;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class ValidAnagramTest {

  private static final List<ValidAnagram> validAnagramList = List.of(
      new ValidAnagramFirstTry());

  private static final List<ValidAnagramInputAndOutput> validAnagramInputAndOutputList = List.of(
      ValidAnagramInputAndOutput.builder()
          .s("racecar")
          .t("carrace")
          .expectedIsAnagram(true)
          .build(),
      ValidAnagramInputAndOutput.builder()
          .s("jar")
          .t("jam")
          .expectedIsAnagram(false)
          .build());

  static Stream<ValidAnagramTestConfig> testConfigs() {
    Stream.Builder<ValidAnagramTestConfig> streamBuilder = Stream.builder();
    for (ValidAnagram validAnagram : validAnagramList) {
      for (ValidAnagramInputAndOutput validAnagramInputAndOutput : validAnagramInputAndOutputList) {
        streamBuilder.add(ValidAnagramTestConfig.builder()
            .validAnagram(validAnagram)
            .inputAndOutput(validAnagramInputAndOutput).build());
      }
    }
    return streamBuilder.build();
  }

  @ParameterizedTest
  @MethodSource("testConfigs")
  void testExample(ValidAnagramTestConfig testConfig) {
    boolean result = testConfig.validAnagram().isAnagram(testConfig.inputAndOutput().s(),
        testConfig.inputAndOutput().t());
    Assertions.assertEquals(testConfig.inputAndOutput().expectedIsAnagram(), result);
  }
}
