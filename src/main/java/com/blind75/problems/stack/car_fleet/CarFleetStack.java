package com.blind75.problems.stack.car_fleet;

import java.util.Arrays;
import java.util.Stack;

public class CarFleetStack implements CarFleet {
  @Override
  public int carFleet(int target, int[] position, int[] speed) {
    CarData[] carDataArray = new CarData[position.length];
    for(int i=0; i<position.length; i++) {
      carDataArray[i] = new CarData(position[i], speed[i], false, false);
    }
    Arrays.sort(carDataArray, (a, b) -> Integer.compare(b.position, a.position));
    while (Arrays.stream(carDataArray).anyMatch(carData -> !carData.isToSkip && carData.position < target )) {
      Stack<CarData> stack = new Stack<>();
      for (CarData carData : carDataArray) {
        if (carData.isToSkip || carData.arrived) {
          continue;
        }
        if (!stack.isEmpty() && isToSkip(carData, stack.peek(), target)) {
          carData.isToSkip = true;
        } else {
          int newPosition = carData.position + carData.speed;
          carData.position = newPosition;
          stack.push(carData);
          if(newPosition >= target) {
            carData.arrived = true;
          }
        }
      }
    }
    return Math.toIntExact(Arrays.stream(carDataArray)
      .filter(carData -> !carData.isToSkip)
      .count());
  }

  private boolean isToSkip(CarData carData, CarData peek, int target) {
    boolean isCarReachingPreviousCarBeforeReachingTarget = 1.0 * (peek.speed - peek.position + target)
      / peek.speed * carData.speed + carData.position >= target;
    return carData.position + carData.speed >= peek.position && isCarReachingPreviousCarBeforeReachingTarget;
  }

  private static class CarData {
    int position;
    int speed;
    boolean isToSkip;
    boolean arrived;

    public CarData(int position, int speed, boolean isToSkip, boolean arrived) {
      this.position = position;
      this.speed = speed;
      this.isToSkip = isToSkip;
      this.arrived = arrived;
    }

    @Override
    public String toString() {
      return "CarData{" +
        "position=" + position +
        ", speed=" + speed +
        ", isToSkip=" + isToSkip +
        ", arrived=" + arrived +
        '}';
    }
  }
}
