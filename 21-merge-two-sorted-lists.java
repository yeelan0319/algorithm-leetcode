import java.util.*;

/**
 * Created by yiranmao on 8/19/15.
 */
public class Driver {
    public static void main(String[] args) {
        test(new ListNode(new int[]{1, 3, 4}), new ListNode(new int[]{2, 5}), new ListNode(new int[]{1, 2, 3, 4, 5}));
        test(new ListNode(new int[]{1, 2, 3, 4, 5}), null, new ListNode(new int[]{1, 2, 3, 4, 5}));
        test(new ListNode(new int[]{1, 2, 3}), new ListNode(new int[]{1, 2, 3}), new ListNode(new int[]{1, 1, 2, 2, 3, 3}));
    }

    public static void test(ListNode l1, ListNode l2, ListNode expectValue) {
    	  //注意这里l2 null.toString()会报错的。
        System.out.print(l1.toString() + ", " + l2.toString());
        ListNode res = mergeTwoLists(l1, l2);

        if (res.equals(expectValue)) {
            System.out.println(": Pass");
        } else {
            System.out.println(": Fail");
            System.out.println("Expect " + expectValue.toString() + ", Return " + res.toString());
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }
        ListNode head;
        if(l1.val > l2.val) {
            head = l2;
            head.next = mergeTwoLists(l1, l2.next);
        }
        else {
            head = l1;
            head.next = mergeTwoLists(l1.next, l2);
        }
        return head;
    }
}