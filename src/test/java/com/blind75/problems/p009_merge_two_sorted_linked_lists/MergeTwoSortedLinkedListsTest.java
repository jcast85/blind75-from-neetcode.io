package com.blind75.problems.p009_merge_two_sorted_linked_lists;

import com.blind75.problems.common.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class MergeTwoSortedLinkedListsTest {

  private static final List<MergeTwoSortedLinkedLists> mergeTwoSortedLinkedListsList = List.of(
    new MergeTwoSortedLinkedListsFirstTry());

  private static final List<MergeTwoSortedLinkedListsInputAndOutput> mergeTwoSortedLinkedListsInputAndOutputList = List.of(
    MergeTwoSortedLinkedListsInputAndOutput.builder()
      .list1(ListNode.of(1,2,4))
      .list2(ListNode.of(1,3,5))
      .expected(ListNode.of(1,1,2,3,4,5))
      .build(),
    MergeTwoSortedLinkedListsInputAndOutput.builder()
      .list1(ListNode.of())
      .list2(ListNode.of(1,2))
      .expected(ListNode.of(1,2))
      .build(),
    MergeTwoSortedLinkedListsInputAndOutput.builder()
      .list1(ListNode.of())
      .list2(ListNode.of())
      .expected(ListNode.of())
      .build()
  );

  static Stream<MergeTwoSortedLinkedListsTestConfig> testConfigs() {
    Stream.Builder<MergeTwoSortedLinkedListsTestConfig> streamBuilder = Stream.builder();
    for (MergeTwoSortedLinkedLists mergeTwoSortedLinkedLists : mergeTwoSortedLinkedListsList) {
      for (MergeTwoSortedLinkedListsInputAndOutput mergeTwoSortedLinkedListsInputAndOutput : mergeTwoSortedLinkedListsInputAndOutputList) {
        streamBuilder.add(MergeTwoSortedLinkedListsTestConfig.builder()
          .mergeTwoSortedLinkedLists(mergeTwoSortedLinkedLists)
          .inputAndOutput(mergeTwoSortedLinkedListsInputAndOutput).build());
      }
    }
    return streamBuilder.build();
  }

  @ParameterizedTest
  @MethodSource("testConfigs")
  void testExample(MergeTwoSortedLinkedListsTestConfig testConfig) {
    ListNode result = testConfig.mergeTwoSortedLinkedLists().mergeTwoLists(testConfig.inputAndOutput().list1(), testConfig.inputAndOutput().list2());
    Assertions.assertEquals(testConfig.inputAndOutput().expected(), result);
  }
}
