package 专项4_BinaryTree.二叉树的深度和直径;

import 专项4_BinaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class lt_111 {
    /**
     * 111. 二叉树的最小深度
     * 给定一个二叉树，找出其最小深度。
     *
     * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
     *
     * 说明：叶子节点是指没有子节点的节点。
     * 示例 1：
     * 输入：root = [3,9,20,null,null,15,7]
     * 输出：2
     * 示例 2：
     * 输入：root = [2,null,3,null,4,null,5,null,6]
     * 输出：5
     */
    public int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int dept = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size > 0){
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null){
                    return dept + 1;
                }
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
                size--;
            }
            dept++;
        }
        return dept;
    }

    public int minDepth2(TreeNode root) {
        if (root == null){
            return 0;
        }
        if (root.left == null && root.right == null){
            return 1;
        }

        int minD = Integer.MAX_VALUE;
        if (root.left != null){
            minD = Math.min(minD, minDepth(root.left));
        }
        if (root.right != null){
            minD = Math.min(minD, minDepth(root.right));
        }
        return minD + 1;
    }

}
