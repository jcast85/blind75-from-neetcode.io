package com.blind75.problems.arrays_and_hashing.longest_consecutive_sequence;

import com.blind75.problems.common.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class LongestConsecutiveSequenceTest {

  private static final List<LongestConsecutiveSequence> longestConsecutiveSequenceList = List.of(
    new LongestConsecutiveSequenceNaive()
  );

  private static final List<InputAndOutput> longestConsecutiveSequenceInputAndOutputList = List.of(
    new SingleInputAndOutputBuilder<>()
      .input(new int[] {8,3,5,4,0,1})
      .output(3)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(new int[] {2,20,4,10,3,4,5})
      .output(4)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(new int[] {0,3,2,5,4,6,1,1})
      .output(7)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(new int[] {1,0,-1})
      .output(3)
      .build()
  );

  static Stream<SingleMethodTestConfig<LongestConsecutiveSequence>> testConfigs() {
    Stream.Builder<SingleMethodTestConfig<LongestConsecutiveSequence>> streamBuilder = Stream.builder();
    for (LongestConsecutiveSequence longestConsecutiveSequence : longestConsecutiveSequenceList) {
      for (InputAndOutput inputAndOutput : longestConsecutiveSequenceInputAndOutputList) {
        streamBuilder.add(new SingleMethodTestConfigBuilder<LongestConsecutiveSequence>()
          .implementationToTest(longestConsecutiveSequence)
          .inputAndOutput(inputAndOutput)
          .build());
      }
    }
    return streamBuilder.build();
  }

  @ParameterizedTest
  @MethodSource("testConfigs")
  void testExample(SingleMethodTestConfig<LongestConsecutiveSequence> singleMethodTestConfig) {
    SingleInputAndOutput<int[], Integer> inputAndOutput = (SingleInputAndOutput) singleMethodTestConfig.inputAndOutput();
    Integer result = singleMethodTestConfig.implementationToTest().longestConsecutive(inputAndOutput.input());
    CommonStaticTestMethods.assertions(result, inputAndOutput.output());
  }
}
