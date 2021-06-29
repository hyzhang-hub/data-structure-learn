package 专项4_BinaryTree.二叉树的路径与路径和;

import sun.awt.image.ImageWatched;
import 专项4_BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class lt_路径总和II {
    /**
     * 113. 路径总和 II
     * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
     * 叶子节点 是指没有子节点的节点。
     * 示例 1：
     * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
     * 输出：[[5,4,11,2],[5,8,4,5]]
     * 示例 2：
     * 输入：root = [1,2,3], targetSum = 5
     * 输出：[]
     * 示例 3：
     * 输入：root = [1,2], targetSum = 0
     * 输出：[]
     * 提示：
     * 树中节点总数在范围 [0, 5000] 内
     * -1000 <= Node.val <= 1000
     * -1000 <= targetSum <= 1000
     */
    List<List<Integer>> res;
    int targetSum;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.res = new LinkedList<List<Integer>>();
        this.targetSum = targetSum;
        if (root == null){
            return res;
        }
        Deque<Integer> path = new LinkedList<>();
        process(root, 0, path);
        return res;
    }

    public void process(TreeNode node, int sum, Deque<Integer> path){
        if (node == null){
            return;
        }
        sum += node.val;
        path.add(node.val);
        if (node.left == null && node.right == null){
            if (sum == targetSum){
                res.add(new LinkedList<>(path));
            }
        }


        process(node.left, sum, path);
        process(node.right, sum, path);
        path.pollLast();
    }
}
