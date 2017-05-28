public class Solution {
	public int mySqrt(int x) {
		long start = 0;
		long end = 1;
		while(end * end < x) {
			start = start<<1;
			end = end<<1;
		}
		while(start <= end) {
			long center = (start + end) / 2;
			if(center * center <= x && (center + 1) * (center + 1) > x) {
				return (int)center;
			}
			else if(center * center > x && (center - 1) * (center - 1) <= x) {
				return (int)center - 1;
			}
			else if((center - 1) * (center - 1) > x) {
				end = center - 1;
			}
			else {
				start = center + 1;
			}
		}
		return (int)start;
	}
}