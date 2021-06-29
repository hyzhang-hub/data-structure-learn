package 专项4_BinaryTree.构造二叉树;

import 专项4_BinaryTree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class lt_offer_07 {
    /**
     * 剑指 Offer 07. 重建二叉树
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     * 例如，给出
     * 前序遍历 preorder = [3,9,20,15,7]
     * 中序遍历 inorder = [9,3,15,20,7]
     * 返回如下的二叉树：
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     *
     *
     * 限制：
     *
     * 0 <= 节点个数 <= 5000
     */
    Map<Integer, Integer> indexMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right){
        if (preorder_left > preorder_right){
            return null;
        }

        Integer inorder_root = indexMap.get(preorder[preorder_left]);
        int size_left_subTree = inorder_root - inorder_left;

        TreeNode root = new TreeNode(inorder[inorder_root]);
        root.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left + size_left_subTree, inorder_left, inorder_root - 1);
        root.right = myBuildTree(preorder, inorder, preorder_left + size_left_subTree + 1, preorder_right, inorder_root + 1, inorder_right);
        return root;
    }
}
