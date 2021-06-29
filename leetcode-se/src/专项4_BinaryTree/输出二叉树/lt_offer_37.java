package 专项4_BinaryTree.输出二叉树;

import sun.awt.image.ImageWatched;
import 专项4_BinaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class lt_offer_37 {
    /**
     * 剑指 Offer 37. 序列化二叉树
     * 请实现两个函数，分别用来序列化和反序列化二叉树。
     *
     * 示例:
     *
     * 你可以将以下二叉树：
     *
     *     1
     *    / \
     *   2   3
     *      / \
     *     4   5
     *
     * 序列化为 "[1,2,3,null,null,4,5]"
     */
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (root == null){
            sb.append("]");
            return sb.toString();
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node != null){
                sb.append(node.val + ",");
                queue.add(node.left);
                queue.add(node.right);
            }else {
                sb.append("null,");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("[]")){
            return null;
        }
        String str = data.substring(1, data.length() - 1);
        String[] vars = str.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(vars[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (!vars[i].equals("null")){
                node.left = new TreeNode(Integer.parseInt(vars[i]));
                queue.add(node.left);
            }
            i++;
            if (!vars[i].equals("null")){
                node.right = new TreeNode(Integer.parseInt(vars[i]));
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        String str = "[123456]";
        System.out.println(str.substring(1, str.length() - 1));
    }
}
