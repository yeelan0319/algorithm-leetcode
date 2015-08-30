public class Solution {
	public String minWindow(String s, String t) {
		if(s == null || s.length() == 0 || t == null || t.length() == 0 || s.length() < t.length()) {
			return "";
		}
		HashMap<Character, Integer> need = new HashMap<Character, Integer>();
		for(int i = 0; i < t.length(); i++) {
			need.put(t.charAt(i), need.containsKey(t.charAt(i))? need.get(t.charAt(i)) + 1 : 1);
		}
		int start = 0;
		int end = 0;
		int minStart = 0;
		int minEnd = Integer.MAX_VALUE;
		int count = t.length();
		while(end < s.length()) {
			if(need.containsKey(s.charAt(end))) {
				int c = need.get(s.charAt(end));
				need.put(s.charAt(end), c - 1);
				if(c > 0) {
					count--;
				}
				if(count == 0) {
					//注意start在靠近end的过程中会遇到没有包含在need中的字母，必须要先验证存在再get
					while(!need.containsKey(s.charAt(start)) || need.get(s.charAt(start)) < 0) {
						if(need.containsKey(s.charAt(start)) && need.get(s.charAt(start)) < 0) {
							need.put(s.charAt(start), need.get(s.charAt(start)) + 1);
						}
						start++;
					}
					if(minEnd - minStart > end - start) {
						minEnd = end;
						minStart = start;
					}
				}
			}
			end++;
		}
		return minEnd == Integer.MAX_VALUE? "" : s.substring(minStart, minEnd + 1);
	}
}