package 专项4_BinaryTree.输出二叉树;

import sun.awt.image.ImageWatched;
import 专项4_BinaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class lt_297 {
    /**
     * 297. 二叉树的序列化与反序列化
     * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，
     * 同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
     *
     * 请设计一个算法来实现二叉树的序列化与反序列化。
     * 这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
     *
     * 提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。
     * 你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
     * 示例 1：
     * 输入：root = [1,2,3,null,null,4,5]
     * 输出：[1,2,3,null,null,4,5]
     * 示例 2：
     *
     * 输入：root = []
     * 输出：[]
     * 示例 3：
     *
     * 输入：root = [1]
     * 输出：[1]
     * 示例 4：
     *
     * 输入：root = [1,2]
     * 输出：[1,2]
     */
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder("[");
        if (root == null){
            return sb.append("]").toString();
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node != null){
                sb.append(node.val + ",");
                queue.add(node.left);
                queue.add(node.right);
            }else{
                sb.append("null,");
            }

        }
        sb.substring(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("[]")){
            return null;
        }
        String[] vars = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(vars[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (!vars[i].equals("null")){
                TreeNode cur = new TreeNode(Integer.parseInt(vars[i]));
                node.left = cur;
                queue.add(cur);
            }
            i++;
            if (!vars[i].equals("null")){
                TreeNode cur = new TreeNode(Integer.parseInt(vars[i]));
                node.right = cur;
                queue.add(cur);
            }
            i++;
        }
        return root;
    }
}
