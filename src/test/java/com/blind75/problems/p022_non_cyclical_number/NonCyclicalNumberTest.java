package com.blind75.problems.p022_non_cyclical_number;

import com.blind75.problems.common.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class NonCyclicalNumberTest {

  private static final List<NonCyclicalNumber> nonCyclicalNumberList = List.of(
    new NonCyclicalNumberFirstTry()
  );

  private static final List<InputAndOutput> nonCyclicalNumberInputAndOutputList = List.of(
    new SingleInputAndOutputBuilder<>()
      .input(100)
      .output(true)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(101)
      .output(false)
      .build()
  );

  static Stream<SingleMethodTestConfig<NonCyclicalNumber>> testConfigs() {
    Stream.Builder<SingleMethodTestConfig<NonCyclicalNumber>> streamBuilder = Stream.builder();
    for (NonCyclicalNumber nonCyclicalNumber : nonCyclicalNumberList) {
      for (InputAndOutput nonCyclicalNumberInputAndOutput : nonCyclicalNumberInputAndOutputList) {
        streamBuilder.add(new SingleMethodTestConfigBuilder<NonCyclicalNumber>()
          .implementationToTest(nonCyclicalNumber)
          .inputAndOutput(nonCyclicalNumberInputAndOutput)
          .build());
      }
    }
    return streamBuilder.build();
  }

  @ParameterizedTest
  @MethodSource("testConfigs")
  void testExample(SingleMethodTestConfig<NonCyclicalNumber> singleMethodTestConfig) {
    SingleInputAndOutput<Integer, Boolean> inputAndOutput = (SingleInputAndOutput) singleMethodTestConfig.inputAndOutput();
    boolean result = singleMethodTestConfig.implementationToTest().isHappy(inputAndOutput.input());
    org.hamcrest.MatcherAssert.assertThat(result, org.hamcrest.Matchers.equalTo(inputAndOutput.output()));
  }
}
