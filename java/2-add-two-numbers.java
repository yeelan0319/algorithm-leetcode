/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
	import java.util.*;

/**
 * Created by yiranmao on 8/19/15.
 */
public class Driver {
    public static void main(String[] args) {
        test(1, new ListNode(new int[]{2, 4, 3}), new ListNode(new int[]{5, 6, 4}), new ListNode(new int[]{7, 0, 8}));
        test(2, new ListNode(new int[]{2, 4}), new ListNode(new int[]{5, 6, 4}), new ListNode(new int[]{7, 0, 5}));
        test(3, new ListNode(new int[]{1, 1, 1}), new ListNode(new int[]{9, 8}), new ListNode(new int[]{0, 0, 2}));
        test(4, null, new ListNode(new int[]{5, 6, 4}), new ListNode(new int[]{5, 6, 4}));
        test(5, new ListNode(1), new ListNode(new int[]{9, 9}), new ListNode(new int[]{0, 0, 1}));
    }

    public static void test(int testNo, ListNode l1, ListNode l2, ListNode expectValue) {
        //System.out.print(l1.toString() + ", " + l2.toString());
        ListNode res = addTwoNumbers(l1, l2);

        if (res == expectValue || res.equals(expectValue)) {
            System.out.println(testNo + ": Pass");
        } else {
            System.out.println(testNo + ": Fail");
            System.out.println("Expect " + expectValue.toString() + ", Return " + res.toString());
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 ==null){
            return l1;
        }
        return addTwoNumbersHelper(l1, l2, 0);
    }
    public static ListNode addTwoNumbersHelper(ListNode l1, ListNode l2, int carryon) {
        if(l1 == null && l2 == null && carryon == 0) {
            return null;
        }
        int res = carryon;
        if(l1 != null) {
            res += l1.val;
            l1 = l1.next;
        }
        if(l2 != null) {
            res += l2.val;
            l2 = l2.next;
        }
        ListNode node = new ListNode(res % 10);
        node.next = addTwoNumbersHelper(l1, l2, res / 10);
        return node;
    }
}
}