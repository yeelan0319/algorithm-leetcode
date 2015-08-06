public class Solution {
  public boolean canJump(int[] nums) {
  	if(nums.length == 0) return false;

  	int maxReachableIndex = 0, currentReachableIndex;
  	for(int i = 0; i <= maxReachableIndex && i < nums.length; i++) {
  		currentReachableIndex = nums[i] + i;
  		if(currentReachableIndex > maxReachableIndex) {
  			maxReachableIndex = currentReachableIndex;
  		}
  	}
  	if(maxReachableIndex < nums.length - 1) {
  		return false;
  	}
  	else{
  		return true;
  	}
  }
}