package com.blind75.problems.arrays_and_hashing.group_anagrams;

import com.blind75.problems.common.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class GroupAnagramsTest {

  private static final List<GroupAnagrams> groupAnagramsList = List.of(
    new GroupAnagramsNaive()
  );

  private static final List<InputAndOutput> groupAnagramsInputAndOutputList = List.of(
    new SingleInputAndOutputBuilder<>()
      .input(new String[] {"act","pots","tops","cat","stop","hat"})
      .output(List.of(
        List.of("hat"),
        List.of("act","cat"),
        List.of("pots","tops","stop")
      ))
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(new String[] {"x"})
      .output(List.of(List.of("x")))
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(new String[] {""})
      .output(List.of(List.of("")))
      .build()
  );

  static Stream<SingleMethodTestConfig<GroupAnagrams>> testConfigs() {
    Stream.Builder<SingleMethodTestConfig<GroupAnagrams>> streamBuilder = Stream.builder();
    for (GroupAnagrams groupAnagrams : groupAnagramsList) {
      for (InputAndOutput inputAndOutput : groupAnagramsInputAndOutputList) {
        streamBuilder.add(new SingleMethodTestConfigBuilder<GroupAnagrams>()
          .implementationToTest(groupAnagrams)
          .inputAndOutput(inputAndOutput)
          .build());
      }
    }
    return streamBuilder.build();
  }

  @ParameterizedTest
  @MethodSource("testConfigs")
  void testExample(SingleMethodTestConfig<GroupAnagrams> singleMethodTestConfig) {
    SingleInputAndOutput<String[], List<List<String>>> inputAndOutput = (SingleInputAndOutput) singleMethodTestConfig.inputAndOutput();
    List<List<String>> result = singleMethodTestConfig.implementationToTest().groupAnagrams(inputAndOutput.input());
    org.hamcrest.MatcherAssert.assertThat(result, org.hamcrest.Matchers.equalTo(inputAndOutput.output()));
  }
}
