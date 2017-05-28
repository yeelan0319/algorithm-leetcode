public class Solution {
	public int searchInsert(int[] nums, int target) {
    if(nums.length == 0) {
    	return 0;
    }
    int start = 0;
    int end = nums.length - 1;
    
    int center = 0;
    while(start <= end) {
    	center = (start + end) / 2;
    	if(nums[center] == target) {
    		return center;
    	}
    	else if(nums[center] < target) {
    		start = center + 1;
    	}
    	else {
    		end = center - 1;
    	}
    }
    return nums[center] > target? center : center + 1;
	}
}

// run time 492ms;