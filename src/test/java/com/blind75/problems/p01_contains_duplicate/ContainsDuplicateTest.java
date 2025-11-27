package com.blind75.problems.p01_contains_duplicate;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContainsDuplicateTest {
    @Test
    void testHasDuplicate() {
        ContainsDuplicate containsDuplicate = new ContainsDuplicate();
        int[] nums = { 1, 2, 3, 4 };
        boolean result = containsDuplicate.hasDuplicate(nums);
        assertFalse(result);
    }

    @Test
    void testHasDuplicate2() {
        ContainsDuplicate containsDuplicate = new ContainsDuplicate();
        int[] nums = { 1, 2, 3, 3 };
        boolean result = containsDuplicate.hasDuplicate(nums);
        assertTrue(result);
    }
}