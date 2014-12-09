package sortList;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode h1 = head;
        ListNode h2 = head;

        while (h2.next != null && h2.next.next != null) {
            h2 = h2.next.next;
            h1 = h1.next;
        }
        ListNode tmp = h1.next;
        h1.next = null;
        return mergeSort(sortList(head), sortList(tmp));
    }

    private ListNode mergeSort(ListNode h1, ListNode h2) {
        ListNode root = new ListNode(-1);
        ListNode tmp = root;
        while (h1 != null && h2 != null) {
            if (h1.val < h2.val) {
                tmp.next = h1;
                h1 = h1.next;
            } else {
                tmp.next = h2;
                h2 = h2.next;
            }
            tmp = tmp.next;
        }

        if (h1 != null) {
            tmp.next = h1;
        } else {
            tmp.next = h2;
        }
        return root.next;
    }

    @Test
    public void test() {
        ListNode root = new ListNode(10);
        root.next = new ListNode(4);
        root.next.next = new ListNode(8);
        root.next.next.next = new ListNode(7);
        root.next.next.next.next = new ListNode(6);
        root.next.next.next.next.next = new ListNode(-1);
        ListNode head = sortList(root);

        assertEquals(-1, head.val);
        assertEquals(4, head.next.val);
        assertEquals(6, head.next.next.val);
        assertEquals(7, head.next.next.next.val);
        assertEquals(8, head.next.next.next.next.val);
        assertEquals(10, head.next.next.next.next.next.val);
        assertEquals(null, head.next.next.next.next.next.next);
    }
}
