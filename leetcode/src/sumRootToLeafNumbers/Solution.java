package sumRootToLeafNumbers;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * <p/>
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * <p/>
 * Find the total sum of all root-to-leaf numbers.
 * <p/>
 * For example,
 * <p/>
 * 1
 * / \
 * 2   3
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * <p/>
 * Return the sum = 12 + 13 = 25.
 */
public class Solution {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return sumNumbers(root, 0);
    }

    private int sumNumbers(TreeNode root, int sum) {
        int curr = sum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return curr;
        }
        int newsum = 0;
        if (root.left != null) {
            newsum += sumNumbers(root.left, curr);
        }
        if (root.right != null) {
            newsum += sumNumbers(root.right, curr);
        }
        return newsum;
    }
}
