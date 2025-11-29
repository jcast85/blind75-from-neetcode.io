package com.blind75.problems.p007_binary_search;

import lombok.Builder;

@Builder
public record BinarySearchInputAndOutput(int[] nums, int target, int expected) {
}
