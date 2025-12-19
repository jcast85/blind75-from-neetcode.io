package com.blind75.problems.math_geometry.p023_plus_one;

import com.blind75.problems.common.*;
import com.blind75.problems.math_geometry.p023_plus_one.PlusOne;
import com.blind75.problems.math_geometry.p023_plus_one.PlusOneFirstTry;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class PlusOneTest {

  private static final List<PlusOne> plusOneList = List.of(
    new PlusOneFirstTry()
  );

  private static final List<InputAndOutput> plusOneInputAndOutputList = List.of(
    new SingleInputAndOutputBuilder<>()
      .input(new int[] {1, 2, 3, 4})
      .output(new int[] {1,2,3,5})
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(new int[] {9,9,9})
      .output(new int[] {1,0,0,0})
      .build()
  );

  static Stream<SingleMethodTestConfig<PlusOne>> testConfigs() {
    Stream.Builder<SingleMethodTestConfig<PlusOne>> streamBuilder = Stream.builder();
    for (PlusOne plusOne : plusOneList) {
      for (InputAndOutput plusOneInputAndOutput : plusOneInputAndOutputList) {
        streamBuilder.add(new SingleMethodTestConfigBuilder<PlusOne>()
          .implementationToTest(plusOne)
          .inputAndOutput(plusOneInputAndOutput)
          .build());
      }
    }
    return streamBuilder.build();
  }

  @ParameterizedTest
  @MethodSource("testConfigs")
  void testExample(SingleMethodTestConfig<PlusOne> singleMethodTestConfig) {
    SingleInputAndOutput<int[], int[]> inputAndOutput = (SingleInputAndOutput) singleMethodTestConfig.inputAndOutput();
    int[] result = singleMethodTestConfig.implementationToTest().plusOne(inputAndOutput.input());
    org.hamcrest.MatcherAssert.assertThat(result, org.hamcrest.Matchers.equalTo(inputAndOutput.output()));
  }
}
