package com.blind75.problems.two_pointers.container_with_most_water;

import com.blind75.problems.common.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class ContainerWithMostWaterTest {

  private static final List<ContainerWithMostWater> containerWithMostWaterList = List.of(
    new ContainerWithMostWaterNaive()
  );

  private static final List<InputAndOutput> containerWithMostWaterInputAndOutputList = List.of(
    new SingleInputAndOutputBuilder<>()
      .input(new int[] {1,7,2,5,4,7,3,6})
      .output(36)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(new int[] {2,2,2})
      .output(4)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(new int[] {1,7,2,5,12,3,500,500,7,8,4,7,3,6})
      .output(500)
      .build()
  );

  static Stream<SingleMethodTestConfig<ContainerWithMostWater>> testConfigs() {
    Stream.Builder<SingleMethodTestConfig<ContainerWithMostWater>> streamBuilder = Stream.builder();
    for (ContainerWithMostWater containerWithMostWater : containerWithMostWaterList) {
      for (InputAndOutput inputAndOutput : containerWithMostWaterInputAndOutputList) {
        streamBuilder.add(new SingleMethodTestConfigBuilder<ContainerWithMostWater>()
          .implementationToTest(containerWithMostWater)
          .inputAndOutput(inputAndOutput)
          .build());
      }
    }
    return streamBuilder.build();
  }

  @ParameterizedTest
  @MethodSource("testConfigs")
  void testExample(SingleMethodTestConfig<ContainerWithMostWater> singleMethodTestConfig) {
    SingleInputAndOutput<int[], Integer> inputAndOutput = (SingleInputAndOutput) singleMethodTestConfig.inputAndOutput();
    Integer result = singleMethodTestConfig.implementationToTest().maxArea(inputAndOutput.input());
    CommonStaticTestMethods.assertions(result, inputAndOutput.output());
  }
}
