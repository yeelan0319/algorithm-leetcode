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
        test(1, new ListNode(new int[]{1, 4, 3, 2, 5, 2}), 3, new ListNode(new int[]{1, 2, 2, 4, 3, 5}));
        test(2, new ListNode(new int[]{1, 3, 4, 2, 2, 3, 2, 5, 2}), 3, new ListNode(new int[]{1, 2, 2, 2, 2, 3, 4, 3, 5}));
        test(3, new ListNode(new int[]{2, 2, 2}), 3, new ListNode(new int[]{2, 2, 2}));
        test(4, new ListNode(new int[]{2, 2, 2}), 1, new ListNode(new int[]{2, 2, 2}));
        test(5, null, 0, null);
    }

    public static void test(int testNo, ListNode head, int x, ListNode expectValue) {
        //System.out.print(l1.toString() + ", " + l2.toString());
        ListNode res = partition(head, x);

        if (res == expectValue || res.equals(expectValue)) {
            System.out.println(testNo + ": Pass");
        } else {
            System.out.println(testNo + ": Fail");
            System.out.println("Expect " + expectValue.toString() + ", Return " + res.toString());
        }
    }

    public static ListNode partition(ListNode head, int x) {
        if(head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        while(head.next != null && head.next.val < x) {
            head = head.next;
        }
        ListNode tail = head;
        while(tail.next != null) {
            if(tail.next.val < x) {
                ListNode target = tail.next;
                tail.next = target.next;
                target.next = head.next;
                head.next = target;
                head = target;
            }
            else {
                tail = tail.next;
            }
        }
        return dummy.next;
    }
}
}