package 专项4_BinaryTree.二叉树的路径与路径和;

import 专项4_BinaryTree.TreeNode;

public class lt_437 {
    /**
     *437. 路径总和 III
     * 给定一个二叉树，它的每个结点都存放着一个整数值。
     * 找出路径和等于给定数值的路径总数。
     * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
     * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
     * 示例：
     * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
     *
     *       10
     *      /  \
     *     5   -3
     *    / \    \
     *   3   2   11
     *  / \   \
     * 3  -2   1
     *
     * 返回 3。和等于 8 的路径有:
     *
     * 1.  5 -> 3
     * 2.  5 -> 2 -> 1
     * 3.  -3 -> 11
     */
    int res;
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null){
            return 0;
        }
        process(root, targetSum);
        pathSum(root.left,targetSum);
        pathSum(root.right,targetSum);
        return res;

    }

    public void process(TreeNode node, int target){
        if (node == null){
            return;
        }
        target -= node.val;
        if (target == 0){
            res++;
        }
        process(node.left, target);
        process(node.right, target);
        target += node.val;
    }

}
