package com.blind75.problems.p027_reverse_bits;

import com.blind75.problems.common.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class ReverseBitsTest {

  private static final List<ReverseBits> reverseBitsList = List.of(
    new ReverseBitsFirstTry()
  );

  private static final List<InputAndOutput> reverseBitsInputAndOutputList = List.of(
    new SingleInputAndOutputBuilder<>()
      .input(21)
      .output(-1* (int) (2818572288L - Integer.MIN_VALUE))
      .build()
  );

  static Stream<SingleMethodTestConfig<ReverseBits>> testConfigs() {
    Stream.Builder<SingleMethodTestConfig<ReverseBits>> streamBuilder = Stream.builder();
    for (ReverseBits reverseBits : reverseBitsList) {
      for (InputAndOutput reverseBitsInputAndOutput : reverseBitsInputAndOutputList) {
        streamBuilder.add(new SingleMethodTestConfigBuilder<ReverseBits>()
          .implementationToTest(reverseBits)
          .inputAndOutput(reverseBitsInputAndOutput)
          .build());
      }
    }
    return streamBuilder.build();
  }

  @ParameterizedTest
  @MethodSource("testConfigs")
  void testExample(SingleMethodTestConfig<ReverseBits> singleMethodTestConfig) {
    SingleInputAndOutput<Integer, Integer> inputAndOutput = (SingleInputAndOutput) singleMethodTestConfig.inputAndOutput();
    Integer result = singleMethodTestConfig.implementationToTest().reverseBits(inputAndOutput.input());
    org.hamcrest.MatcherAssert.assertThat(result, org.hamcrest.Matchers.equalTo(inputAndOutput.output()));
  }
}
