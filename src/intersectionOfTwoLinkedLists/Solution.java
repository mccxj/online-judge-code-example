package intersectionOfTwoLinkedLists;

/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * <p/>
 * <p/>
 * For example, the following two linked lists:
 * <p/>
 * A:          a1 → a2
 * ↘
 * c1 → c2 → c3
 * ↗
 * B:     b1 → b2 → b3
 * begin to intersect at node c1.
 * <p/>
 * <p/>
 * Notes:
 * <p/>
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 * Credits:
 * Special thanks to @stellari for adding this problem and creating all test cases.
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode rootA = new ListNode(-1);
        rootA.next = headA;
        ListNode rootB = new ListNode(-1);
        rootB.next = headB;

        int m = 0;
        ListNode tmp = rootA;
        while (tmp != null) {
            tmp = tmp.next;
            m++;
        }

        int n = 0;
        tmp = rootB;
        while (tmp != null) {
            tmp = tmp.next;
            n++;
        }

        while (m > n) {
            rootA = rootA.next;
            m--;
        }
        while (m < n) {
            rootB = rootB.next;
            n--;
        }

        while (rootA != rootB) {
            rootA = rootA.next;
            rootB = rootB.next;
        }

        return rootA;
    }
}
