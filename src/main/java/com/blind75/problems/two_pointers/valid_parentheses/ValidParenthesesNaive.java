package com.blind75.problems.two_pointers.valid_parentheses;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ValidParenthesesNaive implements ValidParentheses {
  private static final Map<Character, Character> BRACKET_PAIRS = Map.of('(', ')', '[', ']', '{', '}');
  private static final Map<Character, Character> BRACKET_PAIRS_REVERSED = Map.of(')', '(', ']','[', '}', '{');

  @Override
  public boolean isValid(String s) {
    List<Character> stack = new ArrayList<>();
    for (int i = 0; i < s.length(); i++) {
      if (BRACKET_PAIRS_REVERSED.containsKey(s.charAt(i))) {
        if(stack.isEmpty()) {
          return false;
        }
        if(stack.getLast() == BRACKET_PAIRS_REVERSED.get(s.charAt(i))) {
          stack.removeLast();
        } else {
          return false;
        }
      } else {
        stack.add(s.charAt(i));
      }
    }
    return stack.isEmpty();
  }
}
