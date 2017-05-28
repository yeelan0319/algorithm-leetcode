import java.util.*;

/**
 * Created by yiranmao on 8/19/15.
 */
public class Driver {
    public static void main(String[] args) {
        test(new ListNode(new int[]{1, 2, 3, 4, 5}), 2, new ListNode(new int[]{1, 2, 3, 5}));
        test(new ListNode(new int[]{1, 2, 3, 4, 5}), 5, new ListNode(new int[]{2, 3, 4, 5}));
        test(new ListNode(new int[]{1, 2, 3, 4, 5}), 1, new ListNode(new int[]{1, 2, 3, 4}));
    }

    public static void test(ListNode head, int n, ListNode expectValue) {
        ListNode res = removeNthFromEnd(head, n);

        if (res.equals(expectValue)) {
            System.out.println(head.toString() + ": Pass");
        } else {
            System.out.println(head.toString() + ": Fail");
            System.out.println("Expect " + expectValue.toString() + ", Return " + res.toString());
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode runner = dummy;
        ListNode follower = dummy;
        for(int i = 0; i < n; i++) {
            runner = runner.next;
        }
        while(runner.next != null) {
            runner = runner.next;
            follower = follower.next;
        }
        follower.next = follower.next.next;
        return dummy.next;
    }
}