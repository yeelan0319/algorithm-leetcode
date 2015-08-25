public class Solution {
	public int[] searchRange(int[] nums, int target) {
		if(nums.length == 0) {
			return new int[]{-1, -1};
		}
		int start = 0;
		int end = nums.length - 1;
		int direction = 0;
		return searchRangeHelper(nums, start, end, target, direction);
	}

	public int[] searchRangeHelper(int[] nums, int start, int end, int target, int direction) {
		if(end < start) {
			return new int[]{-1, -1};
		}
		int center = (start + end) / 2;
		int left, right;
		if(nums[center] == target) {
			switch(direction) {
				case 0:
				left = searchRangeHelper(nums, start, center - 1, target, -1)[0];
				right = searchRangeHelper(nums, center + 1, end, target, 1)[1];
				left = left == -1? center : left;
				right = right == -1? center : right;
				return new int[]{left, right};
				case -1:
				left = searchRangeHelper(nums, start, center - 1, target, direction)[0];
				left = left == -1? center : left;
				return new int[]{left, center};
				case 1:
				right = searchRangeHelper(nums, center + 1, end, target, direction)[1];
				right = right == -1? center : right;
				return new int[]{center, right};
			}
		}
		else if(nums[center] < target) {
			return searchRangeHelper(nums, center + 1, end, target, direction);
		}
		return searchRangeHelper(nums, start, center - 1, target, direction);
	}
}