public class Solution {
	public int searchInsert(int[] nums, int target) {
    if(nums.length == 0) {
    	return 0;
    }
    int start = 0;
    int end = nums.length - 1;
    return searchInsertHelper(nums, start, end, target);
	}

	public int searchInsertHelper(int[] nums, int start, int end, int target) {
		if(end <= start) {
			if(nums[start] == target) {
				return start;
			}
			else if(nums[start] < target) {
				return start + 1;
			}
			else {
				return start;
			}
		}
		int center = (start + end) / 2;
		if(nums[center] == target) {
			return center;
		}
		else if (nums[center] < target) {
			return searchInsertHelper(nums, center + 1, end, target);
		}
		else {
			return searchInsertHelper(nums, start, center - 1, target);
		}
	}
}

//run time 328ms