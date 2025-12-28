package com.blind75.problems.two_pointers.trapping_rain_water;

import java.util.*;

public class TrappingRainWaterNaive implements TrappingRainWater {
  @Override
  public int trap(int[] height) {
    List<Integer[]> openWaterAreaTail = new ArrayList<>();
    int waterArea = 0;
    int index = 0;
    int index2 = index + 1;
    while(index2<height.length) {
      boolean isWaterAreaStarted = false;
      while(height[index+1] >= height[index] && index2<height.length) {
        index++;
        index2 = index + 1;
      }
      if(index2==height.length-1) {
        break;
      }
      while(!openWaterAreaTail.isEmpty()) {
        if(openWaterAreaTail.getLast()[0] > height[index2-1]) {
          break;
        }
        waterArea += getWaterAreaToAdd(height, openWaterAreaTail, index2);
      }
      openWaterAreaTail.add(new Integer[] {index, height[index], height[index+1], index+1});
      isWaterAreaStarted = true;
      while(height[index2+1] <= height[index2] && index2<height.length-2) {
        if(height[index2+1] == height[index2]) {
          openWaterAreaTail.getLast()[3] = index2+1;
        }
        if(height[index2+1] < height[index2]) {
          openWaterAreaTail.getLast()[3] = index2+1;
          openWaterAreaTail.add(new Integer[] {index2, height[index2], height[index2+1], index2+1});
        }
        index2++;
      }
      if(height[index2+1] <= height[index2] || index2==height.length-1) {
        break;
      }
      waterArea += getWaterAreaToAdd(height, openWaterAreaTail, index2);
      index = index2 + 1;
      index2 = index + 1;
    }

    return waterArea;
  }

  private static int getWaterAreaToAdd(int[] height, List<Integer[]> openWaterAreaTail, int index2) {
    int beginIndex = openWaterAreaTail.getLast()[0];
    int beginValue = openWaterAreaTail.getLast()[1];
    int minValue = openWaterAreaTail.getLast()[2];
    int endIndex = openWaterAreaTail.getLast()[3];
    int endValue = height[endIndex+1];
    int waterAreaToAdd = (Math.min(beginValue, endValue) - minValue) * (endIndex - beginIndex);
    openWaterAreaTail.removeLast();
    if(!openWaterAreaTail.isEmpty()) {
      openWaterAreaTail.getLast()[3] = index2+1;
    }
    if(beginValue > endValue) {
      openWaterAreaTail.add(new Integer[]{beginIndex, beginValue, endValue, index2+1});
    }
    return waterAreaToAdd;
  }
}
