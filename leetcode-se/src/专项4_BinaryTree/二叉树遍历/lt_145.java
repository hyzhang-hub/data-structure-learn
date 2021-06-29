package 专项4_BinaryTree.二叉树遍历;

import sun.reflect.generics.tree.Tree;
import 专项4_BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class lt_145 {
    /**
     * 145. 二叉树的后序遍历
     * 给定一个二叉树，返回它的 后序 遍历。
     *
     * 示例:
     *
     * 输入: [1,null,2,3]
     *    1
     *     \
     *      2
     *     /
     *    3
     *
     * 输出: [3,2,1]
     * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
     */

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        process(root, res);
        return res;
    }

    public void process(TreeNode root, List<Integer> res){
        if (root == null){
            return;
        }
        process(root.left, res);
        process(root.right, res);
        res.add(root.val);
    }

    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);
        while (!s1.isEmpty()){
            TreeNode node = s1.pop();
            s2.push(node);
            if (node.left != null){
                s1.push(node.left);
            }
            if (node.right != null){
                s2.push(node.right);
            }
        }
        while (!s2.isEmpty()){
            res.add(s2.pop().val);
        }
        return res;
    }

    //morris后续遍历
    public List<Integer> postorderTraversal3(TreeNode root) {
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
                }else {
                    cur2.right = null;
                    printEdge(cur1.left, res);

                }
            }
            cur1 = cur1.right;
        }
        printEdge(root, res);
        return res;
    }

    public void printEdge(TreeNode node, List<Integer> res){
        TreeNode tail = reverseEdge(node);
        TreeNode cur = tail;
        while (cur != null){
            res.add(cur.val);
            cur = cur.right;
        }
        reverseEdge(tail);
    }

    public TreeNode reverseEdge(TreeNode node){
        TreeNode ptr = null;
        while (node != null){
            TreeNode next = node.right;
            node.right = ptr;
            ptr = node;
            node = next;
        }
        return ptr;
    }


}
