package com.blind75.problems.stack.daily_temperatures;

import java.util.ArrayList;
import java.util.List;

public class DailyTemperaturesNaive implements DailyTemperatures {
  @Override
  public int[] dailyTemperatures(int[] temperatures) {
    List<TemperatureData> temperatureDataList = new ArrayList<>();
    int[] result = new int[temperatures.length];
    for(int i=temperatures.length-1; i>=0; i--) {
      if(i>0) {
        if (temperatures[i] >= temperatures[i - 1]) {
          temperatureDataList.add(new TemperatureData(i, temperatures[i]));
        }
      }
      for(int j=temperatureDataList.size()-1; j>=0; j--) {
        if(temperatureDataList.get(j).value() >temperatures[i]
          && temperatureDataList.get(j).index() > i
        ) {
          result[i] = temperatureDataList.get(j).index() - i;
          break;
        }
      }

    }
    return result;
  }

}
