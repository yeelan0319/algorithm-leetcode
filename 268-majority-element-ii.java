import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;
import java.util.function.BooleanSupplier;

/**
 * Created by yiranmao on 8/19/15.
 */
public class Driver {
    public static void main(String[] args) {
        test(1, new int[]{1,2,2,1,2,1,1}, new ArrayList<Integer>(Arrays.asList(2, 1)));
        test(2, new int[]{1,2,5,1,6,1,1}, new ArrayList<Integer>(Arrays.asList(1)));
        test(3, new int[]{2,2,5,1,6,5,1}, new ArrayList<Integer>());
        test(4, new int[]{}, new ArrayList<Integer>());
        test(5, new int[]{0 ,0 ,0}, new ArrayList<Integer>(Arrays.asList(0)));
    }

    public static void test(int testNo, int[] nums, List<Integer> expectValue) {
        List<Integer> res = majorityElement(nums);

//        System.out.println(res);
//        System.out.println("");
        if (res.equals(expectValue)) {
            System.out.println(testNo + ": Pass");
        } else {
            System.out.println(testNo + ": Fail");
            System.out.println("Expect " + expectValue + ", Return " + res);
        }
    }

    public static List<Integer> majorityElement(int[] nums) {
        int candidate1 = 0;
        int candidate2 = 1;
        int count1 = 0;
        int count2 = 0;
        for(int i = 0; i < nums.length; i++) {
            if(count1 == 0 && candidate2 != nums[i]) {
                candidate1 = nums[i];
            }
            else if(count2 == 0 && candidate1 != nums[i]) {
                candidate2 = nums[i];
            }
            if(candidate1 == nums[i]) {
                count1++;
            }
            else if(candidate2 == nums[i]) {
                count2++;
            }
            else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for(int i = 0; i < nums.length; i++) {
            if(candidate1 == nums[i]) count1++;
            if(candidate2 == nums[i]) count2++;
        }
        List<Integer> res = new ArrayList<Integer>();
        if(count1 > nums.length / 3) res.add(candidate1);
        if(count2 > nums.length / 3) res.add(candidate2);
        return res;
    }
}