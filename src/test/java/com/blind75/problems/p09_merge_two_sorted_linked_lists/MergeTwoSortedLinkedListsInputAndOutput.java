package com.blind75.problems.p09_merge_two_sorted_linked_lists;

import com.blind75.problems.common.ListNode;
import lombok.Builder;

@Builder
public record MergeTwoSortedLinkedListsInputAndOutput(ListNode list1, ListNode list2, ListNode expected) {
}
