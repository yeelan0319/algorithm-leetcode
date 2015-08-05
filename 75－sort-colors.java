public class Solution {
  public void sortColors(int[] nums) {
  	if(nums.length == 0) return;

  	int pivot = 0, runner = pivot, temp;
  	for(int i = 0; i < 2; i++){
  		while(runner < nums.length) {
	  		if(nums[runner] == i) {
	  			temp = nums[pivot];
	  			nums[pivot] = nums[runner];
	  			nums[runner] = temp;
	  			pivot++;
	  		}
	  		runner++;
	  	}
	  	runner = pivot;
  	}
  }
}