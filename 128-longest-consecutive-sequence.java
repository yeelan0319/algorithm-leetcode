public class Solution {
  public int longestConsecutive(int[] nums) {
    if(nums.length == 0) return 0;

    HashSet<Integer> hs = new HashSet<Integer>();
    int maxLength = 0, tempLength = 0, current, temp;
    for(int i = 0; i < nums.length; i++) {
    	hs.add(nums[i]);
    }
    for(int j = 0; j < nums.length; j++) {
    	current = nums[j];
    	if(hs.contains(current)){
    		hs.remove(current);
    		temp = current;
    		tempLength = 1;
      	while(hs.contains(++temp)) {
      		tempLength++;
      		hs.remove(temp);
      	}
      	temp = current;
      	while(hs.contains(--temp)) {
      		tempLength++;
      		hs.remove(temp);
      	}
      	if(tempLength > maxLength) {
      		maxLength = tempLength;
      	}
    	}
    }
    return maxLength;
  }
}