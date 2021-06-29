package 专项4_BinaryTree.二叉树的祖先;

import 专项4_BinaryTree.TreeNode;

public class lt_offer_68_II {
    /**
     *
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null){
            return root;
        }

        return left == null ? right : left;
    }
}
