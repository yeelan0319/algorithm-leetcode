public class Solution {
	public List<List<Integer>> fourSum(int[] nums, int target) {
  	List<List<Integer>> res = new ArrayList<List<Integer>>();

  	if(nums.length < 4) {
  		return res;
  	}
  	Arrays.sort(nums);
  	for(int i = 0; i < nums.length - 3; i++) {
  		if(i > 0 && nums[i] == nums[i - 1]) {
  			continue;
  		}
  		for(int j = nums.length - 1; j > i + 2; j--) {
  			if(j < nums.length - 1 && nums[j] == nums[j + 1]) {
  				continue;
  			}
  			int lo = i + 1;
  			int hi = j - 1;
  			while (lo < hi) {
  				if(lo > i + 1 && nums[lo] == nums[lo - 1]) {
  					lo++;
  					continue;
  				}
  				if(hi < j - 1 && nums[hi] == nums[hi + 1]) {
  					hi--;
  					continue;
  				}
  				int sum = nums[i] + nums[j] + nums[lo] + nums[hi];
  				if(sum == target) {
  					res.add(Arrays.asList(nums[i], nums[lo], nums[hi], nums[j]));
  					lo++;
  					hi--;
  				}
  				else if(sum < target) {
  					lo++;
  				}
  				else {
  					hi--;
  				}
  			}
  		}
  	}
  	return res;
	}
}