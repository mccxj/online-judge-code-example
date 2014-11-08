package sameTree;

/**
 * Given two binary trees, write a function to check if they are equal or not.
 * <p/>
 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 * <p/>
 * Definition for binary tree
 * public class sameTree.TreeNode {
 * int val;
 * sameTree.TreeNode left;
 * sameTree.TreeNode right;
 * sameTree.TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if ((p == null && q != null) || (p != null && q == null)) {
            return false;
        }
        if (p == null && q == null) {
            return true;
        }

        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
