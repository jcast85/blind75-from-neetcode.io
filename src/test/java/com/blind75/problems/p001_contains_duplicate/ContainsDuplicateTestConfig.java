package com.blind75.problems.p001_contains_duplicate;

import lombok.Builder;

@Builder
public record ContainsDuplicateTestConfig(ContainsDuplicate containsDuplicate,
        ContainsDuplicateInputAndOutput inputAndOutput) {
}
