package binaryTreePreorderTraversal;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * <p/>
 * For example:
 * Given binary tree {1,#,2,3},
 * 1
 * \
 * 2
 * /
 * 3
 * return [1,2,3].
 * <p/>
 * Note: Recursive solution is trivial, could you do it iteratively?
 */
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<Integer> nodes = new LinkedList<Integer>();
        preorderTraversal(root, nodes);
        return nodes;
    }

    private void preorderTraversal(TreeNode root, List<Integer> nodes) {
        if (root == null) {
            return;
        }
        nodes.add(root.val);
        preorderTraversal(root.left, nodes);
        preorderTraversal(root.right, nodes);
    }
}
