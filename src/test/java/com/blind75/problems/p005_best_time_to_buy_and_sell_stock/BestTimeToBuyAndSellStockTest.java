package com.blind75.problems.p005_best_time_to_buy_and_sell_stock;

import com.blind75.problems.common.*;
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

  private static final List<InputAndOutput> bestTimeToBuyAndSellStockInputAndOutputList = List.of(
    new SingleInputAndOutputBuilder<>()
      .input(new int[] {10, 1, 5, 6, 7, 1})
      .output(6)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(new int[] {10, 8, 7, 5, 2})
      .output(0)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(new int[] {1, 2, 11, 4, 7})
      .output(10)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(new int[] {3, 2, 6, 5, 0, 3})
      .output(4)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(new int[] {10, 2, 16, 1, 3, 4, 5, 6, 7, 1})
      .output(14)
      .build(),
    new SingleInputAndOutputBuilder<>()
      .input(new int[] {10, 3, 4, 5, 6, 7, 9, -15, 8})
      .output(23)
      .build()
  );

  static Stream<SingleMethodTestConfig<BestTimeToBuyAndSellStock>> testConfigs() {
    Stream.Builder<SingleMethodTestConfig<BestTimeToBuyAndSellStock>> streamBuilder = Stream.builder();
    for (BestTimeToBuyAndSellStock bestTimeToBuyAndSellStock : bestTimeToBuyAndSellStockList) {
      for (InputAndOutput bestTimeToBuyAndSellStockInputAndOutput : bestTimeToBuyAndSellStockInputAndOutputList) {
        streamBuilder.add(new TestConfigBuilder<BestTimeToBuyAndSellStock>()
          .interfaceToTest(bestTimeToBuyAndSellStock)
          .inputAndOutput(bestTimeToBuyAndSellStockInputAndOutput)
          .build());
      }
    }
    return streamBuilder.build();
  }

  @ParameterizedTest
  @MethodSource("testConfigs")
  void testExample(SingleMethodTestConfig<BestTimeToBuyAndSellStock> singleMethodTestConfig) {
    SingleInputAndOutput<int[], Integer> inputAndOutput = (SingleInputAndOutput) singleMethodTestConfig.inputAndOutput();
    int result = singleMethodTestConfig.implementationToTest().maxProfit(inputAndOutput.input());
    Assertions.assertEquals(inputAndOutput.output(), result);
  }
}
