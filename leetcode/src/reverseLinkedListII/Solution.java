package reverseLinkedListII;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * <p/>
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * <p/>
 * return 1->4->3->2->5->NULL.
 * <p/>
 * Note:
 * Given m, n satisfy the following condition:
 * 1 ≤ m ≤ n ≤ length of list.
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m == n) {
            return head;
        }

        ListNode root = new ListNode(-1);
        root.next = head;

        ListNode mprev = root;
        while (--m > 0) {
            mprev = mprev.next;
        }
        ListNode mcurr = mprev.next;

        ListNode ncurr = root.next;
        while (--n > 0) {
            ncurr = ncurr.next;
        }
        ListNode nnext = ncurr.next;
        ncurr.next = null;

        while (mcurr != null) {
            ListNode tmp = mcurr.next;
            mcurr.next = nnext;
            nnext = mcurr;
            mcurr = tmp;
        }

        mprev.next = nnext;
        return root.next;
    }

    @Test
    public void test() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode nh2 = reverseBetween(head, 2, 5);
        assertEquals(1, nh2.val);
        assertEquals(5, nh2.next.val);
        assertEquals(4, nh2.next.next.val);
        assertEquals(3, nh2.next.next.next.val);
        assertEquals(2, nh2.next.next.next.next.val);
    }
}
