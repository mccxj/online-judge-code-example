package reverseNodesInKGroup;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * <p/>
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * <p/>
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * <p/>
 * Only constant memory is allowed.
 * <p/>
 * For example,
 * Given this linked list: 1->2->3->4->5
 * <p/>
 * For k = 2, you should return: 2->1->4->3->5
 * <p/>
 * For k = 3, you should return: 3->2->1->4->5
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return head;
        }

        ListNode root = new ListNode(-1);
        root.next = head;

        ListNode tail = root;
        ListNode left = head;

        while (left != null) {
            int i = 0;
            ListNode newLeft = left;
            while (i < k && newLeft != null) {
                newLeft = newLeft.next;
                i++;
            }

            if (i != k) {
                tail.next = left;
                left = null;
            } else {
                ListNode tmp = left;
                ListNode group = null;
                while (tmp != newLeft) {
                    ListNode node = tmp;
                    tmp = tmp.next;
                    node.next = group;
                    group = node;
                }

                tail.next = group;
                tail = left;
                left = newLeft;
            }
        }
        return root.next;
    }

    @Test
    public void test1() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head = reverseKGroup(head, 2);

        assertEquals(2, head.val);
        assertEquals(1, head.next.val);
        assertEquals(4, head.next.next.val);
        assertEquals(3, head.next.next.next.val);
        assertEquals(5, head.next.next.next.next.val);
        assertEquals(null, head.next.next.next.next.next);
    }

    @Test
    public void test2() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head = reverseKGroup(head, 3);

        assertEquals(3, head.val);
        assertEquals(2, head.next.val);
        assertEquals(1, head.next.next.val);
        assertEquals(4, head.next.next.next.val);
        assertEquals(5, head.next.next.next.next.val);
        assertEquals(null, head.next.next.next.next.next);
    }
}
