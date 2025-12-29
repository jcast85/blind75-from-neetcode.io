package com.blind75.problems.linked_list.linked_list_dycle_detection;

import com.blind75.problems.common.ListNode;

public class LinkedListCycleDetectionWithPointer implements LinkedListCycleDetection {
  @Override
  public boolean hasCycle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if(slow == fast) {
        return true;
      }
    }
    return false;
  }
}
