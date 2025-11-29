package com.blind75.problems.p003_two_sum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class TwoSumTest {

  private static final List<TwoSum> twoSumList = List.of(
      new TwoSumFirstTry());

  private static final List<TwoSumInputAndOutput> twoSumInputAndOutputList = List.of(
      TwoSumInputAndOutput.builder()
          .nums(new int[] { 3, 4, 5, 6 })
          .target(7)
          .expectedResult(new int[] { 0, 1 })
          .build(),
      TwoSumInputAndOutput.builder()
          .nums(new int[] { 4, 5, 6 })
          .target(10)
          .expectedResult(new int[] { 0, 2 })
          .build(),
      TwoSumInputAndOutput.builder()
          .nums(new int[] { 5, 5 })
          .target(10)
          .expectedResult(new int[] { 0, 1 })
          .build());

  static Stream<TwoSumTestConfig> testConfigs() {
    Stream.Builder<TwoSumTestConfig> streamBuilder = Stream.builder();
    for (TwoSum twoSum : twoSumList) {
      for (TwoSumInputAndOutput twoSumInputAndOutput : twoSumInputAndOutputList) {
        streamBuilder.add(TwoSumTestConfig.builder()
            .twoSum(twoSum)
            .inputAndOutput(twoSumInputAndOutput).build());
      }
    }
    return streamBuilder.build();
  }

  @ParameterizedTest
  @MethodSource("testConfigs")
  void testExample(TwoSumTestConfig testConfig) {
    int[] result = testConfig.twoSum().twoSum(testConfig.inputAndOutput().nums(), testConfig.inputAndOutput().target());
    Assertions.assertArrayEquals(testConfig.inputAndOutput().expectedResult(), result);
  }
}
