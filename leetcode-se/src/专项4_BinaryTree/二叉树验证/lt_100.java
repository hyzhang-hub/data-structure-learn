package 专项4_BinaryTree.二叉树验证;

import sun.awt.image.ImageWatched;
import 专项4_BinaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class lt_100 {
    /**
     * 100. 相同的树
     * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
     *
     * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
     * 示例 1：
     * 输入：p = [1,2,3], q = [1,2,3]
     * 输出：true
     * 示例 2：
     * 输入：p = [1,2], q = [1,null,2]
     * 输出：false
     * 示例 3：
     * 输入：p = [1,2,1], q = [1,1,2]
     * 输出：false
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null){
            return true;
        }
        if (p == null || q == null){
            return false;
        }
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.add(p);
        q2.add(q);
        while (!(q1.isEmpty() && q2.isEmpty())){
            TreeNode n1 = q1.poll();
            TreeNode n2 = q2.poll();
            if (n1.val != n2.val){
                return false;
            }
            if (n1.left != null && n2.left != null){
                q1.add(n1.left);
                q2.add(n2.left);
            }else if(n1.left != n2.left){
                return false;
            }
            if (n1.right != null && n2.right != null){
                q1.add(n1.right);
                q2.add(n2.right);
            }else if(n1.right != n2.right){
                return false;
            }
        }
        return true;
    }
    public boolean isSameTree2(TreeNode p, TreeNode q) {

        return judge(p, q);
    }

    public boolean judge(TreeNode p, TreeNode q){
        if (p == null && q == null){
            return true;
        }

        if (p.val != q.val){
            return false;
        }
        judge(p.left, q.left);
        judge(p.right, q.right);
        return judge(p.left, q.left) && judge(p.right, q.right);
    }
}
