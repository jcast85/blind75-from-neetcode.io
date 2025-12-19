package com.blind75.problems.linked_list.p010_linked_list_dycle_detection;

import com.blind75.problems.common.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class LinkedListCycleDetectionTest {

  private static final List<LinkedListCycleDetection> linkedListCycleDetectionList = List.of(
    new LinkedListCycleDetectionWithSet(),
    new LinkedListCycleDetectionWithPointer()
  );

  private static final List<InputAndOutput> linkedListCycleDetectionInputAndOutputList;

  static {
    ListNode listNode = ListNode.of(1, 2, 3, 4);
    listNode.next.next.next = listNode.next;
    linkedListCycleDetectionInputAndOutputList = List.of(
      new SingleInputAndOutputBuilder<>()
        .input(listNode)
        .output(true)
        .build(),
      new SingleInputAndOutputBuilder<>()
        .input(ListNode.of(1, 2))
        .output(false)
        .build()
    );
  }

  static Stream<SingleMethodTestConfig<LinkedListCycleDetection>> testConfigs() {
    Stream.Builder<SingleMethodTestConfig<LinkedListCycleDetection>> streamBuilder = Stream.builder();
    for (LinkedListCycleDetection linkedListCycleDetection : linkedListCycleDetectionList) {
      for (InputAndOutput linkedListCycleDetectionInputAndOutput : linkedListCycleDetectionInputAndOutputList) {
        streamBuilder.add(new SingleMethodTestConfigBuilder<LinkedListCycleDetection>()
          .implementationToTest(linkedListCycleDetection)
          .inputAndOutput(linkedListCycleDetectionInputAndOutput)
          .build());
      }
    }
    return streamBuilder.build();
  }

  @ParameterizedTest
  @MethodSource("testConfigs")
  void testExample(SingleMethodTestConfig<LinkedListCycleDetection> singleMethodTestConfig) {
    SingleInputAndOutput<ListNode, Boolean> inputAndOutput = (SingleInputAndOutput) singleMethodTestConfig.inputAndOutput();
    boolean result = singleMethodTestConfig.implementationToTest().hasCycle(inputAndOutput.input());
    CommonStaticTestMethods.assertions(result, inputAndOutput.output());
  }
}
