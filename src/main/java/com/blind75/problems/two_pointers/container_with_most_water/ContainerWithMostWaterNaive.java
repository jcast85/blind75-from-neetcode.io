package com.blind75.problems.two_pointers.container_with_most_water;

public class ContainerWithMostWaterNaive implements ContainerWithMostWater {
  @Override
  public int maxArea(int[] heights) {
    int indexFromBegin = 0;
    int indexFromEnd = heights.length-1;
    int maxArea = 0;
    while (indexFromBegin < indexFromEnd) {
      int currentHeight = Math.min(heights[indexFromBegin], heights[indexFromEnd]);
      int currentArea = currentHeight * (indexFromEnd-indexFromBegin);
      if(currentArea > maxArea) {
        maxArea = currentArea;
      }
      while(heights[indexFromBegin] == currentHeight) {
        indexFromBegin++;
      }
      while(heights[indexFromEnd] == currentHeight) {
        indexFromEnd--;
      }

    }
    return maxArea;
  }
}
