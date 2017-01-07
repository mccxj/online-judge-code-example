package constructBinaryTreeFromPreorderAndInorderTraversal;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * <p/>
 * Note:
 * You may assume that duplicates do not exist in the tree.
 */
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        int mid = preorder[preStart];
        int idx = inStart;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == mid) {
                idx = i;
                break;
            }
        }

        TreeNode root = new TreeNode(mid);
        if (inStart < idx) {
            root.left = buildTree(preorder, preStart + 1, preStart + idx - inStart, inorder, inStart, idx - 1);
        }
        if (idx < inEnd) {
            root.right = buildTree(preorder, preEnd - inEnd + idx + 1, preEnd, inorder, idx + 1, inEnd);
        }
        return root;
    }

    @Test
    public void test() {
        TreeNode root = buildTree(new int[]{1, 2}, new int[]{1, 2});
        assertEquals(1, root.val);
        assertEquals(2, root.right.val);
        root = buildTree(new int[]{1, 2, 3}, new int[]{2, 3, 1});
        assertEquals(1, root.val);
        assertEquals(2, root.left.val);
        assertEquals(3, root.left.right.val);
    }
}
