Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
	public int maxPoints(Point[] points) {
        if(points.length <= 2) return points.length;
        int max = 0;
        for(int i = 0; i < points.length; i++) {
            Map<Integer, Map<Integer, Integer>> map = new HashMap<Integer, Map<Integer, Integer>>();
            int localmax = 0;
            int overlap = 0;
            for(int j = i + 1; j < points.length; j++) {
                int x = points[j].x - points[i].x;
                int y = points[j].y - points[i].y;
                if(x == 0 && y == 0) {
                    overlap++;
                }
                else {
                    int gcd = generateGCD(x, y);
                    if(gcd != 0) {
                        x /= gcd;
                        y /= gcd;
                    }
                    if(map.containsKey(x)) {
                        if(map.get(x).containsKey(y)) {
                            map.get(x).put(y, map.get(x).get(y) + 1);
                        }
                        else {
                            map.get(x).put(y, 1);
                        }
                    }
                    else {
                        Map<Integer, Integer> tmp = new HashMap<Integer, Integer>();
                        tmp.put(y, 1);
                        map.put(x, tmp);
                    }
                    localmax = Math.max(localmax, map.get(x).get(y));
                }
            }
            max = Math.max(max, localmax + overlap + 1);
        }
        return max;
    }
    public int generateGCD(int x, int y) {
        if(y == 0) return x;
        return generateGCD(y, x % y);
    }
}