package com.blind75.problems.two_pointers.trapping_rain_water;

import java.util.ArrayList;
import java.util.List;

public class TrappingRainWaterOptimized implements TrappingRainWater {
  @Override
  public int trap(int[] height) {
    int waterArea = 0;

    int maxHeight = 0;
    List<Integer> maxHeightIndexList = new ArrayList<>();
    for (int i=0; i<height.length; i++) {
      if(height[i] == maxHeight) {
        maxHeightIndexList.add(i);
      }
      if(height[i] > maxHeight) {
        maxHeightIndexList = new ArrayList<>();
        maxHeightIndexList.add(i);
        maxHeight = height[i];
      }
    }
    int indexFromBegin = 0;
    int indexFromEnd = height.length-1;
    int maxHeightIndexListCurrentIndexFromBegin = 0;
    int maxHeightIndexListCurrentIndexFromEnd = maxHeightIndexList.size()-1;
    while (indexFromBegin < indexFromEnd
//      && maxHeightIndexList.get(maxHeightIndexListCurrentIndexFromBegin)-indexFromBegin > 1
//      && indexFromEnd-maxHeightIndexList.get(maxHeightIndexListCurrentIndexFromEnd) > 1
    ) {
      while(indexFromBegin < height.length-1 && height[indexFromBegin] < height[indexFromBegin+1]) {
        indexFromBegin++;
      }
      while(maxHeightIndexListCurrentIndexFromBegin+1<maxHeightIndexList.size() && maxHeightIndexList.get(maxHeightIndexListCurrentIndexFromBegin) <= indexFromBegin) {
        maxHeightIndexListCurrentIndexFromBegin++;
      }
      while(indexFromEnd > 0 && height[indexFromEnd] < height[indexFromEnd-1]) {
        indexFromEnd--;
      }
      while(maxHeightIndexListCurrentIndexFromEnd-1>0 && maxHeightIndexList.get(maxHeightIndexListCurrentIndexFromEnd) >= indexFromEnd) {
        maxHeightIndexListCurrentIndexFromEnd--;
      }

      int upperBoundToUseFromBeginToFillWithWater = height[indexFromBegin];
      while(indexFromBegin+1 < maxHeightIndexList.get(maxHeightIndexListCurrentIndexFromBegin)) {
        if(upperBoundToUseFromBeginToFillWithWater < height[indexFromBegin+1]) {
          upperBoundToUseFromBeginToFillWithWater = height[indexFromBegin+1];
        } else {
          waterArea += upperBoundToUseFromBeginToFillWithWater - height[indexFromBegin+1];
        }
        indexFromBegin++;
      }
      int upperBoundToUseFromEndToFillWithWater = height[indexFromEnd];
      while(indexFromBegin < indexFromEnd-1 && indexFromEnd-1 > maxHeightIndexList.get(maxHeightIndexListCurrentIndexFromEnd)) {
        if(upperBoundToUseFromEndToFillWithWater < height[indexFromEnd-1]) {
          upperBoundToUseFromEndToFillWithWater = height[indexFromEnd-1];
        } else {
          waterArea += upperBoundToUseFromEndToFillWithWater - height[indexFromEnd-1];
        }
        indexFromEnd--;
      }
      indexFromBegin++;
      indexFromEnd--;
    }
    return waterArea;
  }
}
