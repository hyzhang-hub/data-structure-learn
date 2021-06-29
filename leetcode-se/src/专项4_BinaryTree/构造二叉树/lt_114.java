package 专项4_BinaryTree.构造二叉树;

import 专项4_BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class lt_114 {
    /**
     *给你二叉树的根结点 root ，请你将它展开为一个单链表：
     * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
     * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
     * 示例 1：
     * 输入：root = [1,2,5,3,4,null,6]
     * 输出：[1,null,2,null,3,null,4,null,5,null,6]
     * 示例 2：
     * 输入：root = []
     * 输出：[]
     * 示例 3：
     * 输入：root = [0]
     * 输出：[0]
     *提示：
     * 树中结点数在范围 [0, 2000] 内
     * -100 <= Node.val <= 100
     * 进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？
     */
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        preorder(root, list);
        int size = list.size();
        for (int i = 1; i < size; i++) {
            TreeNode pre = list.get(i - 1);
            TreeNode cur = list.get(i);
            pre.right = cur;
            pre.left = null;
        }
    }

    public void preorder(TreeNode root, List<TreeNode> list){
        if (root == null){
            return;
        }
        list.add(root);
        preorder(root.left, list);
        preorder(root.right, list);
    }

    public void flatten2(TreeNode root) {
        TreeNode cur = root;
        while (cur != null){
            if (cur.left != null){
                TreeNode next = cur.left;
                TreeNode pre = next;
                while (pre.right != null){
                    pre = pre.right;
                }
                pre.right = cur.right;
                cur.left = null;
                cur.right = next;
            }
            cur = cur.right;
        }
    }

}
