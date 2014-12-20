package rotateList;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * <p/>
 * For example:
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        int size = 1;
        ListNode last = head;
        while (last.next != null) {
            size++;
            last = last.next;
        }
        last.next = head;

        int pos = (size - n % size) % size;
        while (pos-- > 0) {
            last = last.next;
        }

        ListNode newHead = last.next;
        last.next = null;
        return newHead;
    }

    @Test
    public void test1() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        ListNode root = rotateRight(head, 2);
        assertEquals(2, root.val);
        assertEquals(3, root.next.val);
        assertEquals(1, root.next.next.val);
        assertEquals(null, root.next.next.next);
    }
}
