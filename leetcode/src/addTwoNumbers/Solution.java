package addTwoNumbers;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p/>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        int plus = 0;
        ListNode head = new ListNode(-1);
        ListNode curr = head;
        while (l1 != null && l2 != null) {
            int val = l1.val + l2.val + plus;
            if (val >= 10) {
                val -= 10;
                plus = 1;
            } else {
                plus = 0;
            }
            curr.next = new ListNode(val);
            curr = curr.next;

            l1 = l1.next;
            l2 = l2.next;
        }

        ListNode left = l1 == null ? l2 : l1;
        while (left != null) {
            int val = left.val + plus;
            if (val >= 10) {
                val -= 10;
                plus = 1;
            } else {
                plus = 0;
            }
            curr.next = new ListNode(val);
            curr = curr.next;

            left = left.next;
        }

        if (plus == 1) {
            curr.next = new ListNode(1);
        }
        return head.next;
    }

    @Test
    public void test() {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode head = addTwoNumbers(l1, l2);
        assertEquals(7, head.val);
        assertEquals(0, head.next.val);
        assertEquals(8, head.next.next.val);

        l1.next.next.next = new ListNode(1);
        l2.next.next.next = new ListNode(9);
        head = addTwoNumbers(l1, l2);
        assertEquals(0, head.next.next.next.val);
        assertEquals(1, head.next.next.next.next.val);

        l2.next.next.next.next = new ListNode(9);
        head = addTwoNumbers(l1, l2);
        assertEquals(0, head.next.next.next.next.val);
        assertEquals(1, head.next.next.next.next.next.val);
    }
}
