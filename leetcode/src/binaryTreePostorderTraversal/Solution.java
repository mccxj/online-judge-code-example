package binaryTreePostorderTraversal;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * <p/>
 * For example:
 * Given binary tree {1,#,2,3},
 * 1
 * \
 * 2
 * /
 * 3
 * return [3,2,1].
 * <p/>
 * Note: Recursive solution is trivial, could you do it iteratively?
 */
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> nodes = new LinkedList<Integer>();
        postorderTraversal(root, nodes);
        return nodes;
    }

    private void postorderTraversal(TreeNode root, List<Integer> nodes) {
        if (root == null) {
            return;
        }
        postorderTraversal(root.left, nodes);
        postorderTraversal(root.right, nodes);
        nodes.add(root.val);
    }
}
