package convertSortedListToBinarySearchTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        List<Integer> nodes = new ArrayList<Integer>();
        while (head != null) {
            nodes.add(head.val);
            head = head.next;
        }
        int[] num = new int[nodes.size()];
        for (int i = 0, len = nodes.size(); i < len; i++) {
            num[i] = nodes.get(i);
        }
        return sortedArrayToBST(num);
    }

    public TreeNode sortedArrayToBST(int[] num) {
        if (num == null || num.length == 0) {
            return null;
        }
        return sortedArrayToBST(num, 0, num.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] num, int low, int high) {
        int mid = (low + high) >>> 1;
        TreeNode root = new TreeNode(num[mid]);
        if (low < mid) {
            root.left = sortedArrayToBST(num, low, mid - 1);
        }
        if (mid < high) {
            root.right = sortedArrayToBST(num, mid + 1, high);
        }
        return root;
    }
}
