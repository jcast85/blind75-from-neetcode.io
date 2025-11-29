package com.blind75.problems.p001_contains_duplicate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class ContainsDuplicateTest {

  private static final List<ContainsDuplicate> containsDuplicateList = List.of(
      new ContainsDuplicateFirstTry());

  private static final List<ContainsDuplicateInputAndOutput> containsDuplicateInputAndOutputList = List.of(
      ContainsDuplicateInputAndOutput.builder()
          .nums(new int[] { 1, 2, 3, 4 })
          .expectedHasDuplicate(false)
          .build(),
      ContainsDuplicateInputAndOutput.builder()
          .nums(new int[] { 1, 2, 3, 3 })
          .expectedHasDuplicate(true)
          .build());

  static Stream<ContainsDuplicateTestConfig> testConfigs() {
    Stream.Builder<ContainsDuplicateTestConfig> streamBuilder = Stream.builder();
    for (ContainsDuplicate containsDuplicate : containsDuplicateList) {
      for (ContainsDuplicateInputAndOutput containsDuplicateInputAndOutput : containsDuplicateInputAndOutputList) {
        streamBuilder.add(ContainsDuplicateTestConfig.builder()
            .containsDuplicate(containsDuplicate)
            .inputAndOutput(containsDuplicateInputAndOutput).build());
      }
    }
    return streamBuilder.build();
  }

  @ParameterizedTest
  @MethodSource("testConfigs")
  void testExample(ContainsDuplicateTestConfig testConfig) {
    boolean result = testConfig.containsDuplicate().hasDuplicate(testConfig.inputAndOutput().nums());
    Assertions.assertEquals(testConfig.inputAndOutput().expectedHasDuplicate(), result);
  }
}