package swapNodesInPairs;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * <p/>
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * <p/>
 * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode root = head;
        ListNode last = head;
        if (head.next != null) {
            ListNode tmp = head.next.next;
            root = head.next;
            root.next = head;
            last = head;
            last.next = null;
            head = tmp;
        }

        while (head != null && head.next != null) {
            ListNode tmp = head.next.next;
            last.next = head.next;
            last.next.next = head;
            last = head;
            last.next = null;
            head = tmp;
        }

        if (head != null && head.next == null) {
            last.next = head;
            last.next.next = null;
        }

        return root;
    }

    @Test
    public void test() {
        ListNode head = new ListNode(1);
        ListNode nh = swapPairs(head);
        assertEquals(1, nh.val);

        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        nh = swapPairs(head);
        assertEquals(2, nh.val);
        assertEquals(1, nh.next.val);
        assertEquals(4, nh.next.next.val);
        assertEquals(3, nh.next.next.next.val);

        nh.next.next.next.next = new ListNode(5);
        ListNode nh2 = swapPairs(nh);
        assertEquals(1, nh2.val);
        assertEquals(2, nh2.next.val);
        assertEquals(3, nh2.next.next.val);
        assertEquals(4, nh2.next.next.next.val);
        assertEquals(5, nh2.next.next.next.next.val);
    }
}
