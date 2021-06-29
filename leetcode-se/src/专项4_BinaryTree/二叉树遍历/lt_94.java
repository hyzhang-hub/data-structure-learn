package 专项4_BinaryTree.二叉树遍历;

import sun.reflect.generics.tree.Tree;
import 专项4_BinaryTree.TreeNode;

import java.util.*;

public class lt_94 {
    /**
     * 94. 二叉树的中序遍历
     * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
     * 示例 1：
     * 输入：root = [1,null,2,3]
     * 输出：[1,3,2]
     * 树中节点数目在范围 [0, 100] 内
     * -100 <= Node.val <= 100
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        process(root, res);
        return res;
    }

    public void process(TreeNode root, List<Integer> res){
        if (root == null){
            return;
        }

        process(root.left, res);
        res.add(root.val);
        process(root.right, res);
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null){
            if (root != null){
                stack.push(root);
                root = root.left;
            }else{
                root = stack.pop();
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }

    //中序遍历：只有一次，直接打印， 两次访问，第二次打印
    public List<Integer> inorderTraversal3(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        TreeNode cur1 = root;
        TreeNode cur2 = null;
        while (cur1 != null){
            cur2 = cur1.left;
            if (cur2 != null){
                while (cur2.right != null && cur2.right != cur1){
                    cur2 = cur2.right;
                }
                if (cur2.right == null){
                    cur2.right = cur1;
                    cur1 = cur1.left;
                    continue;
                }else{
                    cur2.right = null;
                }
            }
            res.add(cur1.val);
            cur1 = cur1.right;
        }
        return res;
    }


}
