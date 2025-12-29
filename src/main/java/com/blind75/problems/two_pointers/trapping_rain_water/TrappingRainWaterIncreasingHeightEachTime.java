package com.blind75.problems.two_pointers.trapping_rain_water;

import java.util.*;

public class TrappingRainWaterIncreasingHeightEachTime implements TrappingRainWater {
  @Override
  public int trap(int[] height) {
    int maxHeight = 0;
    Map<Integer, List<Integer>> indexListByHeight = new HashMap<>();
    List<Long> relativeMaxIndexList = new ArrayList<>();
    boolean isDirectionChanged = false;
    for (int index=0; index<height.length; index++) {
      if(height[index]>maxHeight) {
        maxHeight = height[index];
      }
      List<Integer> indexList;
      if(indexListByHeight.containsKey(height[index])) {
        indexList = indexListByHeight.get(height[index]);
      } else {
        indexList = new ArrayList<>();
      }
      indexList.add(index);
      indexListByHeight.put(height[index], indexList);
      if(index<height.length-1) {
        if(relativeMaxIndexList.isEmpty()) {
          if(height[index] > height[index+1]) {
            relativeMaxIndexList.add((long) index);
          }
        } else {
          if(height[index] < height[index+1]) {
            isDirectionChanged = true;
          }
          if(isDirectionChanged && height[index] > height[index+1]) {
            relativeMaxIndexList.add((long) index);
            isDirectionChanged = false;
          }
        }
      }
    }
    for (int index=height.length-1; index>0; index--) {
      if(height[index-1] < height[index]) {
        if(relativeMaxIndexList.isEmpty() || relativeMaxIndexList.get(relativeMaxIndexList.size()-1) != index) {
          relativeMaxIndexList.add((long) index);
        }
        break;
      }
    }
    if(relativeMaxIndexList.size()<2) {
      return 0;
    }

    int waterArea = 0;
    for(int h=0; h<maxHeight; h++) {
      List<Integer> indexList = indexListByHeight.get(h);
      if(indexList != null) {
        for (Integer index : indexList) {
          if(index<relativeMaxIndexList.get(0)) {
            continue;
          }
          if(index>relativeMaxIndexList.get(relativeMaxIndexList.size()-1)) {
            continue;
          }
          if(isLowerThanAtLeastANextRelativeMaxHeight(height, index, relativeMaxIndexList)
            && isLowerThanAtLeastAPreviousRelativeMaxHeight(height, index, relativeMaxIndexList)
          ) {
            waterArea++;
            height[index]++;
            List<Integer> nextHeightIndexList = indexListByHeight.get(h + 1);
            if(nextHeightIndexList == null) {
              nextHeightIndexList = new ArrayList<>();
            }
            nextHeightIndexList.add(index);
            indexListByHeight.put(h + 1, nextHeightIndexList);
          }
        }
      }

    }
    return waterArea;
  }

  private boolean isLowerThanAtLeastAPreviousRelativeMaxHeight(int[] height, Integer index, List<Long> relativeMaxIndexList) {
    return relativeMaxIndexList.stream()
      .filter(relativeMaxIndex -> relativeMaxIndex < index)
      .map(relativeMaxIndex -> height[relativeMaxIndex.intValue()])
      .anyMatch(relativeMaxHeight -> relativeMaxHeight > height[index]);
  }

  private boolean isLowerThanAtLeastANextRelativeMaxHeight(int[] height, Integer index, List<Long> relativeMaxIndexList) {
    return relativeMaxIndexList.stream()
      .filter(relativeMaxIndex -> relativeMaxIndex > index)
      .map(relativeMaxIndex -> height[relativeMaxIndex.intValue()])
      .anyMatch(relativeMaxHeight -> relativeMaxHeight > height[index]);
  }
}
