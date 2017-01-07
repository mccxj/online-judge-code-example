package binaryTreeInorderTraversal;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * <p/>
 * For example:
 * Given binary tree {1,#,2,3},
 * 1
 * \
 * 2
 * /
 * 3
 * return [1,3,2].
 * <p/>
 * Note: Recursive solution is trivial, could you do it iteratively?
 * <p/>
 * confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
 */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        LinkedList<Integer> nodes = new LinkedList<Integer>();
        inorderTraversal(root, nodes);
        return nodes;
    }

    private void inorderTraversal(TreeNode root, List<Integer> nodes) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, nodes);
        nodes.add(root.val);
        inorderTraversal(root.right, nodes);
    }
}
