public class Solution {
	public int removeElement(int[] nums, int val){
		if(nums.length == 0) return 0;

		int pivot = 0, runner = nums.length - 1;
		while(true) {
			while(pivot < runner && nums[runner] == val){
				runner--;
			}
			while(pivot < runner && nums[pivot] != val){
				pivot++;
			}
			if(pivot < runner) {
				nums[pivot] = nums[runner];
				runner--;
			}
			else{
				break;
			}
		}
		if(nums[pivot] == val) {
			return pivot;
		}
		else {
			return pivot + 1;
		}
	}
}