package com.blind75.problems.p005_best_time_to_buy_and_sell_stock;

import lombok.Builder;

@Builder
public record BestTimeToBuyAndSellStockInputAndOutput(int[] prices, int expectedProfit) {
}
