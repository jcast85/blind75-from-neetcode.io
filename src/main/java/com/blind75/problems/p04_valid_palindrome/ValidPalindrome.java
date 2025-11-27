package com.blind75.problems.p04_valid_palindrome;

public class ValidPalindrome {
  public boolean isPalindrome(String s) {
    int indexFromStart = 0;
    int indexFromEnd = s.length()-1;

    while(indexFromStart<indexFromEnd) {
      if(!Character.isLetterOrDigit(s.charAt(indexFromStart))) {
        indexFromStart = indexFromStart + 1;
        continue;
      }
      if(!Character.isLetterOrDigit(s.charAt(indexFromEnd))) {
        indexFromEnd = indexFromEnd - 1;
        continue;
      }
      if(!equalsIgnoreCase(s.charAt(indexFromStart), s.charAt(indexFromEnd))) {
        return false;
      }
      indexFromStart = indexFromStart + 1;
      indexFromEnd = indexFromEnd - 1;
    }
    return true;
  }

  public static boolean equalsIgnoreCase(char a, char b) {
    return Character.toLowerCase(a) == Character.toLowerCase(b);
  }
}
