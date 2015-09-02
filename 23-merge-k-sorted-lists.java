import java.util.*;

/**
 * Created by yiranmao on 8/19/15.
 */
public class Driver {
    public static void main(String[] args) {
        test(1, new ListNode[]{new ListNode(new int[]{1, 3, 4}), new ListNode(new int[]{2, 5})}, new ListNode(new int[]{1, 2, 3, 4, 5}));
        test(2, new ListNode[]{new ListNode(new int[]{1, 4}), new ListNode(new int[]{2, 5}), new ListNode(3)}, new ListNode(new int[]{1, 2, 3, 4, 5}));
    }

    public static void test(int testNo, ListNode[] lists, ListNode expectValue) {
        //System.out.print(l1.toString() + ", " + l2.toString());
        ListNode res = mergeKLists(lists);

        if (res.equals(expectValue)) {
            System.out.println(testNo + ": Pass");
        } else {
            System.out.println(testNo + ": Fail");
            System.out.println("Expect " + expectValue.toString() + ", Return " + res.toString());
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>(){
            //注意此处写法
            @Override
            public int compare(ListNode l1, ListNode l2) {
                return l1.val > l2.val? 1 : l1.val == l2.val? 0 : -1;
            }
        });
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        for(ListNode node : lists) {
            if(node != null) {
                q.add(node);
            }
        }
        while(!q.isEmpty()) {
            tail.next = q.poll();
            tail = tail.next;
            if(tail.next != null) {
                q.add(tail.next);
            }
        }
        return dummy.next;
    }
}