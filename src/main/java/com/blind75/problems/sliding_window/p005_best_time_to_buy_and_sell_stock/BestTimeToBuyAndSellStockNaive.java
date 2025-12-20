package com.blind75.problems.sliding_window.p005_best_time_to_buy_and_sell_stock;

import java.util.Arrays;
import java.util.List;

public class BestTimeToBuyAndSellStockNaive implements BestTimeToBuyAndSellStock {
  @Override
  public int maxProfit(int[] prices) {
    Integer highestFromEndIndex = null;
    Integer lowestFromStartIndex = null;
    Integer highestFromEndValue = null;
    Integer lowestFromStartValue = null;
    Integer maxDifference = 0;
    Integer currentIndexFromStart = 0;
    Integer currentIndexFromEnd = prices.length - 1;
    Integer currentDifference;
    Integer highestCurrentEndDifference = 0;
    Integer highestCurrentStartDifference = 0;
    Integer currentEndLowestDifference = 0;
    Integer currentStartLowestDifference = 0;
    Integer increasingIndexFromStartValueDifference;
    Integer decreasingIndexFromEndValueDifference;
    while(currentIndexFromStart < currentIndexFromEnd) {
      boolean isCycleDone = false;
      currentDifference = prices[currentIndexFromEnd] - prices[currentIndexFromStart];
      if(highestFromEndIndex != null) {
        if(highestFromEndIndex > currentIndexFromEnd) {
          highestCurrentEndDifference = prices[highestFromEndIndex] - prices[currentIndexFromEnd];
        }
        if(highestFromEndIndex > currentIndexFromStart) {
          highestCurrentStartDifference = prices[highestFromEndIndex] - prices[currentIndexFromStart];
        }
      }
      if(lowestFromStartIndex != null) {
        if(currentIndexFromEnd > lowestFromStartIndex) {
          currentEndLowestDifference = prices[currentIndexFromEnd] - prices[lowestFromStartIndex];
        }
        if(currentIndexFromStart > lowestFromStartIndex) {
          currentStartLowestDifference = prices[currentIndexFromStart] - prices[lowestFromStartIndex];
        }
      }
      List<Integer> differenceList = Arrays.asList(currentDifference, highestCurrentEndDifference, highestCurrentStartDifference, currentEndLowestDifference, currentStartLowestDifference);
      Integer currentMaxDifference = differenceList.stream().max(Integer::compare).get();
      if(currentDifference > maxDifference && currentDifference.equals(currentMaxDifference)) {
        highestFromEndIndex = currentIndexFromEnd;
        lowestFromStartIndex = currentIndexFromStart;
        isCycleDone = true;
      }

      if(highestFromEndIndex != null && !isCycleDone) {
        if(highestCurrentEndDifference > maxDifference && highestCurrentEndDifference.equals(currentMaxDifference)) {
          lowestFromStartIndex = currentIndexFromEnd;
          isCycleDone = true;
        }
      }

      if(highestFromEndIndex != null && !isCycleDone) {
        if(highestCurrentStartDifference > maxDifference && highestCurrentStartDifference.equals(currentMaxDifference)) {
          lowestFromStartIndex = currentIndexFromStart;
          isCycleDone = true;
        }
      }

      if(lowestFromStartIndex != null && !isCycleDone) {
        if(currentEndLowestDifference > maxDifference && currentEndLowestDifference.equals(currentMaxDifference)) {
          highestFromEndIndex = currentIndexFromEnd;
          isCycleDone = true;
        }
      }

      if(lowestFromStartIndex != null && !isCycleDone) {
        if(currentStartLowestDifference > maxDifference && currentStartLowestDifference.equals(currentMaxDifference)) {
          highestFromEndIndex = currentIndexFromStart;
          isCycleDone = true;
        }
      }

      if(highestFromEndIndex != null && lowestFromStartIndex != null) {
        highestFromEndValue = prices[highestFromEndIndex];
        lowestFromStartValue = prices[lowestFromStartIndex];
        maxDifference = currentMaxDifference;
      }

      increasingIndexFromStartValueDifference = prices[currentIndexFromStart] - prices[currentIndexFromStart+1];
      decreasingIndexFromEndValueDifference = prices[currentIndexFromEnd-1] - prices[currentIndexFromEnd];
      if(decreasingIndexFromEndValueDifference>increasingIndexFromStartValueDifference) {
        currentIndexFromEnd = currentIndexFromEnd - 1;
      } else {
        currentIndexFromStart = currentIndexFromStart + 1;
      }
    }
    if(highestFromEndValue != null && lowestFromStartValue != null) {
      return highestFromEndValue - lowestFromStartValue;
    }
    return 0;
  }
}
