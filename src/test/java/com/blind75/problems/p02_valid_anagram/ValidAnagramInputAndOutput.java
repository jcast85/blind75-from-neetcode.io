package com.blind75.problems.p02_valid_anagram;

import lombok.Builder;

@Builder
public record ValidAnagramInputAndOutput(String s, String t, boolean expectedIsAnagram) {
}
