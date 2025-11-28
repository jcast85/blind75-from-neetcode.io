package com.blind75.problems.p03_two_sum;

import lombok.Builder;

@Builder
public record TwoSumInputAndOutput(int[] nums, int target, int[] expectedResult) {
}
