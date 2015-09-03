import java.util.*;

/**
 * Created by yiranmao on 8/19/15.
 */
public class Driver {
    public static void main(String[] args) {
        test(1, new ListNode(new int[]{1, 2, 3, 4}), new ListNode(new int[]{4, 3, 2, 1}));
        test(2, new ListNode(new int[]{1, 2}), new ListNode(new int[]{2, 1}));
        test(3, new ListNode(new int[]{2}), new ListNode(new int[]{2}));
        test(4, new ListNode(new int[]{1}), new ListNode(new int[]{1}));
        test(5, null, null);
    }

    public static void test(int testNo, ListNode head, ListNode expectValue) {
        //System.out.print(l1.toString() + ", " + l2.toString());
        ListNode res = reverseList(head);

        if (res == expectValue || res.equals(expectValue)) {
            System.out.println(testNo + ": Pass");
        } else {
            System.out.println(testNo + ": Fail");
            System.out.println("Expect " + expectValue.toString() + ", Return " + res.toString());
        }
    }

    public static ListNode reverseList(ListNode head) {
        if(head == null) return head;
        ListNode prev = head;
        head = head.next;
        // 此处一定要注意，head的next需要改为null，否则它仍在最后指向第二个元素，而第二个元素又指向它从而出现死循环
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