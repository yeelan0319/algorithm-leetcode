public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
    	int startingIndex = 0;
      int residual = 0;
      int temp = 0;
      int total = 0;

      for(int i = 0; i < gas.length; i++) {
      	residual = gas[i] - cost[i];
      	temp += residual;
      	total += residual;
      	if(temp < 0) {
      		startingIndex = i + 1;
      		temp = 0;
      	}
      } 
      return total >= 0? startingIndex : -1;
    }
}