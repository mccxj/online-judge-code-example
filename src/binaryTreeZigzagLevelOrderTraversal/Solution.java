package binaryTreeZigzagLevelOrderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 * <p/>
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its zigzag level order traversal as:
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 * confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> rows = new ArrayList<List<Integer>>();
        if (root == null) {
            return rows;
        }

        List<TreeNode> nodeRow = new ArrayList<TreeNode>();
        nodeRow.add(root);

        boolean left2right = true;
        while (!nodeRow.isEmpty()) {
            List<TreeNode> nextNodeRow = new ArrayList<TreeNode>();
            LinkedList<Integer> row = new LinkedList<Integer>();
            for (TreeNode node : nodeRow) {
                if (node.left != null) {
                    nextNodeRow.add(node.left);
                }
                if (node.right != null) {
                    nextNodeRow.add(node.right);
                }
                if (left2right) {
                    row.addLast(node.val);
                } else {
                    row.addFirst(node.val);
                }
            }
            rows.add(row);
            nodeRow = nextNodeRow;
            left2right = !left2right;
        }
        return rows;
    }
}