public class Solution {
	public int divide(int dividend, int divisor) {
		int sign = 1;
		if(dividend < 0) sign = -sign;
		if(divisor < 0) sign = -sign;

		if(divisor == 0) {
			return sign > 0? Integer.MAX_VALUE : Integer.MIN_VALUE;
		}
		long res = 0;
		long pdividend = Math.abs((long)dividend);
		long pdivisor = Math.abs((long)divisor);
		while(pdividend >= pdivisor) {
			long count = 1;
			long temp = pdivisor;
			while(pdividend - (temp<<1) >= 0) {
				count = count<<1;
				temp = temp<<1;
			}
			res += count;
			pdividend -= temp;
			if(res >= Integer.MAX_VALUE){
				return sign > 0? Integer.MAX_VALUE : Integer.MIN_VALUE;
			}
		}
		return (int)res * sign;
	}
}

//以下是所有挂掉的test case
// test(-1010369383, -2147483648, 0);  //取Math.abs(int)溢出
// test(-2147483648, 1, Integer.MIN_VALUE);  // 同上
// test(-2147483648, 2, -1073741824); //同上
// test(-2147483648, -1, 2147483647);  //答案溢出

