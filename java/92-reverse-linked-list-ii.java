import java.util.*;

/**
 * Created by yiranmao on 8/19/15.
 */
public class Driver {
    public static void main(String[] args) {
        test(1, new ListNode(new int[]{1, 2, 3, 4, 5}), 2, 4,  new ListNode(new int[]{1, 4, 3, 2, 5}));
        test(2, new ListNode(new int[]{1, 2}), 1, 2, new ListNode(new int[]{2, 1}));
        test(3, new ListNode(new int[]{1}), 1, 1, new ListNode(new int[]{1}));
        test(4, null, 1, 5, null);
    }

    public static void test(int testNo, ListNode head, int m, int n, ListNode expectValue) {
        //System.out.print(l1.toString() + ", " + l2.toString());
        ListNode res = reverseBetween(head, m, n);

        if (res == expectValue || res.equals(expectValue)) {
            System.out.println(testNo + ": Pass");
        } else {
            System.out.println(testNo + ": Fail");
            System.out.println("Expect " + expectValue.toString() + ", Return " + res.toString());
        }
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || m - n == 0) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        while(m > 1) {
            head = head.next;
            m--;
            n--;
        }
        head.next = reverseBetweenHelper(head.next, head.next, head.next.next, n - m - 1);
        return dummy.next;
    }
    public static ListNode reverseBetweenHelper(ListNode newTail, ListNode prev, ListNode head, int k) {
        if(k == 0) {
            newTail.next = head.next;
            head.next = prev;
            return head;
        }
        else {
            ListNode next = head.next;
            head.next = prev;
            return reverseBetweenHelper(newTail, head, next, k - 1);
        }
    }
}