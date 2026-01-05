package com.blind75.problems.binary_search.search_a_2d_matrix;

public class SearchA2DMatrixDichotomicSearch implements SearchA2DMatrix {
  private int colNumber = 1;

  @Override
  public boolean searchMatrix(int[][] matrix, int target) {
    int rowNumber = matrix.length;
    colNumber = matrix[0].length;
    int matrixSize = rowNumber * colNumber;

    return searchMatrix(matrix, target, 0, matrixSize-1);
  }

  boolean searchMatrix(int[][] matrix, int target, int beginIndex, int endIndex) {
    if(beginIndex > endIndex) {
      return false;
    }
    int index = (endIndex - beginIndex) / 2 + beginIndex;
    int rowIndex = index % colNumber;
    int colIndex = index / colNumber;
    if(matrix[colIndex][rowIndex] == target) {
      return true;
    }
    if(matrix[colIndex][rowIndex] < target) {
      return searchMatrix(matrix, target, index+1, endIndex);
    }
    if(matrix[colIndex][rowIndex] > target) {
      return searchMatrix(matrix, target, beginIndex, index-1);
    }
    return false;
  }
}
