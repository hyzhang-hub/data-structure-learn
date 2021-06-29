package 专项4_BinaryTree.构造二叉树;

import 专项4_BinaryTree.TreeNode;

public class lt_mianshi_0402 {
    /**
     * 面试题 04.02. 最小高度树
     * 给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。
     *
     * 示例:
     * 给定有序数组: [-10,-3,0,5,9],
     *
     * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
     *
     *           0
     *          / \
     *        -3   9
     *        /   /
     *      -10  5
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0){
            return null;
        }
        return build(nums, 0, nums.length - 1);
    }

    public TreeNode build(int[] nums, int left, int right){
        if (left > right){
            return null;
        }

        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = build(nums, left, mid - 1);
        node.right = build(nums, mid + 1, right);
        return node;
    }
}
