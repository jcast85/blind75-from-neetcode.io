package com.blind75.problems.p19_climbing_stairs;

import com.blind75.problems.common.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class ClimbingStairsTest {

  private static final List<ClimbingStairs> climbingStairsList = List.of(
    new ClimbingStairsFirstTry()
  );

  private static final List<InputAndOutput> climbingStairsInputAndOutputList = List.of(
    new SingleInputAndOutputBuilder<>()
      .input(0)
      .output(1)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(1)
      .output(1)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(2)
      .output(1+1)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(3)
      .output(1+2)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(4)
      .output(1+3+1)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(5)
      .output(1+4+3)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(6)
      .output(1+5+6+1)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(7)
      .output(1+6+10+4)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(8)
      .output(1+7+15+10+1)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(9)
      .output(1+8+21+20+5)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(10)
      .output(1+9+28+35+15+1)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(30)
      .output(1346269)
      .build()
  );

  static Stream<SingleMethodTestConfig<ClimbingStairs>> testConfigs() {
    Stream.Builder<SingleMethodTestConfig<ClimbingStairs>> streamBuilder = Stream.builder();
    for (ClimbingStairs climbingStairs : climbingStairsList) {
      for (InputAndOutput climbingStairsInputAndOutput : climbingStairsInputAndOutputList) {
        streamBuilder.add(new SingleMethodTestConfigBuilder<ClimbingStairs>()
          .implementationToTest(climbingStairs)
          .inputAndOutput(climbingStairsInputAndOutput)
          .build());
      }
    }
    return streamBuilder.build();
  }

  @ParameterizedTest
  @MethodSource("testConfigs")
  void testExample(SingleMethodTestConfig<ClimbingStairs> singleMethodTestConfig) {
    SingleInputAndOutput<Integer, Integer> inputAndOutput = (SingleInputAndOutput) singleMethodTestConfig.inputAndOutput();
    int result = singleMethodTestConfig.implementationToTest().climbStairs(inputAndOutput.input());
    Assertions.assertEquals(inputAndOutput.output(), result);
  }
}
