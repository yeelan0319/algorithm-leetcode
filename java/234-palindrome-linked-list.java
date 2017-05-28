import java.util.*;

/**
 * Created by yiranmao on 8/19/15.
 */
public class Driver {
    public static void main(String[] args) {
        test(1, new ListNode(new int[]{1, 2, 2, 1}), true);
        test(2, new ListNode(new int[]{1, 2, 3}), false);
        test(3, new ListNode(new int[]{1, 1}), true);
        test(4, null, true);
        test(5, new ListNode(new int[]{1}), true);
    }

    public static void test(int testNo, ListNode head, boolean expectValue) {
        //System.out.print(l1.toString() + ", " + l2.toString());
        boolean res = isPalindrome(head);

        if (res == expectValue) {
            System.out.println(testNo + ": Pass");
        } else {
            System.out.println(testNo + ": Fail");
            System.out.println("Expect " + expectValue + ", Return " + res);
        }
    }

    public static boolean isPalindrome(ListNode head) {
        if(head == null) {
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode tail = reverseLinkedList(slow.next);
        while (tail != null) {
            if(head.val != tail.val) {
                return false;
            }
            head = head.next;
            tail = tail.next;
        }
        return true;
    }
    public static ListNode reverseLinkedList(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode prev = head;
        head = head.next;
        prev.next = null;
        while(head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}