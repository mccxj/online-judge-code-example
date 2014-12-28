package convertSortedArrayToBinarySearchTree;

/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 */
public class Solution {
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
