package partitionList;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * <p/>
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * <p/>
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode root = new ListNode(-1);
        root.next = head;

        ListNode tail = root;
        ListNode prev = root;
        while (prev.next != null) {
            ListNode t = prev.next;
            if (t.val < x) {
                if (tail.next == t) {
                    tail = t;
                    prev = prev.next;
                } else {
                    prev.next = t.next;
                    t.next = tail.next;
                    tail.next = t;
                    tail = tail.next;
                }
            } else {
                prev = prev.next;
            }
        }
        return root.next;
    }


    @Test
    public void test1() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        head = partition(head, 3);

        assertEquals(1, head.val);
        assertEquals(2, head.next.val);
        assertEquals(2, head.next.next.val);
        assertEquals(4, head.next.next.next.val);
        assertEquals(3, head.next.next.next.next.val);
        assertEquals(5, head.next.next.next.next.next.val);
        assertEquals(null, head.next.next.next.next.next.next);
    }
}
