package com.blind75.problems.binary_search.search_a_2d_matrix;

public class SearchA2DMatrixNoSpaceOverhead implements SearchA2DMatrix {
  @Override
  public boolean searchMatrix(int[][] matrix, int target) {
    int rowNumber = matrix.length;
    int colNumber = matrix[0].length;

    int rowIndex = rowNumber -1;
    int colIndex = 0;

    while(rowIndex>=0 && colIndex<colNumber) {
      if(matrix[rowIndex][colIndex] == target) {
        return true;
      }
      if(matrix[rowIndex][colIndex] < target) {
        colIndex++;
      } else {
        if(matrix[rowIndex][colIndex] > target) {
          rowIndex--;
        }
      }
    }
    return false;
  }
}
