package com.blind75.problems.arrays_and_hashing.contains_duplicate;

import com.blind75.problems.common.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class ContainsDuplicateTest {

  private static final List<ContainsDuplicate> containsDuplicateList = List.of(
    new ContainsDuplicateNaive()
  );

  private static final List<InputAndOutput> containsDuplicateInputAndOutputList = List.of(
    new SingleInputAndOutputBuilder<>()
      .input(new int[] {1, 2, 3, 4})
      .output(false)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(new int[] {1, 2, 3, 3})
      .output(true)
      .build()
  );

  static Stream<SingleMethodTestConfig<ContainsDuplicate>> testConfigs() {
    Stream.Builder<SingleMethodTestConfig<ContainsDuplicate>> streamBuilder = Stream.builder();
    for (ContainsDuplicate containsDuplicate : containsDuplicateList) {
      for (InputAndOutput inputAndOutput : containsDuplicateInputAndOutputList) {
        streamBuilder.add(new SingleMethodTestConfigBuilder<ContainsDuplicate>()
          .implementationToTest(containsDuplicate)
          .inputAndOutput(inputAndOutput)
          .build());
      }
    }
    return streamBuilder.build();
  }

  @ParameterizedTest
  @MethodSource("testConfigs")
  void testExample(SingleMethodTestConfig<ContainsDuplicate> singleMethodTestConfig) {
    SingleInputAndOutput<int[], Boolean> inputAndOutput = (SingleInputAndOutput) singleMethodTestConfig.inputAndOutput();
    boolean result = singleMethodTestConfig.implementationToTest().hasDuplicate(inputAndOutput.input());
    CommonStaticTestMethods.assertions(result, inputAndOutput.output());
  }
}
