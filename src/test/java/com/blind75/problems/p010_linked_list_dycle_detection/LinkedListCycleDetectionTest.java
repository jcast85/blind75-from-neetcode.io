package com.blind75.problems.p010_linked_list_dycle_detection;

import com.blind75.problems.common.*;
import org.junit.jupiter.api.Assertions;
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

  static Stream<TestConfig<LinkedListCycleDetection>> testConfigs() {
    Stream.Builder<TestConfig<LinkedListCycleDetection>> streamBuilder = Stream.builder();
    for (LinkedListCycleDetection linkedListCycleDetection : linkedListCycleDetectionList) {
      for (InputAndOutput linkedListCycleDetectionInputAndOutput : linkedListCycleDetectionInputAndOutputList) {
        streamBuilder.add(new TestConfigBuilder<LinkedListCycleDetection>()
          .interfaceToTest(linkedListCycleDetection)
          .inputAndOutput(linkedListCycleDetectionInputAndOutput)
          .build());
      }
    }
    return streamBuilder.build();
  }

  @ParameterizedTest
  @MethodSource("testConfigs")
  void testExample(TestConfig<LinkedListCycleDetection> testConfig) {
    SingleInputAndOutput<ListNode, Boolean> inputAndOutput = (SingleInputAndOutput) testConfig.inputAndOutput();
    boolean result = testConfig.interfaceToTest().hasCycle(inputAndOutput.input());
    Assertions.assertEquals(inputAndOutput.output(), result);
  }
}
