package 专项4_BinaryTree.二叉树的路径与路径和;

import 专项4_BinaryTree.TreeNode;

public class lt_687 {
    /**
     *687. 最长同值路径
     * 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
     * 注意：两个节点之间的路径长度由它们之间的边数表示。
     * 示例 1:
     * 输入:
     *               5
     *              / \
     *             4   5
     *            / \   \
     *           1   1   5
     * 输出:
     * 2
     * 示例 2:
     * 输入:
     *               1
     *              / \
     *             4   5
     *            / \   \
     *           4   4   5
     * 输出:
     * 2
     */
    int ans;
    public int longestUnivaluePath(TreeNode root) {
        if (root == null){
            return 0;
        }
        process(root);
        return ans;
    }

    public int process(TreeNode node){
        if (node == null){
            return 0;
        }

        int left = process(node.left);
        int right = process(node.right);
        int arrowLeft = 0;
        int arrowRight = 0;
        if (node.left != null && node.left.val == node.val){
            arrowLeft += left + 1;
        }
        if (node.right != null && node.right.val == node.val){
            arrowRight += right + 1;
        }

        ans = Math.max(ans, arrowLeft + arrowRight);
        return Math.max(arrowLeft, arrowRight);
    }
}
