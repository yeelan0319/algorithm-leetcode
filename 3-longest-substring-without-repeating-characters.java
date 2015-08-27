public class Solution {
	public int lengthOfLongestSubstring(String s) {
		if(s == null || s.length() == 0) {
			return 0;
		}
		int maxLength = 0;
		int start = 0;
		int end = 0;
		while(end < s.length()) {
			HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
			for(end = start; end < s.length(); end++) {
				if(!hm.containsKey(s.charAt(end))) {
					hm.put(s.charAt(end), end);
				}
				else {
					if(maxLength < end - start) {
						maxLength = end - start;
					}
					start = hm.get(s.charAt(end)) + 1;
					break;
				}
			}
		}
		return maxLength;
	}
}