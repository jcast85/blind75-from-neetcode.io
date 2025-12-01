package com.blind75.problems.p008_reversed_linked_list;

import com.blind75.problems.common.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class ReversedLinkedListTest {

  private static final List<ReversedLinkedList> reversedLinkedListList = List.of(
    new ReversedLinkedListFirstTry()
  );

  private static final List<InputAndOutput> reversedLinkedListInputAndOutputList = List.of(
    new SingleInputAndOutputBuilder<>()
      .input(ListNode.of(0, 1, 2, 3))
      .output(ListNode.of(3, 2, 1, 0))
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(ListNode.of())
      .output(ListNode.of())
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(null)
      .output(null)
      .build()
  );

  static Stream<TestConfig<ReversedLinkedList>> testConfigs() {
    Stream.Builder<TestConfig<ReversedLinkedList>> streamBuilder = Stream.builder();
    for (ReversedLinkedList reversedLinkedList : reversedLinkedListList) {
      for (InputAndOutput reversedLinkedListInputAndOutput : reversedLinkedListInputAndOutputList) {
        streamBuilder.add(new TestConfigBuilder<ReversedLinkedList>()
          .interfaceToTest(reversedLinkedList)
          .inputAndOutput(reversedLinkedListInputAndOutput)
          .build());
      }
    }
    return streamBuilder.build();
  }

  @ParameterizedTest
  @MethodSource("testConfigs")
  void testExample(TestConfig<ReversedLinkedList> testConfig) {
    SingleInputAndOutput<ListNode, ListNode> inputAndOutput = (SingleInputAndOutput) testConfig.inputAndOutput();
    ListNode result = testConfig.interfaceToTest().reverseList(inputAndOutput.input());
    Assertions.assertEquals(inputAndOutput.output(), result);
  }
}
