package validateBinarySearchTree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * <p/>
 * Assume a BST is defined as follows:
 * <p/>
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
 */
public class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        LinkedList<Integer> nodes = new LinkedList<Integer>();
        inorderTraversal(root, nodes);
        Iterator<Integer> it = nodes.iterator();
        int pre = it.next();
        while (it.hasNext()) {
            int curr = it.next();
            if (pre >= curr) {
                return false;
            }
            pre = curr;
        }
        return true;
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
