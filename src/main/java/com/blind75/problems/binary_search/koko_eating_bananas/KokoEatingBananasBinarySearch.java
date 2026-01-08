package com.blind75.problems.binary_search.koko_eating_bananas;

import java.util.Arrays;

public class KokoEatingBananasBinarySearch implements KokoEatingBananas {
  @Override
  public int minEatingSpeed(int[] piles, int h) {
    Arrays.sort(piles);
    int beginValue = 1;
    int endValue = piles[piles.length-1];
    int previousCentralNodeIndex = 0;
    while (beginValue <= endValue) {
      int currentH = 0;
      int centralNodeIndex = beginValue + (endValue - beginValue) / 2;
      for(int pile: piles) {
        currentH += Math.ceilDiv(pile, centralNodeIndex);
        if(currentH > h) {
          beginValue = centralNodeIndex + 1;
          break;
        }
      }
      if(currentH <= h) {
        previousCentralNodeIndex = centralNodeIndex;
        endValue = centralNodeIndex - 1;
      }
    }
    return previousCentralNodeIndex;
  }
}
