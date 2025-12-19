package com.blind75.problems.p027_reverse_bits;

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
      .input(21)
      .output(-671088640)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(43261596)
      .output(964176192)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(2147483644)
      .output(1073741822)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(-2147483645) // 10000000000000000000000000000011
      .output(-1073741823) // 11000000000000000000000000000001
      .build()
  );

  static Stream<SingleMethodTestConfig<ReverseBits>> testConfigs() {
    Stream.Builder<SingleMethodTestConfig<ReverseBits>> streamBuilder = Stream.builder();
    for (ReverseBits reverseBits : reverseBitsList) {
      for (InputAndOutput reverseBitsInputAndOutput : reverseBitsInputAndOutputList.subList(3, 4)) {
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
