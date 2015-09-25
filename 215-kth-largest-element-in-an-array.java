import com.sun.org.apache.xpath.internal.operations.Bool;

        import java.util.*;
        import java.util.function.BooleanSupplier;

/**
 * Created by yiranmao on 8/19/15.
 */
public class Driver {
    public static void main(String[] args) {
        test(1, new int[]{3,2,1,5,6,4}, 2, 5);
        test(2, new int[]{3,2,1,5,6,4}, 6, 1);
        test(3, new int[]{1,1,1,1,1,1}, 2, 1);
        test(4, new int[]{3,3,1,1,3,5}, 2, 3);
    }

    public static void test(int testNo, int[] nums, int k, int expectValue) {
        int res = findKthLargest(nums, k);

//        for(String s : res) {
//            System.out.print(s + ",");
//        }
//        System.out.println("");
        if (res == expectValue) {
            System.out.println(testNo + ": Pass");
        } else {
            System.out.println(testNo + ": Fail");
            System.out.println("Expect " + expectValue + ", Return " + res);
        }
    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(k);
        int i = 0;
        while(heap.size() < k) {
            heap.add(nums[i]);
            i++;
        }
        while(i < nums.length) {
            if(nums[i] > heap.peek()) {
                heap.poll();
                heap.add(nums[i]);
            }
            i++;
        }
        return heap.peek();
    }
}