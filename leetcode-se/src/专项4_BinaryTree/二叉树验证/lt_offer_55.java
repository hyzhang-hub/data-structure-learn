package 专项4_BinaryTree.二叉树验证;

import 专项4_BinaryTree.TreeNode;

public class lt_offer_55 {
    /**
     * 剑指 Offer 55 - II. 平衡二叉树
     * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
     * 示例 1:
     *
     * 给定二叉树 [3,9,20,null,null,15,7]
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回 true 。
     *
     * 示例 2:
     *
     * 给定二叉树 [1,2,2,3,3,null,null,4,4]
     *
     *        1
     *       / \
     *      2   2
     *     / \
     *    3   3
     *   / \
     *  4   4
     * 返回 false 。
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }
        return judge(root);
    }

    public boolean judge(TreeNode node){
        if (node == null){
            return true;
        }

        return Math.abs(getHeight(node.left) - getHeight(node.right)) <= 1
                && judge(node.left)
                && judge(node.right);
    }

    public int getHeight(TreeNode root){
        if (root == null){
            return 0;
        }
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

}
