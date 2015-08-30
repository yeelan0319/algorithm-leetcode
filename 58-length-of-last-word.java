import java.util.*;

/**
 * Created by yiranmao on 8/19/15.
 */
public class Driver {
	public static void main(String[] args) {
		test("bbb", 3);
		test("abca bc((**bb", 8);
		test("aa    ", 2);
		test("   ", 0);
		test("aa", 2);
	}

	public static void test(String s, int expectValue) {
		int res = lengthOfLastWord(s);
		if (res == expectValue) {
			System.out.println(s + ": Pass");
		} else {
			System.out.println(s + ": Fail");
			System.out.println("Expect " + expectValue + ", Return " + res);
		}
	}

	public static int lengthOfLastWord(String s) {
		if(s == null) {
			return 0;
		}
		String str = s.trim();
		int lastwordLength = 0;
		while(lastwordLength < str.length() && str.charAt(str.length() - lastwordLength - 1) != ' ') {
			lastwordLength++;
		}
		return lastwordLength;
	}
}
