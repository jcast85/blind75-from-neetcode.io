package com.blind75.problems.binary_search.koko_eating_bananas;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class KokoEatingBananasBinarySearchTooManyResources implements KokoEatingBananas {
  private HashMap<Integer, Integer> cache = new HashMap<>();

  @Override
  public int minEatingSpeed(int[] piles, int h) {
    cache = new HashMap<>();
    Arrays.sort(piles);
    PileInfo[] pileInfoArray = new PileInfo[piles.length];
    pileInfoArray[piles.length-1] = new PileInfo();
    pileInfoArray[piles.length-1].pileAmount = piles[piles.length-1];
    pileInfoArray[piles.length-1].pileAmountMaxIndex = piles.length-1;
    int previousPileAmountMaxIndex = piles.length-1;
    for(int i=piles.length-2; i>=0; i--) {
      pileInfoArray[i] = new PileInfo();
      pileInfoArray[i].pileAmount = piles[i];
      if(piles[i] == piles[previousPileAmountMaxIndex]) {
        pileInfoArray[i].pileAmountMaxIndex = previousPileAmountMaxIndex;
      } else {
        pileInfoArray[i].pileAmountMaxIndex = i;
        previousPileAmountMaxIndex = i;
      }
    }
    // somma di tutti i valori
    int sum = Arrays.stream(piles).sum();
    // costruisci mappa massimo indice per valore distinto
    Map<Integer, Integer> maxIndexByValue = new HashMap<>();
    for(int i=0; i<piles.length; i++) {
      maxIndexByValue.put(piles[i], i);
    }

    //  riempi chiavi anche quelle non presenti con il massimo indice della prima chiave presente precedente
    int previousIndex = -1;
    for(int i=1; i<=piles[piles.length-1]; i++) {
      if(maxIndexByValue.containsKey(i)) {
        previousIndex = maxIndexByValue.get(i);
      } else {
        maxIndexByValue.put(i, previousIndex);
      }
    }

    return minEatingSpeed(piles, h, maxIndexByValue, 1, maxIndexByValue.size(), sum)[0];
  }

  private int[] minEatingSpeed(int[] piles, int h, Map<Integer, Integer> maxIndexByValue, int beginIndex, int endIndex,
    int previousH) {
    if (beginIndex > endIndex) {
      cache.put(h, -1);
      return new int[]{cache.get(previousH), previousH};
    }
    // ricerca binaria sulle chiavi anche quelle non presenti partendo dal valore centrale
    int centralNodeIndex = beginIndex + (endIndex - beginIndex + 1) / 2;

    // dal valore indietro il numero è il massimo indice stesso, dal valore successivo fino alla fine fai divisioni e conta
    int value = piles[maxIndexByValue.get(centralNodeIndex)];
    int currentH = (maxIndexByValue.get(centralNodeIndex) + 1);
    // non appena il conteggio supera h, interrompi e passa al valore centrale dell'intervallo superiore
    if(currentH > h) {
      return minEatingSpeed(piles, h, maxIndexByValue, centralNodeIndex+1, endIndex, previousH);
    }
    for(int i = maxIndexByValue.get(centralNodeIndex) + 1; i < piles.length; i++) {
      currentH += Math.ceilDiv(piles[i], value);
      // non appena il conteggio supera h, interrompi e passa al valore centrale dell'intervallo superiore
      if(currentH > h) {
        return minEatingSpeed(piles, h, maxIndexByValue, centralNodeIndex+1, endIndex, previousH);
      }
    }

    // se il conteggio è uguale ad h, ricalcola con il valore immediatamente inferiore, se supera h, ritorna il valore centrale, se no il valore immediatamente inferiore
    if(currentH == h) {
      int[] previousIntervalResult = minEatingSpeed(piles, h, maxIndexByValue, beginIndex, centralNodeIndex-1, currentH);
      if(previousIntervalResult[1] == currentH && previousIntervalResult[0] != -1) {
        return previousIntervalResult;
      } else {
        cache.put(h, centralNodeIndex);
        return new int[]{centralNodeIndex, currentH};
      }
    }
    cache.put(currentH, centralNodeIndex);
    return minEatingSpeed(piles, h, maxIndexByValue, beginIndex, centralNodeIndex-1, currentH);
  }

  private static class PileInfo {
    int pileAmount;
    int pileAmountMaxIndex;

    @Override
    public String toString() {
      return "PileInfo [pileAmount=" + pileAmount + ", pileAmountMaxIndex=" + pileAmountMaxIndex + "]";
    }
  }
}
