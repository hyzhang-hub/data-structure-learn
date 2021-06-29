package 专项4_BinaryTree.二叉树的深度和直径;

import 专项4_BinaryTree.TreeNode;

public class lt_543 {
    /**
     * 543. 二叉树的直径
     * 给定一棵二叉树，你需要计算它的直径长度。
     * 一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
     * 示例 :
     * 给定二叉树
     *
     *           1
     *          / \
     *         2   3
     *        / \
     *       4   5
     * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
     */
    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null){
            return 0;
        }
        process(root);
        return ans - 1;
    }

    public int process(TreeNode node){
        if (node == null){
            return 0;
        }

        int left = process(node.left);
        int right = process(node.right);
        ans = Math.max(ans, left + right + 1);
        return Math.max(left, right) + 1;
    }
}
