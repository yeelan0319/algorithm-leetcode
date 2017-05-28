public class Solution {
	public boolean search(int[] nums, int target) {
		if(nums.length == 0) return false;

		int start = 0;
		int end = nums.length - 1;
		while(start <= end) {
			int center = (start + end) / 2;
			if(nums[center] == target) {
				return true;
			}
			else if(nums[center] == nums[end]){
				end--;
			}
			else if(nums[center] < target) {
				if(nums[end] < target && nums[end] > nums[center]) {
					end = center - 1;
				}
				else {
					start = center + 1;
				}
			}
			else {
				if(nums[start] > target && nums[end] < nums[center]) {
					start = center + 1;
				}
				else {
					end = center - 1;
				}
			}
		}
		return false;
	}
}