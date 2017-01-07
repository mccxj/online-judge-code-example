package binarySearchTreeIterator;

import java.util.Stack;

/**
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 * <p/>
 * Calling next() will return the next smallest number in the BST.
 * <p/>
 * Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 * <p/>
 * Credits:
 * Special thanks to @ts for adding this problem and creating all test cases.
 */
public class BSTIterator {
    Stack<TreeNode> nodes = new Stack<TreeNode>();

    public BSTIterator(TreeNode root) {
        TreeNode tmp = root;
        while (tmp != null) {
            nodes.add(tmp);
            tmp = tmp.left;
        }
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !nodes.isEmpty();
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode head = nodes.pop();
        TreeNode tmp = head.right;
        while (tmp != null) {
            nodes.add(tmp);
            tmp = tmp.left;
        }
        return head.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */