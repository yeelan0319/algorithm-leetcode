import java.util.*;

/**
 * Created by yiranmao on 8/19/15.
 */
public class Driver {
    public static void main(String[] args) {
        test(1, new ListNode(new int[]{1,3,5,7,9,11,13,15,17,19,21}), new ListNode(new int[]{2}), null);
    }

    public static void test(int testNo, ListNode headA, ListNode headB, ListNode expectValue) {
        //System.out.print(l1.toString() + ", " + l2.toString());
        ListNode res = getIntersectionNode(headA, headB);

        if (res == expectValue || res.equals(expectValue)) {
            System.out.println(testNo + ": Pass");
        } else {
            System.out.println(testNo + ": Fail");
            System.out.println("Expect " + expectValue.val + ", Return " + res.val);
        }
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }
        int diff = length(headA) - length(headB);
        if(diff > 0) {
            while(diff > 0) {
                headA = headA.next;
                diff--;
            }
        }
        else {
            while(diff < 0) {
                headB = headB.next;
                diff++;
            }
        }
        while(headA != null) {
            if(headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
    public static int length(ListNode head) {
        int length = 0;
        while(head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
}