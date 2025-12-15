package com.blind75.problems.p020_min_cost_climbing_stairs;

import com.blind75.problems.common.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class MinCostClimbingStairsTest {

  private static final List<MinCostClimbingStairs> minCostClimbingStairsList = List.of(
    new MinCostClimbingStairsFirstTry(),
    new MinCostClimbingStairsAvoidingUselessSum()
  );

  private static final List<InputAndOutput> minCostClimbingStairsInputAndOutputList = List.of(
    new SingleInputAndOutputBuilder<>()
      .input(new int[] {1,2,3})
      .output(2)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(new int[] {1,2,1,2,1,1,1})
      .output(4)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(new int[] {2,1,2,1,1})
      .output(2)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(new int[] {1,100,1})
      .output(2)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(new int[] {1,1,100,1})
      .output(2)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(new int[] {1,1,1,100,1,1})
      .output(3)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(new int[] {100,1,1,1,100,1,1,100})
      .output(4)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(new int[] {1,100,1,1,1,100,1,1,100,1})
      .output(6)
      .build()
  );

  static Stream<SingleMethodTestConfig<MinCostClimbingStairs>> testConfigs() {
    Stream.Builder<SingleMethodTestConfig<MinCostClimbingStairs>> streamBuilder = Stream.builder();
    for (MinCostClimbingStairs minCostClimbingStairs : minCostClimbingStairsList) {
      for (InputAndOutput minCostClimbingStairsInputAndOutput : minCostClimbingStairsInputAndOutputList) {
        streamBuilder.add(new SingleMethodTestConfigBuilder<MinCostClimbingStairs>()
          .implementationToTest(minCostClimbingStairs)
          .inputAndOutput(minCostClimbingStairsInputAndOutput)
          .build());
      }
    }
    return streamBuilder.build();
  }

  @ParameterizedTest
  @MethodSource("testConfigs")
  void testExample(SingleMethodTestConfig<MinCostClimbingStairs> singleMethodTestConfig) {
    SingleInputAndOutput<int[], Integer> inputAndOutput = (SingleInputAndOutput) singleMethodTestConfig.inputAndOutput();
    int result = singleMethodTestConfig.implementationToTest().minCostClimbingStairs(inputAndOutput.input());
    Assertions.assertEquals(inputAndOutput.output(), result);
  }
}
