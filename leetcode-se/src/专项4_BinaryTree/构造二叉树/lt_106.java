package 专项4_BinaryTree.构造二叉树;

import 专项4_BinaryTree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class lt_106 {
    /**
     *106. 从中序与后序遍历序列构造二叉树
     * 根据一棵树的中序遍历与后序遍历构造二叉树。
     * 注意:
     * 你可以假设树中没有重复的元素。
     * 例如，给出
     * 中序遍历 inorder = [9,3,15,20,7]
     * 后序遍历 postorder = [9,15,7,20,3]
     * 返回如下的二叉树：
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     */
    Map<Integer, Integer> indexMap;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = postorder.length;
        indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(inorder, postorder, 0, n - 1, 0, n - 1);
    }

    public TreeNode myBuildTree(int[] inorder, int[] postorder, int inorder_left, int inorder_right, int postorder_left, int postorder_right){
        if (postorder_left > postorder_right || inorder_left > inorder_right){
            return null;
        }

        Integer inorder_root = indexMap.get(postorder[postorder_right]);
        int size_left_tree = inorder_root - inorder_left;

        TreeNode root = new TreeNode(inorder[inorder_root]);
        root.left = myBuildTree(inorder, postorder, inorder_left, inorder_root - 1, postorder_left, postorder_left + size_left_tree - 1);
        root.right = myBuildTree(inorder, postorder, inorder_root + 1, inorder_right, postorder_left + size_left_tree, postorder_right - 1);
        return root;

    }
}
