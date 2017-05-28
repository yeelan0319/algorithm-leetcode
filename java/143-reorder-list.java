import java.util.*;

/**
 * Created by yiranmao on 8/19/15.
 */
public class Driver {
    public static void main(String[] args) {
        test(1, new ListNode(new int[]{1, 2, 3, 4}), new ListNode(new int[]{1, 4, 2, 3}));
        test(2, new ListNode(new int[]{1, 2, 3}), new ListNode(new int[]{1, 3, 2}));
        test(3, new ListNode(new int[]{1, 2}), new ListNode(new int[]{1, 2}));
        test(4, null, null);
        test(5, new ListNode(new int[]{1, 2, 3, 4, 5, 6, 7}), new ListNode(new int[]{1, 7, 2, 6, 3, 5, 4}));
    }

    public static void test(int testNo, ListNode head, ListNode expectValue) {
        //System.out.print(l1.toString() + ", " + l2.toString());
        reorderList(head);

        if (head == expectValue || head.equals(expectValue)) {
            System.out.println(testNo + ": Pass");
        } else {
            System.out.println(testNo + ": Fail");
            System.out.println("Expect " + expectValue.toString() + ", Return " + head.toString());
        }
    }

    public static void reorderList(ListNode head) {
        if(head == null) {
            return;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode tail = reverseLinkedList(slow.next);
        slow.next = null;
        while (tail != null) {
            ListNode newTail = tail.next;
            tail.next = head.next;
            head.next = tail;
            head = tail.next;
            tail = newTail;
        }
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