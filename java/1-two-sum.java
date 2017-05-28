public class Solution {
	public int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		int temp1, temp2;
		int[] res = new int[2];
		for(int i = 0; i < nums.length; i++) {
			if(hm.containsKey(nums[i])) {
				temp1 = hm.get(nums[i]) + 1;
				temp2 = i + 1;
				res[0] = Math.min(temp1, temp2);
				res[1] = Math.max(temp1, temp2);
				break;
			}
			else {
				hm.put(target - nums[i], i);
			}
		}
		return res;
	}
}