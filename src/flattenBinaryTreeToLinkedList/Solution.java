package flattenBinaryTreeToLinkedList;

import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Given a binary tree, flatten it to a linked list in-place.
 * <p/>
 * For example,
 * Given
 * <p/>
 * 1
 * / \
 * 2   5
 * / \   \
 * 3   4   6
 * The flattened tree should look like:
 * 1
 * \
 * 2
 * \
 * 3
 * \
 * 4
 * \
 * 5
 * \
 * 6
 * click to show hints.
 */
public class Solution {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
        preorderTraversal(root, nodes);
        Iterator<TreeNode> it = nodes.iterator();

        TreeNode pre = it.next();//skip root
        pre.left = null;
        while (it.hasNext()) {
            TreeNode tmp = it.next();
            pre.right = tmp;
            pre = tmp;
            pre.left = null;
        }
        pre.right = null;
    }

    private void preorderTraversal(TreeNode root, List<TreeNode> nodes) {
        if (root == null) {
            return;
        }
        nodes.add(root);
        preorderTraversal(root.left, nodes);
        preorderTraversal(root.right, nodes);
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        flatten(root);

        assertEquals(1, root.val);
        assertEquals(null, root.left);
        assertEquals(2, root.right.val);
        assertEquals(3, root.right.right.val);
        assertEquals(4, root.right.right.right.val);
        assertEquals(5, root.right.right.right.right.val);
        assertEquals(6, root.right.right.right.right.right.val);
        assertEquals(null, root.right.right.right.right.right.left);
        assertEquals(null, root.right.right.right.right.right.right);
        assertEquals(null, root.right.right.right.right.left);
    }
}
