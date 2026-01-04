package com.blind75.problems.stack.car_fleet;

import java.util.Arrays;
import java.util.Stack;

public class CarFleetStackOptimized implements CarFleet {
  @Override
  public int carFleet(int target, int[] position, int[] speed) {
    CarData[] carDataArray = new CarData[position.length];
    for(int i=0; i<position.length; i++) {
      carDataArray[i] = new CarData(position[i], speed[i]);
    }
    Arrays.sort(carDataArray, (a, b) -> Integer.compare(b.position, a.position));
    Stack<Double> iterationNumberToArrivalStack = new Stack<>();
    for (CarData carData : carDataArray) {
      iterationNumberToArrivalStack.push(1.0 * (target - carData.position) / carData.speed);
      if(iterationNumberToArrivalStack.size() >= 2) {
        if(iterationNumberToArrivalStack.getLast() <= iterationNumberToArrivalStack.get(iterationNumberToArrivalStack.size() -2)) {
          iterationNumberToArrivalStack.pop();
        }
      }
    }
    return iterationNumberToArrivalStack.size();
  }

  private static class CarData {
    int position;
    int speed;

    public CarData(int position, int speed) {
      this.position = position;
      this.speed = speed;
    }

    @Override
    public String toString() {
      return "CarData{" +
        "position=" + position +
        ", speed=" + speed +
        '}';
    }
  }
}
