package com.blind75.problems.two_pointers.trapping_rain_water;

import com.blind75.problems.common.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class TrappingRainWaterTest {

  private static final List<TrappingRainWater> trappingRainWaterList = List.of(
    new TrappingRainWaterNaive()
  );

  private static final List<InputAndOutput> trappingRainWaterInputAndOutputList = List.of(
    new SingleInputAndOutputBuilder<>()
      .input(new int[] {0,1,0,1,0,0,0,1,0,1})
      .output(5)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(new int[] {0,2,0,3,1,2,1,1,0,1})
      .output(4)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(new int[] {0,2,0,3,1,0,1,3,2,1})
      .output(9)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(new int[] {4,2,0,3,2,5})
      .output(9)
      .build()
  );

  static Stream<SingleMethodTestConfig<TrappingRainWater>> testConfigs() {
    Stream.Builder<SingleMethodTestConfig<TrappingRainWater>> streamBuilder = Stream.builder();
    for (TrappingRainWater trappingRainWater : trappingRainWaterList) {
      for (InputAndOutput inputAndOutput : trappingRainWaterInputAndOutputList.subList(0,4)) {
        streamBuilder.add(new SingleMethodTestConfigBuilder<TrappingRainWater>()
          .implementationToTest(trappingRainWater)
          .inputAndOutput(inputAndOutput)
          .build());
      }
    }
    return streamBuilder.build();
  }

  @ParameterizedTest
  @MethodSource("testConfigs")
  void testExample(SingleMethodTestConfig<TrappingRainWater> singleMethodTestConfig) {
    SingleInputAndOutput<int[], Integer> inputAndOutput = (SingleInputAndOutput) singleMethodTestConfig.inputAndOutput();
    Integer result = singleMethodTestConfig.implementationToTest().trap(inputAndOutput.input());
    CommonStaticTestMethods.assertions(result, inputAndOutput.output());
  }
}
