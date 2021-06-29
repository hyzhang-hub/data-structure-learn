package 专项4_BinaryTree.二叉树验证;

import 专项4_BinaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class lt_offer_26 {
    /**
     * 剑指 Offer 26. 树的子结构
     * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
     * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
     * 例如:
     * 给定的树 A:
     *      3
     *     / \
     *    4   5
     *   / \
     *  1   2
     * 给定的树 B：
     *    4
     *   /
     *  1
     * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
     * 示例 1：
     * 输入：A = [1,2,3], B = [3,1]
     * 输出：false
     * 示例 2：
     *
     * 输入：A = [3,4,5,1,2], B = [4,1]
     * 输出：true
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return  (A != null && B != null) && (process(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    public boolean process(TreeNode a, TreeNode b){
        if (b == null){
            return true;
        }

        if (a == null || a.val != b.val){
            return false;
        }

        return process(a.left, b.left) && process(a.left, b.left);
    }






    public boolean isSubStructure2(TreeNode A, TreeNode B){
        return (A != null && B != null)
                && (recur(A, B) || isSubStructure2(A.left, B) || isSubStructure2(B.right, A));
    }

    public boolean recur(TreeNode A, TreeNode B){
        if (B == null){
            return true;
        }
        if (A == null || A.val != B.val){
            return false;
        }
        return recur(A.left, B.left) && recur(A.right, B.right);
    }

    public static void main(String[] args) {
        String str = "abc";
        String str1 = "abc";
        System.out.println(str == str1);

    }
}

