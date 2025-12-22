package com.blind75.problems.two_pointers.two_integer_sum_ii;

import com.blind75.problems.common.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class TwoIntegerSumIITest {

  private static final List<TwoIntegerSumII> twoIntegerSumIIList = List.of(
    new TwoIntegerSumIINaive()
  );

  private static final List<InputAndOutput> twoIntegerSumIIInputAndOutputList = List.of(
    new DoubleInputAndOutputBuilder<>()
      .input1(new int[] {1,2,3,4})
      .input2(37)
      .output(new int[] {1,2})
      .build(),
    new DoubleInputAndOutputBuilder<>()
      .input1(new int[] {4, 5, 6})
      .input2(10)
      .output(new int[] {0, 2})
      .build(),
    new DoubleInputAndOutputBuilder<>()
      .input1(new int[] {5, 5})
      .input2(10)
      .output(new int[] {0, 1})
      .build());

  static Stream<SingleMethodTestConfig<TwoIntegerSumII>> testConfigs() {
    Stream.Builder<SingleMethodTestConfig<TwoIntegerSumII>> streamBuilder = Stream.builder();
    for (TwoIntegerSumII twoIntegerSumII : twoIntegerSumIIList) {
      for (InputAndOutput twoIntegerSumIIInputAndOutput : twoIntegerSumIIInputAndOutputList) {
        streamBuilder.add(new SingleMethodTestConfigBuilder<TwoIntegerSumII>()
          .implementationToTest(twoIntegerSumII)
          .inputAndOutput(twoIntegerSumIIInputAndOutput)
          .build());
      }
    }
    return streamBuilder.build();
  }

  @ParameterizedTest
  @MethodSource("testConfigs")
  void testExample(SingleMethodTestConfig<TwoIntegerSumII> singleMethodTestConfig) {
    DoubleInputAndOutput<int[], Integer, int[]> inputAndOutput = (DoubleInputAndOutput) singleMethodTestConfig.inputAndOutput();
    int[] result = singleMethodTestConfig.implementationToTest().twoSum(inputAndOutput.input1(), inputAndOutput.input2());
    Assertions.assertArrayEquals(inputAndOutput.output(), result);
  }
}
