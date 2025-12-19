package com.blind75.problems.bit_manipulation.p025_number_of_one_bits;

import com.blind75.problems.common.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class NumberOfOneBitsTest {

  private static final List<NumberOfOneBits> numberOfOneBitsList = List.of(
    new NumberOfOneBitsWithMod()
  );

  private static final List<InputAndOutput> numberOfOneBitsInputAndOutputList = List.of(
    new SingleInputAndOutputBuilder<>()
      .input(23)
      .output(4)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(2147483645)
      .output(30)
      .build()
  );

  static Stream<SingleMethodTestConfig<NumberOfOneBits>> testConfigs() {
    Stream.Builder<SingleMethodTestConfig<NumberOfOneBits>> streamBuilder = Stream.builder();
    for (NumberOfOneBits numberOfOneBits : numberOfOneBitsList) {
      for (InputAndOutput numberOfOneBitsInputAndOutput : numberOfOneBitsInputAndOutputList) {
        streamBuilder.add(new SingleMethodTestConfigBuilder<NumberOfOneBits>()
          .implementationToTest(numberOfOneBits)
          .inputAndOutput(numberOfOneBitsInputAndOutput)
          .build());
      }
    }
    return streamBuilder.build();
  }

  @ParameterizedTest
  @MethodSource("testConfigs")
  void testExample(SingleMethodTestConfig<NumberOfOneBits> singleMethodTestConfig) {
    SingleInputAndOutput<Integer, Integer> inputAndOutput = (SingleInputAndOutput) singleMethodTestConfig.inputAndOutput();
    Integer result = singleMethodTestConfig.implementationToTest().hammingWeight(inputAndOutput.input());
    org.hamcrest.MatcherAssert.assertThat(result, org.hamcrest.Matchers.equalTo(inputAndOutput.output()));
  }
}
