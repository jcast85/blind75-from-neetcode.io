package com.blind75.problems.p04_valid_palindrome;

import lombok.Builder;

@Builder
public record ValidPalindromeInputAndOutput(String s, boolean expectedIsPalindrome) {
}
