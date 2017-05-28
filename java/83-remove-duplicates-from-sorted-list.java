import java.util.*;

/**
 * Created by yiranmao on 8/19/15.
 */
public class Driver {
    public static void main(String[] args) {
        test(1, new ListNode(new int[]{1, 3, 3, 4, 4}), new ListNode(new int[]{1, 3, 4}));
        test(2, new ListNode(new int[]{3, 1, 3, 4, 4}), new ListNode(new int[]{3, 1, 4}));
        test(3, new ListNode(new int[]{3, 1, 4}), new ListNode(new int[]{3, 1, 4}));
        test(4, null, null);
    }

    public static void test(int testNo, ListNode head, ListNode expectValue) {
        //System.out.print(l1.toString() + ", " + l2.toString());
        ListNode res = deleteDuplicates(head);

        if (res == head || res.equals(expectValue)) {
            System.out.println(testNo + ": Pass");
        } else {
            System.out.println(testNo + ": Fail");
            System.out.println("Expect " + expectValue.toString() + ", Return " + res.toString());
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        HashSet<Integer> hs = new HashSet<Integer>();
        ListNode tail = head;
        hs.add(tail.val);
        while(tail.next != null) {
            if(hs.contains(tail.next.val)) {
                tail.next = tail.next.next;
            }
            else {
                hs.add(tail.next.val);
                tail = tail.next;
            }
        }
        return head;
    }
}