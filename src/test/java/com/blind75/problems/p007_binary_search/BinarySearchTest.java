package com.blind75.problems.p007_binary_search;

import com.blind75.problems.common.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class BinarySearchTest {

  private static final List<BinarySearch> binarySearchList = List.of(new BinarySearchFirstTry());

  private static final List<InputAndOutput> binarySearchInputAndOutputList = List.of(
    new DoubleInputAndOutputBuilder<>()
      .input1(new int[] {-1, 0, 2, 4, 6, 8})
      .input2(4)
      .output(3)
      .build(),
    new DoubleInputAndOutputBuilder<>()
      .input1(new int[] {-1, 0, 2, 4, 6, 8})
      .input2(7)
      .output(-1)
      .build(),
    new DoubleInputAndOutputBuilder<>()
      .input1(new int[] {-1, 0, 3, 5, 9, 12})
      .input2(13)
      .output(-1)
      .build(),
    new DoubleInputAndOutputBuilder<>()
      .input1(new int[] {-1, 0, 3, 5, 9, 12})
      .input2(9)
      .output(4)
      .build()
  );

  static Stream<TestConfig<BinarySearch>> testConfigs() {
    Stream.Builder<TestConfig<BinarySearch>> streamBuilder = Stream.builder();
    for (BinarySearch binarySearch : binarySearchList) {
      for (InputAndOutput binarySearchInputAndOutput : binarySearchInputAndOutputList) {
        streamBuilder.add(new TestConfigBuilder<BinarySearch>()
          .interfaceToTest(binarySearch)
          .inputAndOutput(binarySearchInputAndOutput)
          .build());
      }
    }
    return streamBuilder.build();
  }

  @ParameterizedTest
  @MethodSource("testConfigs")
  void testExample(TestConfig<BinarySearch> testConfig) {
    DoubleInputAndOutput<int[], Integer, Integer> inputAndOutput = (DoubleInputAndOutput) testConfig.inputAndOutput();
    int result = testConfig.interfaceToTest().search(inputAndOutput.input1(), inputAndOutput.input2());
    Assertions.assertEquals(inputAndOutput.output(), result);
  }
}
