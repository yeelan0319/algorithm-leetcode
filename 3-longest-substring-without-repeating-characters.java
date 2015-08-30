public class Solution {
	public int lengthOfLongestSubstring(String s) {
		if(s == null || s.length() == 0) {
			return 0;
		}
		int maxLength = 0;
		int start = 0;
		int end = 0;
		HashSet<Character> hm = new HashSet<Character>();

		while (end < s.length()) {
			if (!hm.contains(s.charAt(end))) {
				hm.add(s.charAt(end));
				end++;
			} else {
				maxLength = Math.max(maxLength, end - start);
				while (s.charAt(start) != s.charAt(end)) {
					hm.remove(s.charAt(start));
					start++;
				}
				start++;
				end++;
			}
		}
		maxLength = Math.max(maxLength, s.length() - start);
		return maxLength;
	}
}

/*
import java.util.*;

/**
 * Created by yiranmao on 8/19/15.
 */
// public class Driver {
//     public static void main(String[] args) {
//         test("bbbbb", 1);
//         test("abcabcbb", 3);
//         test("aa", 1);

//     }

//     public static void test(String s, int expectValue) {
//         int res = lengthOfLongestSubstring(s);
//         if (res == expectValue) {
//             System.out.println(s + ": Pass");
//         } else {
//             System.out.println(s + ": Fail");
//             System.out.println("Expect " + expectValue + ", Return " + res);
//         }
//     }

//     public static int lengthOfLongestSubstring(String s) {
//         if (s == null || s.length() == 0) {
//             return 0;
//         }
//         int maxLength = 0;
//         int start = 0;
//         int end = 0;
//         HashSet<Character> hm = new HashSet<Character>();

//         while (end < s.length()) {
//             if (!hm.contains(s.charAt(end))) {
//                 hm.add(s.charAt(end));
//                 end++;
//             } else {
//                 maxLength = Math.max(maxLength, end - start);
//                 while (s.charAt(start) != s.charAt(end)) {
//                     hm.remove(s.charAt(start));
//                     start++;
//                 }
//                 start++;
//                 end++;
//             }
//         }
//         maxLength = Math.max(maxLength, s.length() - start);
//         return maxLength;
//     }
// }
