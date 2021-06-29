package 专项4_BinaryTree.二叉树验证;

import sun.reflect.generics.tree.Tree;
import 专项4_BinaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class lt_101 {
    /**
     * 剑指 Offer 28. 对称的二叉树
     * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
     *
     * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
     *     1
     *    / \
     *   2   2
     *  / \ / \
     * 3  4 4  3
     * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
     *
     *     1
     *    / \
     *   2   2
     *    \   \
     *    3    3
     * 示例 1：
     *
     * 输入：root = [1,2,2,3,4,4,3]
     * 输出：true
     * 示例 2：
     *
     * 输入：root = [1,2,2,null,3,null,3]
     * 输出：false
     */
    public boolean isSymmetric(TreeNode root) {
        return judge(root, root);
    }

    public boolean judge(TreeNode p1, TreeNode p2){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(p1);
        queue.add(p2);
        while (!queue.isEmpty()){
            TreeNode n1 = queue.poll();
            TreeNode n2 = queue.poll();
            if (n1 == null && n2 == null){
                continue;
            }
            if (n1 == null || n2 == null || (n1.val != n2.val)){
                return false;
            }
            queue.add(n1.left);
            queue.add(n2.right);

            queue.add(n1.right);
            queue.add(n2.left);
        }
        return true;
    }
}
