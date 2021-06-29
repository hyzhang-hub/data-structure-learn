package 专项4_BinaryTree.二叉树的路径与路径和;

import 专项4_BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class lt_257 {
    /**
     * 257. 二叉树的所有路径
     * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
     * 说明: 叶子节点是指没有子节点的节点。
     * 示例:
     * 输入:
     *    1
     *  /   \
     * 2     3
     *  \
     *   5
     * 输出: ["1->2->5", "1->3"]
     * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
     */
    List<String> res;
    public List<String> binaryTreePaths(TreeNode root) {
        res = new ArrayList<>();
        if (root == null){
            return res;
        }
        process(root, "");
        return res;
    }

    public void process(TreeNode node, String path){
        if (node == null){
            return;
        }
        StringBuilder sb = new StringBuilder(path);

        if (node.left == null && node.right == null){
            sb.append(node.val);
            res.add(sb.toString());
            return;
        }

        sb.append(node.val);
        sb.append("->");
        process(node.left, sb.toString());
        process(node.right, sb.toString());
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("abcd");
        sb.delete(sb.indexOf("b"), sb.indexOf("b") + 3);
        System.out.println(sb.toString());
    }
}
