package 专项4_BinaryTree.二叉树验证;

import 专项4_BinaryTree.TreeNode;

public class lt_offer_28 {
    /**
     * 剑指 Offer 28. 对称的二叉树
     * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
     * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
     *     1
     *    / \
     *   2   2
     *  / \ / \
     * 3  4 4  3
     * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
     *     1
     *    / \
     *   2   2
     *    \   \
     *    3    3
     * 示例 1：
     * 输入：root = [1,2,2,3,4,4,3]
     * 输出：true
     * 示例 2：
     *
     * 输入：root = [1,2,2,null,3,null,3]
     * 输出：false
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }
        return judge(root, root);
    }

    public boolean judge(TreeNode p1, TreeNode p2){
        if (p1 == null && p2 == null){
            return true;
        }

        if (p1 == null || p2 == null){
            return false;
        }

        if (p1.val != p2.val){
            return false;
        }
        return judge(p1.left, p2.right) && judge(p1.right, p2.left);
    }
}
