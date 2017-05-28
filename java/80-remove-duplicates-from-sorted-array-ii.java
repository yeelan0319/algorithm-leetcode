public class Solution {
	public int removeDuplicates(int[] nums) {
		if(nums.length < 3) return nums.length;

		int pivot = 2, runner = 2, length = nums.length;
		while(runner < length){
			if(nums[runner] != nums[pivot - 1] || nums[runner] != nums[pivot - 2]){
				nums[pivot++] = nums[runner];
			}
			runner++;
		}
		return pivot;
	}
}