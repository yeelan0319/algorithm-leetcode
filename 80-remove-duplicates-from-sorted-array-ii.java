public class Solution {
	public int removeDuplicates(int[] nums) {
		if(nums.length < 3) return nums.length;

		int pivot = 0, runner = 0, length = nums.length;
		boolean flag = false;
		while(++runner < length) {
			if(nums[runner] != nums[pivot] || !flag){
				if(nums[runner] == nums[pivot] && !flag) {
					flag = true;
				}
				else{
					flag = false;
				}	
				nums[++pivot] = nums[runner];
			}
		}
		return pivot + 1;
	}
}