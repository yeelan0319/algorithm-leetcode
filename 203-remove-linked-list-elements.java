import java.util.*;

/**
 * Created by yiranmao on 8/19/15.
 */
public class Driver {
    public static void main(String[] args) {
        test(1, new ListNode(new int[]{1, 2, 6, 3, 4, 5, 6}), 6,  new ListNode(new int[]{1, 2, 3, 4, 5}));
        test(2, new ListNode(new int[]{1, 2}), 3, new ListNode(new int[]{1, 2}));
        test(3, new ListNode(new int[]{1, 2}), 1, new ListNode(new int[]{2}));
        test(4, new ListNode(new int[]{1, 1, 1, 1, 1}), 1, null);
        test(5, null, 1, null);
    }

    public static void test(int testNo, ListNode head, int val, ListNode expectValue) {
        //System.out.print(l1.toString() + ", " + l2.toString());
        ListNode res = removeElements(head, val);

        if (res == expectValue || res.equals(expectValue)) {
            System.out.println(testNo + ": Pass");
        } else {
            System.out.println(testNo + ": Fail");
            System.out.println("Expect " + expectValue.toString() + ", Return " + res.toString());
        }
    }

    public static ListNode removeElements(ListNode head, int val) {
        if(head == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        while(head.next != null) {
            if (head.next.val == val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return dummy.next;
    }
}