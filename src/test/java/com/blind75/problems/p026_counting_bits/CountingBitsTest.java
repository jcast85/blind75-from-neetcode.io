package com.blind75.problems.p026_counting_bits;

import com.blind75.problems.common.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class CountingBitsTest {

  private static final List<CountingBits> countingBitsList = List.of(
    new CountingBitsNaive()
  );

  private static final List<InputAndOutput> countingBitsInputAndOutputList = List.of(
    new SingleInputAndOutputBuilder<>()
      .input(4)
      .output(new int[] {0,1,1,2,1})
      .build()
  );

  static Stream<SingleMethodTestConfig<CountingBits>> testConfigs() {
    Stream.Builder<SingleMethodTestConfig<CountingBits>> streamBuilder = Stream.builder();
    for (CountingBits countingBits : countingBitsList) {
      for (InputAndOutput countingBitsInputAndOutput : countingBitsInputAndOutputList) {
        streamBuilder.add(new SingleMethodTestConfigBuilder<CountingBits>()
          .implementationToTest(countingBits)
          .inputAndOutput(countingBitsInputAndOutput)
          .build());
      }
    }
    return streamBuilder.build();
  }

  @ParameterizedTest
  @MethodSource("testConfigs")
  void testExample(SingleMethodTestConfig<CountingBits> singleMethodTestConfig) {
    SingleInputAndOutput<Integer, int[]> inputAndOutput = (SingleInputAndOutput) singleMethodTestConfig.inputAndOutput();
    int[] result = singleMethodTestConfig.implementationToTest().countBits(inputAndOutput.input());
    org.hamcrest.MatcherAssert.assertThat(result, org.hamcrest.Matchers.equalTo(inputAndOutput.output()));
  }
}
