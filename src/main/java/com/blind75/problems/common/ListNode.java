package com.blind75.problems.common;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@Builder
@EqualsAndHashCode
public class ListNode {
  public int val;
  public ListNode next;
  public ListNode() {}
  public ListNode(int val) { this.val = val; }
  public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

  public static ListNode of(Integer... val) {
    if(val == null || val.length == 0) {
      return ListNode.builder().build();
    }
    ListNode head = null;
    for(int i = val.length - 1; i >= 0; i--) {
      head = ListNode.builder().val(val[i]).next(head).build();
    }
    return head;
  }
}
