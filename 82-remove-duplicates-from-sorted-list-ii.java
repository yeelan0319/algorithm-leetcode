import java.util.*;

/**
 * Created by yiranmao on 8/19/15.
 */
public class Driver {
    public static void main(String[] args) {
        test(1, new ListNode(new int[]{1, 3, 3, 4, 4}), new ListNode(1));
        test(2, new ListNode(new int[]{3, 1, 3, 4, 4, 1}), null);
        test(3, new ListNode(new int[]{3, 1, 4}), new ListNode(new int[]{3, 1, 4}));
        test(4, null, null);
    }

    public static void test(int testNo, ListNode head, ListNode expectValue) {
        //System.out.print(l1.toString() + ", " + l2.toString());
        ListNode res = deleteDuplicates(head);

        if (res == expectValue || res.equals(expectValue)) {
            System.out.println(testNo + ": Pass");
        } else {
            System.out.println(testNo + ": Fail");
            System.out.println("Expect " + expectValue.toString() + ", Return " + res.toString());
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        HashMap<Integer, Boolean> hm = new HashMap<Integer, Boolean>();
        ListNode tail = head;
        hm.put(tail.val, false);
        while(tail.next != null) {
            if(hm.containsKey(tail.next.val)) {
                hm.put(tail.next.val, true);
                tail.next = tail.next.next;
            }
            else {
                hm.put(tail.next.val, false);
                tail = tail.next;
            }
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        tail = dummy;
        while(tail.next != null) {
            if(hm.get(tail.next.val)) {
                tail.next = tail.next.next;
            }
            else {
                tail = tail.next;
            }
        }
        return dummy.next;
    }
}