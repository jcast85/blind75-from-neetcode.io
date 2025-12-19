package com.blind75.problems.linked_list.p010_linked_list_dycle_detection;

import com.blind75.problems.common.ListNode;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycleDetectionWithSet implements LinkedListCycleDetection {
  @Override
  public boolean hasCycle(ListNode head) {
    Set<Integer> seen = new HashSet<>();
    while (head != null && head.next != null) {
      if(!seen.add(head.val)) {
        return true;
      }
      head = head.next;
    }
    return false;
  }
}
