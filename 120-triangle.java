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

    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int min = Integer.MAX_VALUE;
        LinkedList<Integer> pos = new LinkedList<Integer>();
        int[] res = new int[n];
        pos.add(0);
        res[0] = triangle.get(0).get(0);
        while(pos.size() > 0) {
            int index = pos.size();
            int p = pos.getLast();
            while(index < n) {
                res[index] = res[index - 1] + triangle.get(index).get(p);
                pos.add(p);
                index = pos.size();
            }
            min = Math.min(min, res[n - 1]);
            int lastpos = pos.removeLast();
            while(pos.size() > 0 && lastpos == pos.getLast() + 1) {
                lastpos = pos.removeLast();
            }
            index = pos.size();
            p = lastpos + 1;
            if(lastpos + 1 < triangle.get(index).size()) {
                res[index] = res[index - 1] + triangle.get(index).get(p);
                pos.add(p);
            }
        }
        return min;
    }
}