package symmetricTree;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertTrue;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * <p/>
 * For example, this binary tree is symmetric:
 * <p/>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * But the following is not:
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 * <p/>
 * confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
 * Definition for binary tree
 * public class sameTree.TreeNode {
 * int val;
 * sameTree.TreeNode left;
 * sameTree.TreeNode right;
 * sameTree.TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> nodes = new LinkedList<TreeNode>();
        nodes.add(root);
        int len = 1;

        while (!nodes.isEmpty()) {
            List<TreeNode> compareNodes = new ArrayList<TreeNode>();
            int tmpLen = 0;
            for (int i = 0; i < len; i++) {
                TreeNode node = nodes.poll();
                compareNodes.add(node);
                if (node != null) {
                    nodes.add(node.left);
                    nodes.add(node.right);
                    tmpLen += 2;
                }
            }

            for (int i = 0; i < compareNodes.size() / 2; i++) {
                TreeNode p = compareNodes.get(i);
                TreeNode q = compareNodes.get(compareNodes.size() - i - 1);
                if ((p != null && q == null) || (p == null && q != null)) {
                    return false;
                }
                if (p != null && q != null && p.val != q.val) {
                    return false;
                }
            }
            len = tmpLen;
        }
        return true;
    }
    
    @Test
    public void test1(){
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        assertTrue(isSymmetric(root));
    }

    @Test
    public void test2(){
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(3);
        assertTrue(!isSymmetric(root));
    }
}
