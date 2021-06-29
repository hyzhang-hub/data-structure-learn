package 专项4_BinaryTree.构造二叉树;

import 专项4_BinaryTree.TreeNode;

public class lt_889 {
    /**
     * 889. 根据前序和后序遍历构造二叉树
     * 返回与给定的前序和后序遍历匹配的任何二叉树。
     *  pre 和 post 遍历中的值是不同的正整数。
     * 示例：
     *
     * 输入：pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
     * 输出：[1,2,3,4,5,6,7]
     * 提示：
     * 1 <= pre.length == post.length <= 30
     * pre[] 和 post[] 都是 1, 2, ..., pre.length 的排列
     * 每个输入保证至少有一个答案。如果有多个答案，可以返回其中一个。
     */
    int[] pre, post;
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        this.pre = pre;
        this.post = post;
        return build(0, 0, pre.length);
    }

    public TreeNode build(int i0, int i1, int n){
        if (n == 0){
            return null;
        }
        TreeNode node = new TreeNode(pre[i0]);
        if (n == 1){
            return node;
        }

        int L = 1;
        for (;L < n; L++){
            if (post[i1 + L - 1] == pre[i0 + 1]){
                break;
            }
        }

        node.left = build(i0 + 1, i1, L);
        node.right = build(i0 + L + 1, i1 + L, n - 1 - L);
        return node;
    }


}
