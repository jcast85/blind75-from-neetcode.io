package com.blind75.problems.stack.daily_temperatures;

import com.blind75.problems.common.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class DailyTemperaturesTest {

  private static final List<DailyTemperatures> dailyTemperaturesList = List.of(
    new DailyTemperaturesNaive()
  );

  private static final List<InputAndOutput> dailyTemperaturesInputAndOutputList = List.of(
    new SingleInputAndOutputBuilder<>()
      .input(new int[] {30,38,30,36,35,40,28})
      .output(new int[] {1,4,1,2,1,0,0})
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(new int[] {22,21,20})
      .output(new int[] {0,0,0})
      .build());

  static Stream<SingleMethodTestConfig<DailyTemperatures>> testConfigs() {
    Stream.Builder<SingleMethodTestConfig<DailyTemperatures>> streamBuilder = Stream.builder();
    for (DailyTemperatures dailyTemperatures : dailyTemperaturesList) {
      for (InputAndOutput dailyTemperaturesInputAndOutput : dailyTemperaturesInputAndOutputList) {
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
