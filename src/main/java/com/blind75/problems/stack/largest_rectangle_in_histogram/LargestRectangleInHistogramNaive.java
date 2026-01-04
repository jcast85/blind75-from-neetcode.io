package com.blind75.problems.stack.largest_rectangle_in_histogram;

import java.util.Stack;

public class LargestRectangleInHistogramNaive implements LargestRectangleInHistogram {
  @Override
  public int largestRectangleArea(int[] heights) {
    int largestRectangleArea = 0;
    Stack<RectangleData> rectangleDataStack = new Stack<>();
    rectangleDataStack.push(new RectangleData(0, 0, 0, false));
    for(int i=1; i<heights.length; i++) {
      if(heights[i] < heights[i-1]) {
        int newStartIndex = 0;
        while(!rectangleDataStack.isEmpty() && heights[rectangleDataStack.peek().indexMaxHeight] > heights[i]) {
          RectangleData pop = rectangleDataStack.pop();
          pop.endIndex = i-1;
          pop.isClosed = true;
          largestRectangleArea = Math.max(largestRectangleArea, RectangleData.getArea(pop, heights));
          newStartIndex = pop.startIndex;
        }
        rectangleDataStack.push(new RectangleData(newStartIndex, i, i, false));
      }
      if(heights[i] > heights[i-1]) {
        rectangleDataStack.push(new RectangleData(i, i, i, false));
      }
    }
    while(!rectangleDataStack.isEmpty()) {
      RectangleData pop = rectangleDataStack.pop();
      pop.endIndex = heights.length-1;
      pop.isClosed = true;
      largestRectangleArea = Math.max(largestRectangleArea, RectangleData.getArea(pop, heights));
    }
    return largestRectangleArea;
  }

  private static class RectangleData {
    int startIndex;
    int endIndex;
    int indexMaxHeight;
    boolean isClosed;

    public RectangleData(int startIndex, int endIndex, int indexMaxHeight, boolean isClosed) {
      this.startIndex = startIndex;
      this.endIndex = endIndex;
      this.indexMaxHeight = indexMaxHeight;
      this.isClosed = isClosed;
    }

    @Override
    public String toString() {
      return "RectangleData{" +
        "startIndex=" + startIndex +
        ", endIndex=" + endIndex +
        ", indexMaxHeight=" + indexMaxHeight +
        ", isClosed=" + isClosed +
        '}';
    }

    public static int getArea(RectangleData rectangleData, int[] heights) {
      return (rectangleData.endIndex - rectangleData.startIndex + 1) * heights[rectangleData.indexMaxHeight];
    }
  }
}
