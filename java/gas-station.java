public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
    	int startingIndex = 0;
      int temp = 0;
      int total = 0;

      for(int i = 0; i < gas.length; i++) {
      	temp += gas[i] - cost[i];
      	if(temp < 0) {
      		startingIndex = i + 1;
      		total += temp;
      		temp = 0;
      	}
      }
      total += temp; 
      return total >= 0? startingIndex : -1;
    }
}