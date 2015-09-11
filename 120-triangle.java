import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;
import java.util.function.BooleanSupplier;

/**
 * Created by yiranmao on 8/19/15.
 */
public class Driver {
    public static void main(String[] args) {
        test(1, new ArrayList<List<Integer>>(){
            {
                add(new ArrayList<Integer>(Arrays.asList(2)));
                add(new ArrayList<Integer>(Arrays.asList(3, 4)));
                add(new ArrayList<Integer>(Arrays.asList(6, 5, 7)));
                add(new ArrayList<Integer>(Arrays.asList(4, 1, 8, 3)));
            }
        }, 11);
    }

    public static void test(int testNo, List<List<Integer>> triangle, int expectValue) {
        int res = minimumTotal(triangle);

//        for(int[] row : matrix) {
//            for(int i : row) {
//                System.out.print(i + " ");
//            }
//            System.out.println("");
//        }
//        System.out.println("");
        if (res == expectValue) {
            System.out.println(testNo + ": Pass");
        } else {
            System.out.println(testNo + ": Fail");
            System.out.println("Expect " + expectValue + ", Return " + res);
        }
    }
    static int min = Integer.MAX_VALUE;
    public static int minimumTotal(List<List<Integer>> triangle) {
        minimumTotalHelper(triangle, 0 ,0 ,0);
        return min;
    }
    public static void minimumTotalHelper(List<List<Integer>> triangle, int level, int pos, int sum) {
    	sum += triangle.get(level).get(pos);
    	if(level == triangle.size() - 1) {
    		min = Math.min(min, sum);
    		return;
    	}
    	minimumTotalHelper(triangle, level + 1, pos, sum);
    	minimumTotalHelper(triangle, level + 1, pos + 1, sum);
    }
}