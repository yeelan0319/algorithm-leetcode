public class Solution {
	public int firstMissingPositive(int[] nums) {
		int temp;
		int min = nums.length + 1;
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] > 0 && nums[i] < nums.length && nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {
				temp = nums[nums[i] - 1];
				nums[nums[i] - 1] = nums[i];
				nums[i] = temp;
				i--;
			}
		}

		for(int j = 0; j < nums.length; j++) {
			if(nums[j] != j + 1) {
				min = j + 1;
				break;
			}
		}

		return min;
	}
}