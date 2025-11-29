package com.blind75.problems.p002_valid_anagram;

import lombok.Builder;

@Builder
public record ValidAnagramTestConfig(ValidAnagram validAnagram, ValidAnagramInputAndOutput inputAndOutput) {
}
