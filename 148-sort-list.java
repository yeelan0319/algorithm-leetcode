import java.util.*;

/**
 * Created by yiranmao on 8/19/15.
 */
public class Driver {
    public static void main(String[] args) {
        test(1, new ListNode(new int[]{2, 1, 4, 3, 6, 5}), new ListNode(new int[]{1, 2, 3, 4, 5, 6}));
        test(2, new ListNode(new int[]{3, 2 ,1, 4, 5}), new ListNode(new int[]{1, 2, 3, 4, 5}));
        test(3, new ListNode(new int[]{1, 2}), new ListNode(new int[]{1, 2}));
        test(4, new ListNode(new int[]{1, 2, 1}), new ListNode(new int[]{1, 1, 2}));
        test(5, null, null);
        test(6, new ListNode(new int[]{1}), new ListNode(new int[]{1}));
    }

    public static void test(int testNo, ListNode head, ListNode expectValue) {
        //System.out.print(l1.toString() + ", " + l2.toString());
        ListNode res = sortList(head);

        if (res == expectValue || res.equals(expectValue)) {
            System.out.println(testNo + ": Pass");
        } else {
            System.out.println(testNo + ": Fail");
            System.out.println("Expect " + expectValue.toString() + ", Return " + res.toString());
        }
    }

    public static ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode h1 = slow.next;
        ListNode h2 = head;
        slow.next = null;
        return mergeSortedLinkedList(sortList(h1), sortList(h2));
    }
    public static ListNode mergeSortedLinkedList(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        if(l1.val > l2.val) {
            l2.next = mergeSortedLinkedList(l1, l2.next);
            return l2;
        }
        else {
            l1.next = mergeSortedLinkedList(l1.next, l2);
            return l1;
        }
    }
}