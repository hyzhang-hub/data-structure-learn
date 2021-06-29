package 专项4_BinaryTree.二叉树的路径与路径和;

import 专项4_BinaryTree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class lt_offer_34 {
    /**
     *剑指 Offer 34. 二叉树中和为某一值的路径
     * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
     * 示例:
     * 给定如下二叉树，以及目标和 target = 22，
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
     * [
     *    [5,4,11,2],
     *    [5,8,4,5]
     * ]
     *
     */
    List<List<Integer>> res;
    int target;
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        res = new LinkedList<>();
        this.target = target;
        if (root == null){
            return res;
        }
        Deque<Integer> deque = new LinkedList<>();
        process(root, target, deque);
        return res;
    }

    public void process(TreeNode node, int target, Deque<Integer> path){
        if (node == null){
            return;
        }

        target -= node.val;
        path.add(node.val);
        if (node.left == null && node.right == null && target == 0){
            res.add(new LinkedList<>(path));
        }

        process(node.left, target, path);
        process(node.right, target, path);
        path.pollLast();
    }
}
