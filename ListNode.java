/**
 * Created by yiranmao on 8/31/15.
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
    ListNode(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        for(int x : arr) {
            tail.next = new ListNode(x);
            tail = tail.next;
        }
        val = dummy.next.val;
        next = dummy.next.next;
    }

    public boolean equals(ListNode otherTail) {
        ListNode thisTail = this;
        while(thisTail != null && otherTail !=null) {
            if(thisTail.val != otherTail.val) {
                return false;
            }
            thisTail = thisTail.next;
            otherTail = otherTail.next;
        }
        if(thisTail == null && otherTail == null) {
            return true;
        }
        else {
            return false;
        }
    }

    public String toString() {
        if(this == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        ListNode tail = this;
        while(tail != null) {
            sb.append(tail.val + "->");
            tail = tail.next;
        }
        sb.append("end");
        return sb.toString();
    }
}
