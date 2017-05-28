public class Solution {
	public String longestPalindrome(String s) {
		if(s == null) return null;
		if(s.length() <= 1) return s;

		String longest = s.substring(0, 1);
		for(int i = 0; i < s.length() - 1; i++) {
			String s1 = findPalindrome(s, i ,i);
			if(s1.length() > longest.length()) {
				longest = s1;
			}
			String s2 = findPalindrome(s, i, i + 1);
			if(s2.length() > longest.length()) {
				longest = s2;
			}
		}
		return longest;
	}
	public String findPalindrome(String s, int l, int r) {
		while(l >= 0 && r <= s.length() - 1 && s.charAt(l) == s.charAt(r)){
			l--;
			r++;
		}
		return s.substring(l + 1, r);
	}
}