package 专项4_BinaryTree.二叉树验证;

import 专项4_BinaryTree.TreeNode;

import java.util.Stack;

public class lt_98 {
    /**
     * 98. 验证二叉搜索树
     * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
     *
     * 假设一个二叉搜索树具有如下特征：
     *
     * 节点的左子树只包含小于当前节点的数。
     * 节点的右子树只包含大于当前节点的数。
     * 所有左子树和右子树自身必须也是二叉搜索树。
     * 示例 1:
     *
     * 输入:
     *     2
     *    / \
     *   1   3
     * 输出: true
     * 示例 2:
     *
     * 输入:
     *     5
     *    / \
     *   1   4
     *      / \
     *     3   6
     * 输出: false
     * 解释: 输入为: [5,1,4,null,null,3,6]。
     *      根节点的值为 5 ，但是其右子节点值为 4 。
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null){
            return true;
        }

        return judge(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean judge(TreeNode node, long lower, long upper){
        if (node == null){
            return true;
        }
        if (node.val <= lower || node.val >= upper){
            return false;
        }
        return judge(node.left, lower, node.val) && judge(node.right, node.val, upper);
    }

    public boolean isValidBST2(TreeNode root) {
        if (root == null){
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = new TreeNode(Integer.MIN_VALUE);
        TreeNode node = root;
        while (!stack.isEmpty() || node != null){
            if (node != null){
                stack.push(node);
                node = node.left;
            }else{
                node = stack.pop();
                if (node.val > pre.val){
                    pre = node;
                }else {
                    return false;
                }
                node = node.right;
            }
        }
        return true;
    }

    public boolean isValidBST3(TreeNode root) {
        if (root == null){
            return true;
        }

        TreeNode cur1 = root;
        TreeNode cur2 = null;
        TreeNode pre = null;
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
            if (pre != null && pre.val >= cur1.val){
                return false;
            }
            pre = cur1;
            cur1 = cur1.right;
        }
        return true;
    }
}
