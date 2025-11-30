package com.blind75.problems.p010_linked_list_dycle_detection;

import com.blind75.problems.common.ListNode;
import lombok.Builder;

@Builder
public record LinkedListCycleDetectionInputAndOutput(ListNode head, boolean expected) {
}
