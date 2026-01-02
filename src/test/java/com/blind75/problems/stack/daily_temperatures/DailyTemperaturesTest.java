package com.blind75.problems.stack.daily_temperatures;

import com.blind75.problems.common.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class DailyTemperaturesTest {

  private static final List<DailyTemperatures> dailyTemperaturesList = List.of(
    new DailyTemperaturesNaive(),
    new DailyTemperaturesStack()
  );

  private static final List<InputAndOutput> dailyTemperaturesInputAndOutputList = List.of(
    new SingleInputAndOutputBuilder<>()
      .input(new int[] {30,38,30,36,35,40,28})
      .output(new int[] {1,4,1,2,1,0,0})
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(new int[] {22,21,20})
      .output(new int[] {0,0,0})
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(new int[] {73,74,75,71,69,72,76,73})
      .output(new int[] {1,1,4,2,1,1,0,0})
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(new int[] {55,38,53,81,61,93,97,32,43,78})
      .output(new int[] {3,1,1,2,1,1,0,1,1,0})
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(new int[] {89,62,70,58,47,47,46,76,100,70})
      .output(new int[] {8,1,5,4,3,2,1,1,0,0})
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(new int[] {34,80,80,34,34,80,80,80,80,34})
      .output(new int[] {1,0,0,2,1,0,0,0,0,0})
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(new int[] {64,40,49,73,72,35,68,83,35,73,84,88,96,43,74,63,41,95,48,46,89,72,34,85,72,59,87,49,30,32,47,34,74,58,31,75,73,88,64,92,83,64,100,99,81,41,48,83,96,92,82,32,35,68,68,92,73,92,52,33,44,38,47,88,71,50,57,95,33,65,94,44,47,79,41,74,50,67,97,31,68,50,37,70,77,55,48,30,77,100,31,100,69,60,47,95,68,47,33,64})
      .output(new int[] {3,1,1,4,3,1,1,3,1,1,1,1,30,1,3,2,1,25,2,1,19,2,1,3,2,1,11,5,1,1,2,1,3,2,1,2,1,2,1,3,2,1,0,46,3,1,1,1,30,18,5,1,1,2,1,12,1,10,5,1,2,1,1,4,3,1,1,11,1,1,8,1,1,5,1,3,1,1,11,1,3,2,1,1,5,3,2,1,1,0,1,0,3,2,1,0,0,2,1,0})
      .build());

  static Stream<SingleMethodTestConfig<DailyTemperatures>> testConfigs() {
    Stream.Builder<SingleMethodTestConfig<DailyTemperatures>> streamBuilder = Stream.builder();
    for (DailyTemperatures dailyTemperatures : dailyTemperaturesList) {
      for (InputAndOutput dailyTemperaturesInputAndOutput : dailyTemperaturesInputAndOutputList
   //     .subList(4, 5)
      ) {
        streamBuilder.add(new SingleMethodTestConfigBuilder<DailyTemperatures>()
          .implementationToTest(dailyTemperatures)
          .inputAndOutput(dailyTemperaturesInputAndOutput)
          .build());
      }
    }
    return streamBuilder.build();
  }

  @ParameterizedTest
  @MethodSource("testConfigs")
  void testExample(SingleMethodTestConfig<DailyTemperatures> singleMethodTestConfig) {
    SingleInputAndOutput<int[], int[]> inputAndOutput = (SingleInputAndOutput) singleMethodTestConfig.inputAndOutput();
    int[] result = singleMethodTestConfig.implementationToTest().dailyTemperatures(inputAndOutput.input());
    Assertions.assertArrayEquals(inputAndOutput.output(), result);
  }
}
