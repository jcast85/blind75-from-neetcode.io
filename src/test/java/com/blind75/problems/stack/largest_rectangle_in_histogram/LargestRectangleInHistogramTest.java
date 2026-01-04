package com.blind75.problems.stack.largest_rectangle_in_histogram;

import com.blind75.problems.common.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class LargestRectangleInHistogramTest {

  private static final List<LargestRectangleInHistogram> largestRectangleInHistogramList = List.of(
    new LargestRectangleInHistogramNaive()
  );

  private static final List<InputAndOutput> largestRectangleInHistogramInputAndOutputList = List.of(
    new SingleInputAndOutputBuilder<>()
      .input(new int[] {7,1,7,2,2,4})
      .output(8)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(new int[] {1,3,7})
      .output(7)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(new int[] {2,1,5,6,2,3})
      .output(10)
      .build()
  );

  static Stream<SingleMethodTestConfig<LargestRectangleInHistogram>> testConfigs() {
    Stream.Builder<SingleMethodTestConfig<LargestRectangleInHistogram>> streamBuilder = Stream.builder();
    for (LargestRectangleInHistogram largestRectangleInHistogram : largestRectangleInHistogramList) {
      for (InputAndOutput inputAndOutput : largestRectangleInHistogramInputAndOutputList
//        .subList(2, 3)
      ) {
        streamBuilder.add(new SingleMethodTestConfigBuilder<LargestRectangleInHistogram>()
          .implementationToTest(largestRectangleInHistogram)
          .inputAndOutput(inputAndOutput)
          .build());
      }
    }
    return streamBuilder.build();
  }

  @ParameterizedTest
  @MethodSource("testConfigs")
  void testExample(SingleMethodTestConfig<LargestRectangleInHistogram> singleMethodTestConfig) {
    SingleInputAndOutput<int[], Integer> inputAndOutput = (SingleInputAndOutput) singleMethodTestConfig.inputAndOutput();
    Integer result = singleMethodTestConfig.implementationToTest().largestRectangleArea(inputAndOutput.input());
    CommonStaticTestMethods.assertions(result, inputAndOutput.output());
  }
}
