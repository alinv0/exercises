package dynamicprogramming;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee

public class BestTimeToBuyStock {
  static class Solution {
    public int maxProfit(int[] prices, int fee) {
      int m = prices.length;
      int[] buys = new int[m];
      int[] sells = new int[m];
      buys[0] = -prices[0] - fee;
      sells[0] = 0;
      for(int i = 1; i < m; i++) {
        buys[i] = Math.max(buys[i-1], sells[i-1] - prices[i] - fee);
        sells[i] = Math.max(sells[i-1], buys[i-1] + prices[i]);
      }
      return sells[m-1];
    }
  }

  public static void main(String[] args) {
    System.out.println(new Solution().maxProfit(new int[] {1, 3, 2, 8, 4, 9}, 2));
  }
}
