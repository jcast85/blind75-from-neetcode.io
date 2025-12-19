package com.blind75.problems.arrays_and_hashing.contains_duplicate;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicateFirstTry implements ContainsDuplicate {
    @Override
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            boolean addOutcome = numSet.add(num);
            if (!addOutcome) {
                return true;
            }
        }
        return false;
    }
}
