public class Solution {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();

		if(nums.length < 3) return res;
		Arrays.sort(nums);
		for(int i = 0; i < nums.length - 2; i++) {
			if(i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
				int j = i + 1;
				int k = nums.length - 1;
				while(j < k) {
					if(j > i + 1 && nums[j] == nums[j - 1]) {
						j++;
						continue;
					}
					if(k < nums.length - 1 && nums[k] == nums[k + 1]) {
						k--;
						continue;
					}
					int sum = nums[i] + nums[j] + nums[k];
					if(sum == 0) {
						res.add(Arrays.asList(nums[i], nums[j], nums[k]));
						j++;
					}
					else if(sum < 0) {
						j++;
					}
					else {
						k--;
					}
				}
			}
		}
		return res;
	}
}