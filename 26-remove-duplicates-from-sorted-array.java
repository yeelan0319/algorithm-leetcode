public class Solution {
    public int removeDuplicates(int[] nums){
        if(nums.length < 2) return nums.length;

        int pivot = 1, runner = 1;
        while(runner < nums.length) {
            if(nums[runner] != nums[pivot - 1]) {
                nums[pivot++] = nums[runner];
            }
            runner++;
        }
        return pivot;
    }
}
