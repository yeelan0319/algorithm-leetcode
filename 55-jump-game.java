public class Solution {
  public boolean canJump(int[] nums) {
  	int maxReachableIndex = 0, currentReachableIndex;
  	for(int i = 0; i <= maxReachableIndex; i++) {
  		currentReachableIndex = nums[i] + i;
  		if(currentReachableIndex >= maxReachableIndex) {
  			maxReachableIndex = currentReachableIndex;
  			if(maxReachableIndex >= nums.length - 1) {
  				return true;
  			}
  		}
  	}
  	return false;
  }
}