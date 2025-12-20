package com.blind75.problems.arrays_and_hashing.top_k_frequent_elements;

import com.blind75.problems.common.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class TopKFrequentElementsTest {

  private static final List<TopKFrequentElements> topKFrequentElementsList = List.of(new TopKFrequentElementsNaive());

  private static final List<InputAndOutput> topKFrequentElementsInputAndOutputList = List.of(
    new DoubleInputAndOutputBuilder<>()
        .input1(new int[] {1,2,2,3,3,3})
        .input2(2)
        .output(new int[] {2, 3})
      .build(),
    new DoubleInputAndOutputBuilder<>()
      .input1(new int[] {7,7})
      .input2(1)
      .output(new int[] {7})
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

  static Stream<SingleMethodTestConfig<TopKFrequentElements>> testConfigs() {
    Stream.Builder<SingleMethodTestConfig<TopKFrequentElements>> streamBuilder = Stream.builder();
    for (TopKFrequentElements topKFrequentElements : topKFrequentElementsList) {
      for (InputAndOutput topKFrequentElementsInputAndOutput : topKFrequentElementsInputAndOutputList) {
        streamBuilder.add(new SingleMethodTestConfigBuilder<TopKFrequentElements>()
          .implementationToTest(topKFrequentElements)
          .inputAndOutput(topKFrequentElementsInputAndOutput)
          .build());
      }
    }
    return streamBuilder.build();
  }

  @ParameterizedTest
  @MethodSource("testConfigs")
  void testExample(SingleMethodTestConfig<TopKFrequentElements> singleMethodTestConfig) {
    DoubleInputAndOutput<int[], Integer, int[]> inputAndOutput = (DoubleInputAndOutput) singleMethodTestConfig.inputAndOutput();
    int[] result = singleMethodTestConfig.implementationToTest().topKFrequent(inputAndOutput.input1(), inputAndOutput.input2());
    CommonStaticTestMethods.assertions(result, inputAndOutput.output());
  }
}
