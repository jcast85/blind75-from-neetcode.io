package com.blind75.problems.stack.car_fleet;

import java.util.Arrays;
import java.util.Comparator;

public class CarFleetNaive implements CarFleet {
  @Override
  public int carFleet(int target, int[] position, int[] speed) {
    int result = 0;
    CarData[] carDataArray = new CarData[position.length];
    int maxSpeed = 0;
    for(int i=0; i<position.length; i++) {
      carDataArray[i] = new CarData(position[i], speed[i]);
      if(speed[i] > maxSpeed) {
        maxSpeed = speed[i];
      }
    }
    Arrays.sort(carDataArray, Comparator.comparing(carData -> carData.position));
    while (Arrays.stream(carDataArray).anyMatch(carData -> !carData.arrived)) {
      for(int i=carDataArray.length-1; i>=0; i--) {
        int speedToUse = Math.max(carDataArray[i].speed, carDataArray[i].nextSpeed);
        boolean isCarReachingOrOvertakingPreviousCar = i < carDataArray.length - 1 && carDataArray[i].position + speedToUse - carDataArray[i + 1].position >= 0;
        if(isCarReachingOrOvertakingPreviousCar) {
          boolean isCarReachingTarget = carDataArray[i].position + speedToUse == target;
          boolean hadCarAlreadyReachedPreviousCar = carDataArray[i].position + speedToUse - carDataArray[i + 1].position == 0
            && speedToUse == carDataArray[i + 1].speed;
          boolean didPreviousCarReachTarget = carDataArray[i + 1].position == target;
          boolean isCarOvertakingPreviousCar = carDataArray[i].position + speedToUse - carDataArray[i + 1].position > 0;
          boolean isCarReachingPreviousCarBeforeReachingTarget = 1.0 * (carDataArray[i + 1].speed - carDataArray[i + 1].position + target)
            / carDataArray[i + 1].speed * carDataArray[i].speed + carDataArray[i].position > target;
          if(isCarReachingTarget ||
            hadCarAlreadyReachedPreviousCar ||
            (isCarOvertakingPreviousCar && didPreviousCarReachTarget) ||
            isCarReachingPreviousCarBeforeReachingTarget
          ) {
            carDataArray[i] = new CarData(carDataArray[i+1].position, carDataArray[i+1].speed, carDataArray[i+1].nextSpeed, carDataArray[i+1].arrived);
          } else {
            carDataArray[i] = new CarData(carDataArray[i+1].position, carDataArray[i+1].speed, carDataArray[i].arrived);
          }
        } else {
          carDataArray[i] = new CarData(carDataArray[i].position + speedToUse, speedToUse, carDataArray[i].arrived);
        }
        boolean hasCarJustReachedTarget = !carDataArray[i].arrived && carDataArray[i].position >= target;
        if(hasCarJustReachedTarget) {
          carDataArray[i].arrived = true;
          carDataArray[i].nextSpeed = maxSpeed;
          result++;
        }
      }
    }
    return result;
  }

  private static class CarData {
    int position;
    int speed;
    int nextSpeed;
    boolean arrived;

    public CarData(int position, int speed) {
      this(position, speed, false);
    }

    public CarData(int position, int speed, boolean arrived) {
      this.position = position;
      this.speed = speed;
      this.nextSpeed = speed;
      this.arrived = arrived;
    }

    public CarData(int position, int speed, int nextSpeed, boolean arrived) {
      this.position = position;
      this.speed = speed;
      this.nextSpeed = nextSpeed;
      this.arrived = arrived;
    }
  }
}
