package com.blind75.problems.bit_manipulation.p027_reverse_bits;

import com.blind75.problems.common.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class ReverseBitsTest {

  private static final List<ReverseBits> reverseBitsList = List.of(
    new ReverseBitsFirstTry(),
    new ReverseBitsWithShift()
  );

  private static final List<InputAndOutput> reverseBitsInputAndOutputList = List.of(
    new SingleInputAndOutputBuilder<>()
      .input(21)            // 00000000000000000000000000010101
      .output(-1476395008)  // 10101000000000000000000000000000
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(43261596)      // 00000010100101000001111010011100
      .output(964176192)    // 00111001011110000010100101000000
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(2147483644)    // 01111111111111111111111111111100
      .output(1073741822)   // 00111111111111111111111111111110
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(-2147483645)   // 10000000000000000000000000000011
      .output(-1073741823)  // 11000000000000000000000000000001
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
