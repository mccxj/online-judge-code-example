package binaryTreeMaximumPathSum;

/**
 * Given a binary tree, find the maximum path sum.
 * <p/>
 * The path may start and end at any node in the tree.
 * <p/>
 * For example:
 * Given the below binary tree,
 * <p/>
 * 1
 * / \
 * 2   3
 * Return 6.
 */
public class Solution {
    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPathSumEnd(root);
        return max;
    }

    private int maxPathSumEnd(TreeNode root) {
        int left = Integer.MIN_VALUE;
        int right = Integer.MIN_VALUE;
        if (root.left != null) {
            left = maxPathSumEnd(root.left);
        }
        if (root.right != null) {
            right = maxPathSumEnd(root.right);
        }

        int tmpMax = root.val;
        if (left > 0) {
            tmpMax = tmpMax + left;
        }
        if (right > 0) {
            tmpMax = tmpMax + right;
        }
        if (tmpMax > max) {
            max = tmpMax;
        }

        return root.val + Math.max(0, Math.max(left, right));
    }
}

