package com.blind75.problems.p05_best_time_to_buy_and_sell_stock;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BestTimeToBuyAndSellStockTest {
  @Test
  void testExample() {
    BestTimeToBuyAndSellStock bestTimeToBuyAndSellStock = new BestTimeToBuyAndSellStockFirstTry();
    int result = bestTimeToBuyAndSellStock.maxProfit(new int[] {10,1,5,6,7,1});
    Assertions.assertEquals(6, result);
  }

  @Test
  void testExample2() {
    BestTimeToBuyAndSellStock bestTimeToBuyAndSellStock = new BestTimeToBuyAndSellStockFirstTry();
    int result = bestTimeToBuyAndSellStock.maxProfit(new int[] {10,8,7,5,2});
    Assertions.assertEquals(0, result);
  }

  @Test
  void testExample3() {
    BestTimeToBuyAndSellStock bestTimeToBuyAndSellStock = new BestTimeToBuyAndSellStockFirstTry();
    int result = bestTimeToBuyAndSellStock.maxProfit(new int[] {1,2,11,4,7});
    Assertions.assertEquals(10, result);
  }

  @Test
  void testExample4() {
    BestTimeToBuyAndSellStock bestTimeToBuyAndSellStock = new BestTimeToBuyAndSellStockFirstTry();
    int result = bestTimeToBuyAndSellStock.maxProfit(new int[] {3,2,6,5,0,3});
    Assertions.assertEquals(4, result);
  }
}
