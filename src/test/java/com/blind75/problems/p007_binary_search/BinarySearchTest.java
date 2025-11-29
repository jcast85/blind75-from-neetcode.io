package com.blind75.problems.p007_binary_search;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class BinarySearchTest {

  private static final List<BinarySearch> binarySearchList = List.of(
    new BinarySearchFirstTry());

  private static final List<BinarySearchInputAndOutput> binarySearchInputAndOutputList = List.of(
    BinarySearchInputAndOutput.builder()
      .nums(new int[]{-1,0,2,4,6,8})
      .target(4)
      .expected(3)
      .build(),
    BinarySearchInputAndOutput.builder()
      .nums(new int[]{-1,0,2,4,6,8})
      .target(7)
      .expected(-1)
      .build(),
    BinarySearchInputAndOutput.builder()
      .nums(new int[]{-1,0,3,5,9,12})
      .target(13)
      .expected(-1)
      .build(),
    BinarySearchInputAndOutput.builder()
      .nums(new int[]{-1,0,3,5,9,12})
      .target(9)
      .expected(4)
      .build()
  );

  static Stream<BinarySearchTestConfig> testConfigs() {
    Stream.Builder<BinarySearchTestConfig> streamBuilder = Stream.builder();
    for (BinarySearch binarySearch : binarySearchList) {
      for (BinarySearchInputAndOutput binarySearchInputAndOutput : binarySearchInputAndOutputList) {
        streamBuilder.add(BinarySearchTestConfig.builder()
          .binarySearch(binarySearch)
          .inputAndOutput(binarySearchInputAndOutput).build());
      }
    }
    return streamBuilder.build();
  }

  @ParameterizedTest
  @MethodSource("testConfigs")
  void testExample(BinarySearchTestConfig testConfig) {
    int result = testConfig.binarySearch().search(testConfig.inputAndOutput().nums(), testConfig.inputAndOutput().target());
    Assertions.assertEquals(testConfig.inputAndOutput().expected(), result);
  }
}
