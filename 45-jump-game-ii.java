public class Solution {
  public int jump(int[] nums) {
  	int maxReachableIndex = 0, minStep = 0, i = 0, temp = 0;
  	while(maxReachableIndex < nums.length - 1) {
  		temp = maxReachableIndex;
  		for(; i <= maxReachableIndex; i++) {
  			if(nums[i] + i > temp) {
  				temp = nums[i] + i;
  			}
  		}
  		maxReachableIndex = temp;
  		minStep++;
  	}
    return minStep;
  }
}