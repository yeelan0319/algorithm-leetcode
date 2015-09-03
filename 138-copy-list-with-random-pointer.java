/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return null;
        HashMap<RandomListNode, RandomListNode> hm = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode newDummyHead = new RandomListNode(0);
        RandomListNode newTail = newDummyHead;
        while(head != null) {
            RandomListNode copy, random;
            if(!hm.containsKey(head)) {
                copy = new RandomListNode(head.label);
                hm.put(head, copy);
            }
            else {
                copy = hm.get(head);
            }
            if(head.random != null && !hm.containsKey(head.random)) {
                random = new RandomListNode(head.random.label);
                hm.put(head.random, random);
            }
            else {
                random = hm.get(head.random);
            }
            copy.random = random;
            newTail.next = copy;
            newTail = newTail.next;
            head = head.next;
        }
        return newDummyHead.next;
    }
}