
package com.blind75.problems.p05_best_time_to_buy_and_sell_stock;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class BestTimeToBuyAndSellStockTest {

  static Stream<BestTimeToBuyAndSellStock> implementations() {
    return Stream.of(
      new BestTimeToBuyAndSellStockFirstTry()
    );
  }

  @ParameterizedTest
  @MethodSource("implementations")
  void testExample(BestTimeToBuyAndSellStock bestTimeToBuyAndSellStock) {
    int result = bestTimeToBuyAndSellStock.maxProfit(new int[] {10,1,5,6,7,1});
    Assertions.assertEquals(6, result);
  }

  @ParameterizedTest
  @MethodSource("implementations")
  void testExample2(BestTimeToBuyAndSellStock bestTimeToBuyAndSellStock) {
    int result = bestTimeToBuyAndSellStock.maxProfit(new int[] {10,8,7,5,2});
    Assertions.assertEquals(0, result);
  }

  @ParameterizedTest
  @MethodSource("implementations")
  void testExample3(BestTimeToBuyAndSellStock bestTimeToBuyAndSellStock) {
    int result = bestTimeToBuyAndSellStock.maxProfit(new int[] {1,2,11,4,7});
    Assertions.assertEquals(10, result);
  }

  @ParameterizedTest
  @MethodSource("implementations")
  void testExample4(BestTimeToBuyAndSellStock bestTimeToBuyAndSellStock) {
    int result = bestTimeToBuyAndSellStock.maxProfit(new int[] {3,2,6,5,0,3});
    Assertions.assertEquals(4, result);
  }
}