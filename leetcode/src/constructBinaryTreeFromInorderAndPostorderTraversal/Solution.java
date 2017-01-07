package constructBinaryTreeFromInorderAndPostorderTraversal;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * <p/>
 * Note:
 * You may assume that duplicates do not exist in the tree.
 */
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length == 0) {
            return null;
        }
        return buildTree(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] postorder, int postStart, int postEnd, int[] inorder, int inStart, int inEnd) {
        int mid = postorder[postEnd];
        int idx = inStart;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == mid) {
                idx = i;
                break;
            }
        }

        TreeNode root = new TreeNode(mid);
        if (inStart < idx) {
            root.left = buildTree(postorder, postStart, postStart + idx - inStart - 1, inorder, inStart, idx - 1);
        }
        if (idx < inEnd) {
            root.right = buildTree(postorder, postEnd - inEnd + idx, postEnd - 1, inorder, idx + 1, inEnd);
        }
        return root;
    }

    @Test
    public void test() {
        TreeNode root = buildTree(new int[]{1, 2}, new int[]{1, 2});
        assertEquals(2, root.val);
        assertEquals(1, root.left.val);
        root = buildTree(new int[]{1, 2, 3}, new int[]{3, 2, 1});
        assertEquals(1, root.val);
        assertEquals(2, root.right.val);
        assertEquals(3, root.right.right.val);
    }
}
