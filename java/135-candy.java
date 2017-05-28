public class Solution {
  public int candy(int[] ratings) {
    int[] candys = new int[ratings.length];
    int total = 0;
    Arrays.fill(candys, 1);

    for(int i = 1; i < ratings.length; i++) {
    	if(ratings[i] > ratings[i - 1]) {
    		candys[i] = candys[i - 1] + 1;
    	}
    }
    for(int j = ratings.length - 2; j >= 0; j --) {
    	if(ratings[j] > ratings[j + 1] && candys[j] <= candys[j + 1]) {
    		candys[j] = candys[j + 1] + 1;
    	}
    }
    for(int k = 0; k < candys.length; k++) {
    	total += candys[k];
    }
    return total;
  }
}