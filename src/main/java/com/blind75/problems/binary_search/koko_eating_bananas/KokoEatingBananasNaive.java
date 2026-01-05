package com.blind75.problems.binary_search.koko_eating_bananas;

import java.util.Map;
import java.util.TreeMap;

public class KokoEatingBananasNaive implements KokoEatingBananas {
  @Override
  public int minEatingSpeed(int[] piles, int h) {
    Map<Integer, Integer> countByPileNumber = new TreeMap<>();
    countByPileNumber.put(piles[0], 1);
    int maxValue = piles[0];
    long sumValues = piles[0];
    for(int i=1; i<piles.length; i++) {
      sumValues += piles[i];
      if(piles[i]>maxValue) {
        maxValue = piles[i];
      }
      if(countByPileNumber.containsKey(piles[i])) {
        countByPileNumber.put(piles[i], countByPileNumber.get(piles[i])+1);
      } else {
        countByPileNumber.put(piles[i], 1);
      }
    }
    if(h >= sumValues) {
      return 1;
    }
    if(h == maxValue) {
      return maxValue;
    }
    for(int i=2; i<=maxValue; i++) {
      long currentH = 0;
      for (Integer key : countByPileNumber.keySet()) {
        currentH += (long) countByPileNumber.get(key) * Math.ceilDiv(key, i);
      }
      if(currentH <= h) {
        return i;
      }
    }

    return 0;
  }
}
