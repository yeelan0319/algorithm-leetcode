public class Solution {
  public int maxProfit(int[] prices) {
    boolean hasStock = false;
    int buyingPrice = 0;
  	int totalProfit = 0;
  	for(int i = 0; i < prices.length - 1; i++) {
      if(prices[i] < prices[i + 1] && hasStock == false) {
        hasStock = true;
        buyingPrice = prices[i];
      }
      else if(prices[i] > prices[i + 1] && hasStock == true) {
        hasStock = false;
        totalProfit += prices[i] - buyingPrice;
      }
  	}
    if(hasStock) {
      totalProfit += prices[prices.length - 1] - buyingPrice;
    }
  	return totalProfit;    
  }
}