public class Solution {
	public int removeElement(int[] nums, int val){
		int pivot = 0, runner = 0, length = nums.length;
		while(runner < length) {
			if(nums[runner] != val) {
				nums[pivot++] = nums[runner];
			}
			runner++;
		}
		return pivot;
	}
}