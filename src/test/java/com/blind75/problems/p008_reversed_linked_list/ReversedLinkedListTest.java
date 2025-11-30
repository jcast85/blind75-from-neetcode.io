package com.blind75.problems.p008_reversed_linked_list;

import com.blind75.problems.common.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class ReversedLinkedListTest {

  private static final List<ReversedLinkedList> reversedLinkedListList = List.of(
    new ReversedLinkedListFirstTry());

  private static final List<ReversedLinkedListInputAndOutput> reversedLinkedListInputAndOutputList = List.of(
    ReversedLinkedListInputAndOutput.builder()
      .head(ListNode.of(0,1,2,3))
      .expected(ListNode.of(3,2,1,0))
      .build(),
    ReversedLinkedListInputAndOutput.builder()
      .head(ListNode.of())
      .expected(ListNode.of())
      .build(),
    ReversedLinkedListInputAndOutput.builder()
      .head(null)
      .expected(null)
      .build()
  );

  static Stream<ReversedLinkedListTestConfig> testConfigs() {
    Stream.Builder<ReversedLinkedListTestConfig> streamBuilder = Stream.builder();
    for (ReversedLinkedList reversedLinkedList : reversedLinkedListList) {
      for (ReversedLinkedListInputAndOutput reversedLinkedListInputAndOutput : reversedLinkedListInputAndOutputList) {
        streamBuilder.add(ReversedLinkedListTestConfig.builder()
          .reversedLinkedList(reversedLinkedList)
          .inputAndOutput(reversedLinkedListInputAndOutput).build());
      }
    }
    return streamBuilder.build();
  }

  @ParameterizedTest
  @MethodSource("testConfigs")
  void testExample(ReversedLinkedListTestConfig testConfig) {
    ListNode result = testConfig.reversedLinkedList().reverseList(testConfig.inputAndOutput().head());
    Assertions.assertEquals(testConfig.inputAndOutput().expected(), result);
  }
}
