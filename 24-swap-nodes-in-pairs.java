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
        test(1, new ListNode(new int[]{1, 2, 3, 4}), new ListNode(new int[]{2, 1, 4, 3}));
        test(2, new ListNode(new int[]{1, 2, 4}), new ListNode(new int[]{2, 1, 4}));
        test(3, new ListNode(new int[]{2, 4}), new ListNode(new int[]{4, 2}));
        test(4, new ListNode(new int[]{1}), new ListNode(new int[]{1}));
        test(5, null, null);
    }

    public static void test(int testNo, ListNode head, ListNode expectValue) {
        //System.out.print(l1.toString() + ", " + l2.toString());
        ListNode res = swapPairs(head);

        if (res == expectValue || res.equals(expectValue)) {
            System.out.println(testNo + ": Pass");
        } else {
            System.out.println(testNo + ": Fail");
            System.out.println("Expect " + expectValue.toString() + ", Return " + res.toString());
        }
    }

    public static ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        return swapPairsHelper(dummy).next;
    }
    public static ListNode swapPairsHelper(ListNode head) {
        if(head.next == null || head.next.next == null) {
            return head;
        }
        ListNode n1 = head.next;
        ListNode n2 = head.next.next;
        head.next = n2;
        n1.next = swapPairsHelper(n2).next;
        n2.next = n1;
        return head;
    }
}
}