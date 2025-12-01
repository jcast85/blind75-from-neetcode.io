package com.blind75.problems.p009_merge_two_sorted_linked_lists;

import com.blind75.problems.common.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class MergeTwoSortedLinkedListsTest {

  private static final List<MergeTwoSortedLinkedLists> mergeTwoSortedLinkedListsList = List.of(
    new MergeTwoSortedLinkedListsFirstTry()
  );

  private static final List<InputAndOutput> mergeTwoSortedLinkedListsInputAndOutputList = List.of(
    new DoubleInputAndOutputBuilder<>()
      .input1(ListNode.of(1, 2, 4))
      .input2(ListNode.of(1, 3, 5))
      .output(ListNode.of(1, 1, 2, 3, 4, 5))
      .build(),
    new DoubleInputAndOutputBuilder<>()
      .input1(ListNode.of())
      .input2(ListNode.of(1, 2))
      .output(ListNode.of(1, 2))
      .build(),
    new DoubleInputAndOutputBuilder<>()
      .input1(ListNode.of())
      .input2(ListNode.of())
      .output(ListNode.of())
      .build()
  );

  static Stream<TestConfig<MergeTwoSortedLinkedLists>> testConfigs() {
    Stream.Builder<TestConfig<MergeTwoSortedLinkedLists>> streamBuilder = Stream.builder();
    for (MergeTwoSortedLinkedLists mergeTwoSortedLinkedLists : mergeTwoSortedLinkedListsList) {
      for (InputAndOutput mergeTwoSortedLinkedListsInputAndOutput : mergeTwoSortedLinkedListsInputAndOutputList) {
        streamBuilder.add(new TestConfigBuilder<MergeTwoSortedLinkedLists>()
          .interfaceToTest(mergeTwoSortedLinkedLists)
          .inputAndOutput(mergeTwoSortedLinkedListsInputAndOutput)
          .build());
      }
    }
    return streamBuilder.build();
  }

  @ParameterizedTest
  @MethodSource("testConfigs")
  void testExample(TestConfig<MergeTwoSortedLinkedLists> testConfig) {
    DoubleInputAndOutput<ListNode, ListNode, ListNode> inputAndOutput = (DoubleInputAndOutput) testConfig.inputAndOutput();
    ListNode result = testConfig.interfaceToTest().mergeTwoLists(inputAndOutput.input1(), inputAndOutput.input2());
    Assertions.assertEquals(inputAndOutput.output(), result);
  }
}
