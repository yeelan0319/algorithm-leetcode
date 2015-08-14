public class Solution {
  public int maxProfit(int[] prices) {
    if(prices.length < 2) return 0;

    int[] transaction1 = new int[prices.length];
    int[] transaction2 = new int[prices.length];
    int minPrice = prices[0];
    int maxPrice = prices[prices.length - 1];
    int maxProfit = 0;

    for(int i = 1; i < prices.length; i++) {
      minPrice = Math.min(minPrice, prices[i]);
      transaction1[i] = Math.max(transaction1[i - 1], prices[i] - minPrice);
    }
    for(int j = prices.length - 2; j >= 0; j--) {
      maxPrice = Math.max(maxPrice, prices[j]);
      transaction2[j] = Math.max(transaction2[j + 1], maxPrice - prices[j]);
    }
    for(int k = 0; k < transaction1.length; k++) {
      maxProfit = Math.max(transaction1[k] + transaction2[k], maxProfit);
    }
    return maxProfit;
  }
}