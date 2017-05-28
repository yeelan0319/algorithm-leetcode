public class Solution {
  public boolean canJump(int[] nums) {
  	int maxReachableIndex = 0, i = 0, temp = 0;
  	while(maxReachableIndex < nums.length - 1) {
  		temp = maxReachableIndex;
  		for(; i <= maxReachableIndex; i++) {
  			if(nums[i] + i > temp) {
  				temp = nums[i] + i;
  			}
  		}
  		if(temp <= maxReachableIndex) {
  			return false;
  		}
  		else {
  			maxReachableIndex = temp;
  		}
  	}
    return true;
  }
}