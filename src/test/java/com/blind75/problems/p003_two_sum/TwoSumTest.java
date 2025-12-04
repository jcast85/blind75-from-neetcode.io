package com.blind75.problems.p003_two_sum;

import com.blind75.problems.common.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class TwoSumTest {

  private static final List<TwoSum> twoSumList = List.of(
    new TwoSumFirstTry()
  );

  private static final List<InputAndOutput> twoSumInputAndOutputList = List.of(
    new DoubleInputAndOutputBuilder<>()
      .input1(new int[] {3, 4, 5, 6})
      .input2(7)
      .output(new int[] {0, 1})
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

  static Stream<SingleMethodTestConfig<TwoSum>> testConfigs() {
    Stream.Builder<SingleMethodTestConfig<TwoSum>> streamBuilder = Stream.builder();
    for (TwoSum twoSum : twoSumList) {
      for (InputAndOutput twoSumInputAndOutput : twoSumInputAndOutputList) {
        streamBuilder.add(new SingleMethodTestConfigBuilder<TwoSum>()
          .implementationToTest(twoSum)
          .inputAndOutput(twoSumInputAndOutput)
          .build());
      }
    }
    return streamBuilder.build();
  }

  @ParameterizedTest
  @MethodSource("testConfigs")
  void testExample(SingleMethodTestConfig<TwoSum> singleMethodTestConfig) {
    DoubleInputAndOutput<int[], Integer, int[]> inputAndOutput = (DoubleInputAndOutput) singleMethodTestConfig.inputAndOutput();
    int[] result = singleMethodTestConfig.implementationToTest().twoSum(inputAndOutput.input1(), inputAndOutput.input2());
    Assertions.assertArrayEquals(inputAndOutput.output(), result);
  }
}
