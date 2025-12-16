package com.blind75.problems.p024_single_number;

import com.blind75.problems.common.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class SingleNumberTest {

  private static final List<SingleNumber> singleNumberList = List.of(
    new SingleNumberWithList()
  );

  private static final List<InputAndOutput> singleNumberInputAndOutputList = List.of(
    new SingleInputAndOutputBuilder<>()
      .input(new int[] {3,2,3})
      .output(2)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(new int[] {7,6,6,7,8})
      .output(8)
      .build()
  );

  static Stream<SingleMethodTestConfig<SingleNumber>> testConfigs() {
    Stream.Builder<SingleMethodTestConfig<SingleNumber>> streamBuilder = Stream.builder();
    for (SingleNumber singleNumber : singleNumberList) {
      for (InputAndOutput singleNumberInputAndOutput : singleNumberInputAndOutputList) {
        streamBuilder.add(new SingleMethodTestConfigBuilder<SingleNumber>()
          .implementationToTest(singleNumber)
          .inputAndOutput(singleNumberInputAndOutput)
          .build());
      }
    }
    return streamBuilder.build();
  }

  @ParameterizedTest
  @MethodSource("testConfigs")
  void testExample(SingleMethodTestConfig<SingleNumber> singleMethodTestConfig) {
    SingleInputAndOutput<int[], Integer> inputAndOutput = (SingleInputAndOutput) singleMethodTestConfig.inputAndOutput();
    Integer result = singleMethodTestConfig.implementationToTest().singleNumber(inputAndOutput.input());
    org.hamcrest.MatcherAssert.assertThat(result, org.hamcrest.Matchers.equalTo(inputAndOutput.output()));
  }
}
