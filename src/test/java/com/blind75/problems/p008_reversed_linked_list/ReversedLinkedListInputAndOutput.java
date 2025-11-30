package com.blind75.problems.p008_reversed_linked_list;

import com.blind75.problems.common.ListNode;
import lombok.Builder;

@Builder
public record ReversedLinkedListInputAndOutput(ListNode head, ListNode expected) {
}
