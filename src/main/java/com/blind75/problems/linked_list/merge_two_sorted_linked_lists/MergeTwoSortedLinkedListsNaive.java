package com.blind75.problems.linked_list.merge_two_sorted_linked_lists;

import com.blind75.problems.common.ListNode;

public class MergeTwoSortedLinkedListsNaive implements MergeTwoSortedLinkedLists {
  @Override
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    if(list1 == null || (list1.val == 0 && list1.next == null)) {
      return list2;
    }
    if(list2 == null || (list2.val == 0 && list2.next == null)) {
      return list1;
    }
    ListNode accumulator = new ListNode();
    ListNode current = accumulator;
    while(list1 != null && list2 != null) {
      if(list1.val <= list2.val) {
        current.val = list1.val;
        list1 = list1.next;
      } else {
        current.val = list2.val;
        list2 = list2.next;
      }
      current.next = new ListNode();
      current = current.next;
    }
    if(list1 == null) {
      current.val = list2.val;
      current.next = list2.next;
    }
    if(list2 == null) {
      current.val = list1.val;
      current.next = list1.next;
    }
    return accumulator;
  }
}
