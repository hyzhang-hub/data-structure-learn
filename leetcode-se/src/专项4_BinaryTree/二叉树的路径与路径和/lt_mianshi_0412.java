package 专项4_BinaryTree.二叉树的路径与路径和;

import 专项4_BinaryTree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class lt_mianshi_0412 {
    /**
     *面试题 04.12. 求和路径
     * 给定一棵二叉树，其中每个节点都含有一个整数数值(该值或正或负)。设计一个算法，打印节点数值总和等于某个给定值的所有路径的数量。注意，路径不一定非得从二叉树的根节点或叶节点开始或结束，但是其方向必须向下(只能从父节点指向子节点方向)。
     *
     * 示例:
     * 给定如下二叉树，以及目标和 sum = 22，
     *
     *               5
     *              / \
     *             4   8
     *            /   / \
     *           11  13  4
     *          /  \    / \
     *         7    2  5   1
     * 返回:
     *
     * 3
     * 解释：和为 22 的路径有：[5,4,11,2], [5,8,4,5], [4,11,7]
     */
    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1);//key-value ----> 前缀和-前缀和出现的次数
        return recur(root, prefixSumCount, sum, 0);

    }

    public int recur(TreeNode node, Map<Integer, Integer> prefixSumCount, int target, int curSum){
        if (node == null){
            return 0;
        }
        int res = 0;

        curSum += node.val;

        res += prefixSumCount.getOrDefault(curSum - target, 0);
        prefixSumCount.put(curSum, prefixSumCount.getOrDefault(curSum, 0) + 1);

        res += recur(node.left, prefixSumCount, target, curSum);
        res += recur(node.right, prefixSumCount, target, curSum);

        prefixSumCount.put(curSum, prefixSumCount.get(curSum) - 1);
        return res;
    }

}
