package reorderList;

/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * <p/>
 * You must do this in-place without altering the nodes' values.
 * <p/>
 * For example,
 * Given {1,2,3,4}, reorder it to {1,4,2,3}.
 */
public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }

        ListNode h1 = head;
        ListNode h2 = head;
        while (h2.next != null && h2.next.next != null) {
            h1 = h1.next;
            h2 = h2.next.next;
        }

        ListNode tmp = h1.next;
        h1.next = null;
        h1 = tmp;

        ListNode newHead = null;
        while (h1 != null) {
            tmp = h1.next;
            h1.next = newHead;
            newHead = h1;
            h1 = tmp;
        }

        tmp = head;
        while (tmp != null) {
            ListNode k = tmp.next;
            tmp.next = newHead;
            if (newHead != null) {
                newHead = newHead.next;
                tmp.next.next = k;
            }
            tmp = k;
        }
    }
}