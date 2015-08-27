public class Solution {
	public int lengthOfLongestSubstring(String s) {
		if(s == null || s.length() == 0) {
			return 0;
		}
		int maxLength = 0;
		int start = 0;
		int end = 0;
		HashSet<Character> hm = new HashSet<Character>();

		while(end < s.length()) {
			if(!hm.contains(s.charAt(end))) {
				hm.add(s.charAt(end));
			}
			else {
				maxLength = Math.max(maxLength, end - start);
				while(s.charAt(start) != s.charAt(end)) {
					hm.remove(s.charAt(start));
					start++;
				}
			}
			end++;
		}
		maxLength = Math.max(maxLength, s.length() - start);
		return maxLength;
	}
}