package com.blind75.problems.arrays_and_hashing.valid_sudoki;

import java.util.HashSet;
import java.util.Set;

public class ValidSudokuOptimized implements ValidSudoku {
  @Override
  public boolean isValidSudoku(char[][] board) {
    for(int i=0; i<board.length; i++) {
      Set<Character> isRelatedDigitPresent = new HashSet<>();
      for(int j=0; j<board[i].length; j++) {
        char aChar = board[i][j];
        if (aChar == '.') {
          continue;
        }
        if (isRelatedDigitPresent.contains(aChar)) {
          return false;
        }
        isRelatedDigitPresent.add(aChar);
      }
    }

    for(int i=0; i<board.length; i++) {
      Set<Character> isRelatedDigitPresent = new HashSet<>();
      for(int j=0; j<board[i].length; j++) {
        char aChar = board[j][i];
        if (aChar == '.') {
          continue;
        }
        if (isRelatedDigitPresent.contains(aChar)) {
          return false;
        }
        isRelatedDigitPresent.add(aChar);
      }
    }

    for(int sqI=0; sqI<9; sqI++) {
      Set<Character> isRelatedDigitPresent = new HashSet<>();
      for(int i=0; i<board.length/3; i++) {
        for(int j=0; j<board[i].length/3; j++) {
          char aChar = board[i+sqI/3][j+3*(sqI%3)];
          if (aChar == '.') {
            continue;
          }
          if (isRelatedDigitPresent.contains(aChar)) {
            return false;
          }
          isRelatedDigitPresent.add(aChar);
        }
      }
    }
    return true;
  }

}
