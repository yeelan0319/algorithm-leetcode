import java.util.*;

/**
 * Created by yiranmao on 8/19/15.
 */
public class Driver {
    public static void main(String[] args) {
        test(1, new ListNode(new int[]{1, 2, 3, 4, 5, 6}), 2, new ListNode(new int[]{2, 1, 4, 3, 6, 5}));
        test(2, new ListNode(new int[]{1, 2, 3, 4, 5}), 3, new ListNode(new int[]{3, 2 ,1, 4, 5}));
        test(3, new ListNode(new int[]{1, 2, 3}), 3, new ListNode(new int[]{3, 2, 1}));
        test(4, new ListNode(new int[]{1, 2, 3}), 1, new ListNode(new int[]{1, 2, 3}));
        test(5, null, 2, null);
        test(6, new ListNode(new int[]{1, 2}), 3, new ListNode(new int[]{1, 2}));
    }

    public static void test(int testNo, ListNode head, int k, ListNode expectValue) {
        //System.out.print(l1.toString() + ", " + l2.toString());
        ListNode res = reverseKGroup(head, k);

        if (res == expectValue || res.equals(expectValue)) {
            System.out.println(testNo + ": Pass");
        } else {
            System.out.println(testNo + ": Fail");
            System.out.println("Expect " + expectValue.toString() + ", Return " + res.toString());
        }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        dummy.next = flipKElement(dummy.next, dummy.next, k - 2, k);
        return dummy.next;
    }
    public static ListNode flipKElement(ListNode newTail, ListNode prev, int n, int k) {
        if(prev == null || prev.next == null) {
            return newTail;
        }
        else if(n == 0) {
            ListNode newHead = prev.next;
            ListNode nextNewHead = flipKElement(newHead.next, newHead.next, k - 2, k);
            newHead.next = prev;
            newTail.next = nextNewHead;
            return newHead;
        }
        else {
            ListNode next = prev.next;
            ListNode newHead = flipKElement(newTail, next, n - 1, k);
            //若返回的是原来的tail，也就是说不翻转前面的都不要变
            if(newHead != newTail) {
                next.next = prev;
            }
            return newHead;
        }
    }
}