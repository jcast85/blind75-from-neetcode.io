
package com.blind75.problems.p05_best_time_to_buy_and_sell_stock;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class BestTimeToBuyAndSellStockTest {

  private static final List<BestTimeToBuyAndSellStock> bestTimeToBuyAndSellStockList = List.of(
    new BestTimeToBuyAndSellStockFirstTry(),
    new BestTimeToBuyAndSellStockSimple()
  );

  private static final List<BestTimeToBuyAndSellStockInputAndOutput> bestTimeToBuyAndSellStockInputAndOutputList = List.of(
    BestTimeToBuyAndSellStockInputAndOutput.builder()
      .prices(new int[] {10,1,5,6,7,1})
      .expectedProfit(6)
      .build(),
    BestTimeToBuyAndSellStockInputAndOutput.builder()
      .prices(new int[] {10,8,7,5,2})
      .expectedProfit(0)
      .build(),
    BestTimeToBuyAndSellStockInputAndOutput.builder()
      .prices(new int[] {1,2,11,4,7})
      .expectedProfit(10)
      .build(),
    BestTimeToBuyAndSellStockInputAndOutput.builder()
      .prices(new int[] {3,2,6,5,0,3})
      .expectedProfit(4)
      .build(),
    BestTimeToBuyAndSellStockInputAndOutput.builder()
      .prices(new int[] {10,2,16,1,3,4,5,6,7,1})
      .expectedProfit(14)
      .build(),
    BestTimeToBuyAndSellStockInputAndOutput.builder()
      .prices(new int[] {10,3,4,5,6,7,9,-15,8})
      .expectedProfit(23)
      .build()
  );

  static Stream<BestTimeToBuyAndSellStockTestConfig> testConfigs() {
    Stream.Builder<BestTimeToBuyAndSellStockTestConfig> streamBuilder = Stream.builder();
    for (BestTimeToBuyAndSellStock bestTimeToBuyAndSellStock : bestTimeToBuyAndSellStockList) {
      for (BestTimeToBuyAndSellStockInputAndOutput bestTimeToBuyAndSellStockInputAndOutput : bestTimeToBuyAndSellStockInputAndOutputList) {
        streamBuilder.add(BestTimeToBuyAndSellStockTestConfig.builder()
          .bestTimeToBuyAndSellStocks(bestTimeToBuyAndSellStock)
          .inputAndOutput(bestTimeToBuyAndSellStockInputAndOutput).build());
      }
    }
    return streamBuilder.build();
  }

  @ParameterizedTest
  @MethodSource("testConfigs")
  void testExample(BestTimeToBuyAndSellStockTestConfig testConfig) {
    int result = testConfig.bestTimeToBuyAndSellStocks().maxProfit(testConfig.inputAndOutput().prices());
    Assertions.assertEquals(testConfig.inputAndOutput().expectedProfit(), result);
  }
}