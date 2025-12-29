package com.blind75.problems.two_pointers.trapping_rain_water;

import java.util.*;

public class TrappingRainWaterIncreasingHeightEachTime implements TrappingRainWater {
  @Override
  public int trap(int[] height) {
    int[] copyHeight = Arrays.copyOf(height, height.length);
    int maxHeight = 0;
    Map<Integer, List<Integer>> indexListByHeight = new HashMap<>();
    List<Long> relativeMaxIndexList = new ArrayList<>();
    boolean isDirectionChanged = false;
    for (int index=0; index<copyHeight.length; index++) {
      if(copyHeight[index]>maxHeight) {
        maxHeight = copyHeight[index];
      }
      List<Integer> indexList;
      if(indexListByHeight.containsKey(copyHeight[index])) {
        indexList = indexListByHeight.get(copyHeight[index]);
      } else {
        indexList = new ArrayList<>();
      }
      indexList.add(index);
      indexListByHeight.put(copyHeight[index], indexList);
      if(index<copyHeight.length-1) {
        if(relativeMaxIndexList.isEmpty()) {
          if(copyHeight[index] > copyHeight[index+1]) {
            relativeMaxIndexList.add((long) index);
          }
        } else {
          if(copyHeight[index] < copyHeight[index+1]) {
            isDirectionChanged = true;
          }
          if(isDirectionChanged && copyHeight[index] > copyHeight[index+1]) {
            relativeMaxIndexList.add((long) index);
            isDirectionChanged = false;
          }
        }
      }
    }
    for (int index=copyHeight.length-1; index>0; index--) {
      if(copyHeight[index-1] < copyHeight[index]) {
        if(relativeMaxIndexList.isEmpty() || relativeMaxIndexList.getLast() != index) {
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
          if(index<relativeMaxIndexList.getFirst()) {
            continue;
          }
          if(index>relativeMaxIndexList.getLast()) {
            continue;
          }
          if(isLowerThanAtLeastANextRelativeMaxHeight(copyHeight, index, relativeMaxIndexList)
            && isLowerThanAtLeastAPreviousRelativeMaxHeight(copyHeight, index, relativeMaxIndexList)
          ) {
            waterArea++;
            copyHeight[index]++;
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
