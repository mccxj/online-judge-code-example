package populatingNextRightPointersInEachNode;

import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

/**
 * Given a binary tree
 * <p/>
 * struct TreeLinkNode {
 * TreeLinkNode *left;
 * TreeLinkNode *right;
 * TreeLinkNode *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 * <p/>
 * Initially, all next pointers are set to NULL.
 * <p/>
 * Note:
 * <p/>
 * You may only use constant extra space.
 * You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
 * For example,
 * Given the following perfect binary tree,
 * 1
 * /  \
 * 2    3
 * / \  / \
 * 4  5  6  7
 * After calling your function, the tree should look like:
 * 1 -> NULL
 * /  \
 * 2 -> 3 -> NULL
 * / \  / \
 * 4->5->6->7 -> NULL
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }

        LinkedList<TreeLinkNode> nodes = new LinkedList<TreeLinkNode>();
        nodes.add(root);
        int total = 1;
        while (!nodes.isEmpty()) {
            TreeLinkNode prev = null;
            int tmpTotal = 0;
            while (total-- > 0) {
                TreeLinkNode tmp = nodes.poll();
                if (prev == null) {
                    prev = tmp;
                } else {
                    prev.next = tmp;
                    prev.next.next = null;
                    prev = prev.next;
                }

                if (tmp.left != null) {
                    nodes.add(tmp.left);
                    tmpTotal++;
                }
                if (tmp.right != null) {
                    nodes.add(tmp.right);
                    tmpTotal++;
                }
            }
            total = tmpTotal;
        }
    }

    @Test
    public void test() {
        TreeLinkNode root = new TreeLinkNode(1);
        root.left = new TreeLinkNode(2);
        root.right = new TreeLinkNode(3);
        root.left.left = new TreeLinkNode(4);
        root.left.right = new TreeLinkNode(5);
        root.right.right = new TreeLinkNode(7);

        connect(root);
        assertEquals(null, root.next);
        assertEquals(root.right, root.left.next);
        assertEquals(null, root.right.next);
        assertEquals(root.left.right, root.left.left.next);
        assertEquals(root.right.right, root.left.right.next);
        assertEquals(null, root.right.right.next);
    }
}
