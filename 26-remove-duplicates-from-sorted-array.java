public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        
        int pivot = 0,
            runner = 1;
        while(runner < nums.length) {
            if(nums[runner] != nums[pivot]) {
                pivot++;
                nums[pivot] = nums[runner];
            }
            runner++;
        }

        return pivot + 1;
    }
}