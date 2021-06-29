package 专项4_BinaryTree.二叉树验证;

import 专项4_BinaryTree.TreeNode;

public class lt_mianshi_0404 {
    /**
     * 面试题 04.04. 检查平衡性
     * 实现一个函数，检查二叉树是否平衡。在这个问题中，平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1。
     *
     *
     * 示例 1:
     * 给定二叉树 [3,9,20,null,null,15,7]
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回 true 。
     * 示例 2:
     * 给定二叉树 [1,2,2,3,3,null,null,4,4]
     *       1
     *      / \
     *     2   2
     *    / \
     *   3   3
     *  / \
     * 4   4
     * 返回 false 。
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }
        return check(root);

    }

    public boolean check(TreeNode node){
        if (node == null){
            return true;
        }
        return Math.abs(getHeight(node.left) - getHeight(node.right)) <= 1
                && check(node.left)
                && check(node.right);
    }

    public int getHeight(TreeNode node){
        if (node == null){
            return 0;
        }
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }
}
