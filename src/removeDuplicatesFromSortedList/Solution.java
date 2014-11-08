package removeDuplicatesFromSortedList;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * <p/>
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = head;
        ListNode next = head.next;
        while (next != null) {
            if (pre.val != next.val) {
                pre.next = next;
                pre = pre.next;
            }
            next = next.next;
        }
        pre.next = null;
        return head;
    }

    @Test
    public void test1() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        ListNode root = deleteDuplicates(head);
        assertEquals(1, root.val);
        assertEquals(2, root.next.val);
        assertEquals(null, root.next.next);
    }

    @Test
    public void test2() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);
        ListNode root = deleteDuplicates(head);
        assertEquals(1, root.val);
        assertEquals(2, root.next.val);
        assertEquals(3, root.next.next.val);
        assertEquals(null, root.next.next.next);
    }
}
