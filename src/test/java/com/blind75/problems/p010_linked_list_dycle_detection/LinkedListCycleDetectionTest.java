package com.blind75.problems.p010_linked_list_dycle_detection;

import com.blind75.problems.common.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class LinkedListCycleDetectionTest {

  private static final List<LinkedListCycleDetection> linkedListCycleDetectionList = List.of(
    new LinkedListCycleDetectionWithSet());

  private static final List<LinkedListCycleDetectionInputAndOutput> linkedListCycleDetectionInputAndOutputList;

  static {
    ListNode listNode = ListNode.of(1, 2, 3, 4);
    listNode.next.next.next = listNode.next;
    linkedListCycleDetectionInputAndOutputList = List.of(
      LinkedListCycleDetectionInputAndOutput.builder()
        .head(listNode)
        .expected(true)
        .build(),
      LinkedListCycleDetectionInputAndOutput.builder()
        .head(ListNode.of(1, 2))
        .expected(false)
        .build()
    );
  }

  static Stream<LinkedListCycleDetectionTestConfig> testConfigs() {
    Stream.Builder<LinkedListCycleDetectionTestConfig> streamBuilder = Stream.builder();
    for (LinkedListCycleDetection linkedListCycleDetection : linkedListCycleDetectionList) {
      for (LinkedListCycleDetectionInputAndOutput linkedListCycleDetectionInputAndOutput : linkedListCycleDetectionInputAndOutputList) {
        streamBuilder.add(LinkedListCycleDetectionTestConfig.builder()
          .linkedListCycleDetection(linkedListCycleDetection)
          .inputAndOutput(linkedListCycleDetectionInputAndOutput).build());
      }
    }
    return streamBuilder.build();
  }

  @ParameterizedTest
  @MethodSource("testConfigs")
  void testExample(LinkedListCycleDetectionTestConfig testConfig) {
    boolean result = testConfig.linkedListCycleDetection().hasCycle(testConfig.inputAndOutput().head());
    Assertions.assertEquals(testConfig.inputAndOutput().expected(), result);
  }
}
