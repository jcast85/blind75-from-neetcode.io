package com.blind75.problems.p004_valid_palindrome;

import lombok.Builder;

@Builder
public record ValidPalindromeInputAndOutput(String s, boolean expectedIsPalindrome) {
}
