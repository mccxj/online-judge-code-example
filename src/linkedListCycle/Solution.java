package linkedListCycle;

/**
 * Given a linked list, determine if it has a cycle in it.
 * <p/>
 * Follow up:
 * Can you solve it without using extra space?
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode n1 = head;
        ListNode n2 = head;
        do {
            if (n1.next != null) {
                n1 = n1.next;
            } else {
                return false;
            }
            if (n2.next != null && n2.next.next != null) {
                n2 = n2.next.next;
            } else {
                return false;
            }
        } while (n1 != n2);
        return true;
    }
}
