package uniqueBinarySearchTreesII;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 * <p/>
 * For example,
 * Given n = 3, your program should return all 5 unique BST's shown below.
 * <p/>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 * confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
 */
public class Solution {
    private List<TreeNode> EMPTY;

    public Solution() {
        EMPTY = new ArrayList<TreeNode>();
        EMPTY.add(null);
    }

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return EMPTY;
        }

        List<List<TreeNode>>[] trees = new ArrayList[n];

        // init one node conditions
        trees[0] = new ArrayList<List<TreeNode>>();
        for (int i = 0; i < n; i++) {
            List<TreeNode> node = new ArrayList<TreeNode>();
            node.add(new TreeNode(i + 1));
            trees[0].add(node);
        }

        // for two nodes to N nodes
        for (int i = 1; i < n; i++) {
            trees[i] = new ArrayList<List<TreeNode>>();
            for (int j = 0; j < n - i; j++) {
                List<TreeNode> node = new ArrayList<TreeNode>();
                trees[i].add(node);
                for (int k = 0; k <= i; k++) {
                    List<TreeNode> lefts = k > 0 ? trees[k - 1].get(j) : EMPTY;
                    List<TreeNode> rights = k < i ? trees[i - k - 1].get(j + k + 1) : EMPTY;
                    for (TreeNode left : lefts) {
                        for (TreeNode right : rights) {
                            TreeNode root = new TreeNode(j + k + 1);
                            root.left = left;
                            root.right = right;
                            node.add(root);
                        }
                    }
                }
            }
        }
        return trees[n - 1].get(0);
    }
}
