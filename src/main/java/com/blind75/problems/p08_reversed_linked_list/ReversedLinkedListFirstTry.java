package com.blind75.problems.p08_reversed_linked_list;

public class ReversedLinkedListFirstTry implements ReversedLinkedList {
  @Override
  public ListNode reverseList(ListNode head) {
    if(head == null) {
      return null;
    }
    return reverseList(head, null);
  }

  private ListNode reverseList(ListNode head, ListNode accumulator) {
    if(head.next == null) {
      return ListNode.builder()
        .val(head.val)
        .next(accumulator)
        .build();
    }
    return reverseList(head.next, ListNode.builder()
      .val(head.val)
      .next(accumulator)
      .build());
  }
}
