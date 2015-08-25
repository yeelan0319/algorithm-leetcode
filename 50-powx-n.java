public class Solution {
	public double myPow(double x, int n) {
		if(n < 0) {
			if(x != 0) {
				x = 1 / x;
			}
			n = Math.abs(n);
		}
		double res = 1;
		while(n > 0) {
			int count = 0;
			int temp = 1;
			while(n - (temp<<1) >= 0) {
				count++;
				temp = temp<<1;
			}
			double y = x;
			while(count > 0) {
				y = y * y;
				count--;
			}
			res *= y;
			n -= temp;
		}
		return res;
	}
}