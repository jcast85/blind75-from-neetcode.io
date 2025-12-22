package com.blind75.problems.arrays_and_hashing.valid_sudoki;

public class ValidSudokuNaive implements ValidSudoku {
  @Override
  public boolean isValidSudoku(char[][] board) {
    for (char[] chars : board) {
      boolean validSudokuRow = isValidSudokuBlock(chars);
      if (!validSudokuRow) {
        return false;
      }
    }
    for(int i=0; i<board.length; i++) {
      char[] sudokuColumn = getColumn(board, i);
      boolean validSudokuColumn = isValidSudokuBlock(sudokuColumn);
      if(!validSudokuColumn) {
        return false;
      }
    }
    for(int i=0; i<Math.sqrt(board.length); i++) {
      for(int j=0; j<Math.sqrt(board[i].length); j++) {
        char[] sudokuSubBox = getSubBox(board, i, j);
        boolean validSudokuSubBox = isValidSudokuBlock(sudokuSubBox);
        if(!validSudokuSubBox) {
          return false;
        }
      }
    }

    return true;
  }

  private boolean isValidSudokuBlock(char[] chars) {
    boolean[] isRelatedDigitPresent = new boolean[] {false, false, false, false, false, false, false, false, false};
    for (char aChar : chars) {
      int numericValue = Character.getNumericValue(aChar);
      if (numericValue < 0) {
        continue;
      }
      if (isRelatedDigitPresent[numericValue - 1]) {
        return false;
      }
      isRelatedDigitPresent[numericValue - 1] = true;
    }
    return true;
  }

  private char[] getColumn(char[][] board, int columnIndex) {
    char[] sudokuColumn = new char[board.length];
    for (int i=0; i<board.length; i++) {
      sudokuColumn[i] = board[i][columnIndex];
    }
    return sudokuColumn;
  }

  private char[] getSubBox(char[][] board, int verticalIndex, int horizontalIndex) {
    char[] sudokuSubBox = new char[board.length];
    int hSqrt = (int) Math.sqrt(board.length);
    for(int i = 0; i< hSqrt; i++) {
      int sVqrt = (int) Math.sqrt(board[i].length);
      for(int j = 0; j< sVqrt; j++) {
        sudokuSubBox[i+j] = board[hSqrt*horizontalIndex+i][sVqrt*verticalIndex+j];
      }
    }
    return sudokuSubBox;
  }
}
