package com.blind75.problems.p17_kth_largest_element_in_a_stream;

import org.junit.jupiter.api.Test;

public class KthLargestElementInAStreamTest {
  @Test
  void test1() {
    KthLargest kthLargest = new KthLargest(3, new int[]{1, 2, 3, 3});
    int result;
    result = kthLargest.add(3);
    assert result == 3;
    result = kthLargest.add(5);
    assert result == 3;
    result = kthLargest.add(6);
    assert result == 3;
    result = kthLargest.add(7);
    assert result == 5;
    result = kthLargest.add(8);
    assert result == 6;
  }
}
