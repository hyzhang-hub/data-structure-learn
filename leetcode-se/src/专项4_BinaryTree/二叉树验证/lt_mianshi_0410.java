package 专项4_BinaryTree.二叉树验证;

import 专项4_BinaryTree.TreeNode;

public class lt_mianshi_0410 {
    /**
     * 面试题 04.10. 检查子树
     * 检查子树。你有两棵非常大的二叉树：T1，有几万个节点；T2，有几万个节点。设计一个算法，判断 T2 是否为 T1 的子树。
     *
     * 如果 T1 有这么一个节点 n，其子树与 T2 一模一样，则 T2 为 T1 的子树，也就是说，从节点 n 处把树砍断，得到的树与 T2 完全相同。
     *
     * 注意：此题相对书上原题略有改动。
     *
     * 示例1:
     *
     *  输入：t1 = [1, 2, 3], t2 = [2]
     *  输出：true
     * 示例2:
     *
     *  输入：t1 = [1, null, 2, 4], t2 = [3, 2]
     *  输出：false
     */
    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        return (t1 != null && t2 != null)
                && (process(t1, t2) || checkSubTree(t1.left, t2) || checkSubTree(t1.right, t2));
    }

    public boolean process(TreeNode a, TreeNode b){
        if (b == null && a == null){
            return true;
        }

        if (b == null && a != null){
            return false;
        }

        if (a == null || a.val != b.val){
            return false;
        }
        return process(a.left, b.left) && process(a.right, b.right);
    }
}
