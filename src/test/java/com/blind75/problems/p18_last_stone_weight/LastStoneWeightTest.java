package com.blind75.problems.p18_last_stone_weight;

import com.blind75.problems.common.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class LastStoneWeightTest {

  private static final List<LastStoneWeight> lastStoneWeightList = List.of(
    new LastStoneWeightTreeSet()
  );

  private static final List<InputAndOutput> lastStoneWeightInputAndOutputList = List.of(
    new SingleInputAndOutputBuilder<>()
      .input(new int[] {2,3,6,2,4})
      .output(1)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(new int[] {1,2})
      .output(1)
      .build()
  );

  static Stream<SingleMethodTestConfig<LastStoneWeight>> testConfigs() {
    Stream.Builder<SingleMethodTestConfig<LastStoneWeight>> streamBuilder = Stream.builder();
    for (LastStoneWeight lastStoneWeight : lastStoneWeightList) {
      for (InputAndOutput lastStoneWeightInputAndOutput : lastStoneWeightInputAndOutputList) {
        streamBuilder.add(new SingleMethodTestConfigBuilder<LastStoneWeight>()
          .implementationToTest(lastStoneWeight)
          .inputAndOutput(lastStoneWeightInputAndOutput)
          .build());
      }
    }
    return streamBuilder.build();
  }

  @ParameterizedTest
  @MethodSource("testConfigs")
  void testExample(SingleMethodTestConfig<LastStoneWeight> singleMethodTestConfig) {
    SingleInputAndOutput<int[], Integer> inputAndOutput = (SingleInputAndOutput) singleMethodTestConfig.inputAndOutput();
    int result = singleMethodTestConfig.implementationToTest().lastStoneWeight(inputAndOutput.input());
    Assertions.assertEquals(inputAndOutput.output(), result);
  }
}
