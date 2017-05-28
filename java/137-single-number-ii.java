public class Solution {
	public int singleNumber(int[] nums) {
		int res = 0;
		int mask, bit;
		for(int i = 0; i < 32; i++) {
			bit = 0;
			mask = (1 << i);

			for(int j = 0; j < nums.length; j++) {
				if((nums[j] & mask) != 0) {
					bit++;
				}
			}
			if(bit % 3 != 0) {
				res |= mask;
			}
		}
		return res;
	}
}