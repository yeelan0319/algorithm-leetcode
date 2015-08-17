public class Solution {
	public int maxProduct(int[] nums) {
		int mi = 1;
		int mx = 1;
		int max = Integer.MIN_VALUE;

		for(int i = 0; i < nums.length; i++) {
			if(nums[i] > 0) {
				mi *= nums[i];
				mx *= nums[i];
				max = Math.max(mx, max);
			}
			else if(nums[i] == 0) {
				mi = 1;
				mx = 1;
				max = Math.max(0, max);
			}
			else {
				int temp = mx;
				max = Math.max(mi * nums[i], max);
				mx = Math.max(1, mi * nums[i]);
				mi = temp * nums[i];
			}
		}	
		return max;
	}
}