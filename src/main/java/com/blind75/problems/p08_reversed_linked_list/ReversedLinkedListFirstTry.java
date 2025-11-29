package com.blind75.problems.p08_reversed_linked_list;

public class ReversedLinkedListFirstTry implements ReversedLinkedList {
  @Override
  public ListNode reverseList(ListNode head) {
    return reverseList(head.val, head.next, null);
  }

  public ListNode reverseList(int val, ListNode next, ListNode accumulator) {
    if(next == null) {
      return ListNode.builder()
        .val(val)
        .next(accumulator)
        .build();
    }
    return reverseList(next.val, next.next, ListNode.builder()
      .val(val)
      .next(accumulator)
      .build());
  }
}
