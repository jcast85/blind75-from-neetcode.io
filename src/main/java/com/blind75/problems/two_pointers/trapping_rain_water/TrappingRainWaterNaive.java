package com.blind75.problems.two_pointers.trapping_rain_water;

import java.util.*;

/**
 * N.B. this naive solution doesn't cover all cases, so it is wrong!
 */
public class TrappingRainWaterNaive implements TrappingRainWater {
  @Override
  public int trap(int[] height) {
    List<Integer[]> openWaterAreaTail = new ArrayList<>();
    int waterArea = 0;
    for(int index=0; index<height.length-1; index++) {
      if(height[index]>height[index+1]) {
        if(!openWaterAreaTail.isEmpty()
          && height[index]<(openWaterAreaTail.get(openWaterAreaTail.size()-1)[1])) {
          openWaterAreaTail.get(openWaterAreaTail.size() - 1)[3] = index + 1;
        }
        openWaterAreaTail.add(new Integer[] {index, height[index], height[index+1], index+1});
      }
      if(height[index]==height[index+1]) {
        if(!openWaterAreaTail.isEmpty()
          && height[index]<(openWaterAreaTail.get(openWaterAreaTail.size()-1)[1])) {
          openWaterAreaTail.get(openWaterAreaTail.size() - 1)[3] = index + 1;
        }
      }
      if(height[index]<height[index+1]) {
        //remove,add and update new last
        if(!openWaterAreaTail.isEmpty()) {
          waterArea += getWaterAreaToAdd(height, openWaterAreaTail, index+1);
          for(int i=0; i<openWaterAreaTail.size();) {
            if(height[index+1]>=openWaterAreaTail.get(0)[1]) {
              waterArea += getWaterAreaToAdd(height, openWaterAreaTail, index+1);
            } else {
              i++;
            }
          }
        }
      }
    }
    if(!openWaterAreaTail.isEmpty()) {
      if(height[height.length-1]>=openWaterAreaTail.get(openWaterAreaTail.size()-1)[1]) {
      //remove,add and update new last
        waterArea += getWaterAreaToAdd(height, openWaterAreaTail, height.length-1);
      }
    }


    return waterArea;
  }

  private static int getWaterAreaToAdd(int[] height, List<Integer[]> openWaterAreaTail, int index) {
    int beginIndex = openWaterAreaTail.get(openWaterAreaTail.size()-1)[0];
    int beginValue = openWaterAreaTail.get(openWaterAreaTail.size()-1)[1];
    int minValue = openWaterAreaTail.get(openWaterAreaTail.size()-1)[2];
    int endIndex = openWaterAreaTail.get(openWaterAreaTail.size()-1)[3];
    int endValue = height[endIndex+1];
    int waterAreaToAdd = (Math.min(beginValue, endValue) - minValue) * (endIndex - beginIndex);
    height[endIndex] = Math.min(beginValue, endValue);
    openWaterAreaTail.remove(openWaterAreaTail.size()-1);
    if(!openWaterAreaTail.isEmpty()) {
      if(endValue<openWaterAreaTail.get(openWaterAreaTail.size()-1)[1]) {
        if(endValue>openWaterAreaTail.get(openWaterAreaTail.size()-1)[2]) {
          waterAreaToAdd +=(endValue - openWaterAreaTail.get(openWaterAreaTail.size()-1)[2]) * (endIndex - openWaterAreaTail.get(openWaterAreaTail.size()-1)[0]);
          Integer[] newValue = {
            openWaterAreaTail.get(openWaterAreaTail.size()-1)[0],
            openWaterAreaTail.get(openWaterAreaTail.size()-1)[1],
            endValue,
            index + 1};
          openWaterAreaTail.remove(openWaterAreaTail.size()-1);
          openWaterAreaTail.add(newValue);
        } else {
          openWaterAreaTail.get(openWaterAreaTail.size()-1)[3] = index;
        }
      }
    }
    if(beginValue > endValue) {
      openWaterAreaTail.add(new Integer[]{beginIndex, beginValue, endValue, index});
    }
    return waterAreaToAdd;
  }
}
