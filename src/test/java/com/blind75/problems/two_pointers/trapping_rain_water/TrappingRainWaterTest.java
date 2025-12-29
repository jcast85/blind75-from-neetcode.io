package com.blind75.problems.two_pointers.trapping_rain_water;

import com.blind75.problems.common.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class TrappingRainWaterTest {

  private static final List<TrappingRainWater> trappingRainWaterList = List.of(
//    new TrappingRainWaterNaive(),
    new TrappingRainWaterIncreasingHeightEachTime(),
    new TrappingRainWaterOptimized()
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
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(new int[] {2,1,0,2})
      .output(3)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(new int[] {4,2,0,3,2,4,3,4})
      .output(10)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(new int[] {5,5,1,7,1,1,5,2,7,6})
      .output(23)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(new int[] {5,5,1,7})
      .output(4)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(new int[] {7,1,1,5,2,7,6})
      .output(19)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(new int[] {6,4,2,0,3,2,0,3,1,4,5,3,2,7})
      .output(43)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(new int[] {7,5,3,0,1,2,1,3,4,6,8,1,3})
      .output(40)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(new int[] {6,4,2,0,3,2,0,3,1,4,5,3,2,7,5,3,0,1,2,1,3,4,6,8,1,3})
      .output(83)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(new int[] {0})
      .output(0)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(new int[] {1000,999,998,997,996,995,994,993,992,991,990,989,988,987,986,985,984,983,982,981,980,979,978,977,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966,966})
      .output(0)
      .build()
  );

  static Stream<SingleMethodTestConfig<TrappingRainWater>> testConfigs() {
    Stream.Builder<SingleMethodTestConfig<TrappingRainWater>> streamBuilder = Stream.builder();
    for (TrappingRainWater trappingRainWater : trappingRainWaterList) {
      for (InputAndOutput inputAndOutput : trappingRainWaterInputAndOutputList
        .subList(0, trappingRainWaterInputAndOutputList.size())
      ) {
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
