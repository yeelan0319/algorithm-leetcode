public class Solution {
  public int maxProfit(int[] prices) {
    if(prices.length == 0) return 0;
    
  	int maxProfit = 0;
  	int minPrice = prices[0];
  	for(int i = 1; i < prices.length; i++) {
  	  minPrice = Math.min(prices[i], minPrice);
  	  maxProfit = Math.max(prices[i] - minPrice, maxProfit);
  	}
  	return maxProfit;    
  }
}