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
        ListNode res = insertionSortList(head);

        if (res == expectValue || res.equals(expectValue)) {
            System.out.println(testNo + ": Pass");
        } else {
            System.out.println(testNo + ": Fail");
            System.out.println("Expect " + expectValue.toString() + ", Return " + res.toString());
        }
    }

    public static ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode a = head;
        ListNode b = dummy;
        while(a.next != null) {
            b = dummy;
            while(b != a) {
                if(a.next.val < b.next.val) {
                    ListNode next = a.next.next;
                    a.next.next = b.next;
                    b.next = a.next;
                    a.next = next;
                    break;
                }
                else {
                    b = b.next;
                }
            }
            if(b == a){
                a = a.next;
            }
        }
        return dummy.next;
    }
}