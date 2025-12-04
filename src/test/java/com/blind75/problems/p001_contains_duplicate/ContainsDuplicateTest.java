package com.blind75.problems.p001_contains_duplicate;

import com.blind75.problems.common.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class ContainsDuplicateTest {

  private static final List<ContainsDuplicate> containsDuplicateList = List.of(
    new ContainsDuplicateFirstTry()
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

  static Stream<TestConfig<ContainsDuplicate>> testConfigs() {
    Stream.Builder<TestConfig<ContainsDuplicate>> streamBuilder = Stream.builder();
    for (ContainsDuplicate containsDuplicate : containsDuplicateList) {
      for (InputAndOutput inputAndOutput : containsDuplicateInputAndOutputList) {
        streamBuilder.add(new TestConfigBuilder<ContainsDuplicate>()
          .interfaceToTest(containsDuplicate)
          .inputAndOutput(inputAndOutput)
          .build());
      }
    }
    return streamBuilder.build();
  }

  @ParameterizedTest
  @MethodSource("testConfigs")
  void testExample(TestConfig<ContainsDuplicate> testConfig) {
    SingleInputAndOutput<int[], Boolean> inputAndOutput = (SingleInputAndOutput) testConfig.inputAndOutput();
    boolean result = testConfig.implementationToTest().hasDuplicate(inputAndOutput.input());
    Assertions.assertEquals(inputAndOutput.output(), result);
  }
}
