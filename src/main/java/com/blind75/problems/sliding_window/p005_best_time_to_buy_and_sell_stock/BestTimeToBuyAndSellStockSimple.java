package com.blind75.problems.sliding_window.p005_best_time_to_buy_and_sell_stock;

public class BestTimeToBuyAndSellStockSimple implements BestTimeToBuyAndSellStock {
  @Override
  public int maxProfit(int[] prices) {
    int left = 0;
    int right = 1;
    int maxProfit = 0;
    while (right < prices.length) {
      if (prices[left] < prices[right]) {
        int profit = prices[right] - prices[left];
        if (profit > maxProfit) {
          maxProfit = profit;
        }
      } else {
        left = right;
      }
      right++;
    }
    return maxProfit;
  }
}
