package com.blind75.problems.stack.daily_temperatures;

import java.util.Stack;

public class DailyTemperaturesStack implements DailyTemperatures {
  @Override
  public int[] dailyTemperatures(int[] temperatures) {
    int[] result = new int[temperatures.length];
    Stack<TemperatureData> temperatureDataStack = new Stack<>();
    temperatureDataStack.push(new TemperatureData(temperatures.length-1, temperatures[temperatures.length-1]));
    for(int i=temperatures.length-2; i>=0; i--) {
      if(temperatures[i] > temperatures[i+1]) {
        while(!temperatureDataStack.isEmpty() && temperatureDataStack.peek().value() <= temperatures[i]) {
          temperatureDataStack.pop();
        }
        if(!temperatureDataStack.isEmpty() && temperatureDataStack.peek().value() > temperatures[i]) {
          result[i] = temperatureDataStack.peek().index() - i;
        }
      }
      if(temperatures[i] < temperatures[i+1]) {
        result[i] = 1;
      }
      if(temperatures[i] == temperatures[i+1]) {
        if(result[i+1] == 0) {
          result[i] = 0;
        } else {
          result[i] = result[i+1] + 1;
        }
      }
      temperatureDataStack.push(new TemperatureData(i, temperatures[i]));
    }
    return result;
  }
}
