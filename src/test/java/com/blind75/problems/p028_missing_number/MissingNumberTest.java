package com.blind75.problems.p028_missing_number;

import com.blind75.problems.common.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class MissingNumberTest {

  private static final List<MissingNumber> missingNumberList = List.of(
    new MissingNumberFirstTry()
  );

  private static final List<InputAndOutput> missingNumberInputAndOutputList = List.of(
    new SingleInputAndOutputBuilder<>()
      .input(new int[] {1,2,3})
      .output(0)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(new int[] {0,2})
      .output(1)
      .build()
  );

  static Stream<SingleMethodTestConfig<MissingNumber>> testConfigs() {
    Stream.Builder<SingleMethodTestConfig<MissingNumber>> streamBuilder = Stream.builder();
    for (MissingNumber missingNumber : missingNumberList) {
      for (InputAndOutput missingNumberInputAndOutput : missingNumberInputAndOutputList) {
        streamBuilder.add(new SingleMethodTestConfigBuilder<MissingNumber>()
          .implementationToTest(missingNumber)
          .inputAndOutput(missingNumberInputAndOutput)
          .build());
      }
    }
    return streamBuilder.build();
  }

  @ParameterizedTest
  @MethodSource("testConfigs")
  void testExample(SingleMethodTestConfig<MissingNumber> singleMethodTestConfig) {
    SingleInputAndOutput<int[], Integer> inputAndOutput = (SingleInputAndOutput) singleMethodTestConfig.inputAndOutput();
    Integer result = singleMethodTestConfig.implementationToTest().missingNumber(inputAndOutput.input());
    org.hamcrest.MatcherAssert.assertThat(result, org.hamcrest.Matchers.equalTo(inputAndOutput.output()));
  }
}
