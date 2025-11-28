package com.blind75.problems.p03_two_sum;

import java.util.HashMap;
import java.util.Map;

public class TwoSumFirstTry implements TwoSum {
    @Override
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> diffByIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer pairIndex = diffByIndex.get(nums[i]);
            if (pairIndex != null) {
                return new int[] { pairIndex, i };
            }
            diffByIndex.put(target - nums[i], i);
        }
        return new int[0];
    }
}
