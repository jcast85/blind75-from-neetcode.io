package com.blind75.problems.two_pointers.three_sum;

import com.blind75.problems.common.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class ThreeSumTest {

  private static final List<ThreeSum> threeSumList = List.of(
    new ThreeSumNaive()
  );

  private static final List<InputAndOutput> threeSumInputAndOutputList = List.of(
    new SingleInputAndOutputBuilder<>()
      .input(new int[] {-1,0,1,2,-1,-4})
      .output(List.of(List.of(-1,-1,2),List.of(-1,0,1)))
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(new int[] {0,1,1})
      .output(List.of())
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(new int[] {0,0,0})
      .output(List.of(0,0,0))
      .build()
  );

  static Stream<SingleMethodTestConfig<ThreeSum>> testConfigs() {
    Stream.Builder<SingleMethodTestConfig<ThreeSum>> streamBuilder = Stream.builder();
    for (ThreeSum threeSum : threeSumList) {
      for (InputAndOutput threeSumInputAndOutput : threeSumInputAndOutputList) {
        streamBuilder.add(new SingleMethodTestConfigBuilder<ThreeSum>()
          .implementationToTest(threeSum)
          .inputAndOutput(threeSumInputAndOutput)
          .build());
      }
    }
    return streamBuilder.build();
  }

  @ParameterizedTest
  @MethodSource("testConfigs")
  void testExample(SingleMethodTestConfig<ThreeSum> singleMethodTestConfig) {
    SingleInputAndOutput<int[], List<List<Integer>>> inputAndOutput = (SingleInputAndOutput) singleMethodTestConfig.inputAndOutput();
    List<List<Integer>> result = singleMethodTestConfig.implementationToTest().threeSum(inputAndOutput.input());
    CommonStaticTestMethods.assertions(result, inputAndOutput.output());
  }
}
