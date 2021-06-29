package 专项4_BinaryTree.构造二叉树;

import 专项3_LinkedNode.ListNode;
import 专项4_BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class lt_109 {
    /**
     *109. 有序链表转换二叉搜索树
     * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
     *
     * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
     *
     * 示例:
     *
     * 给定的有序链表： [-10, -3, 0, 5, 9],
     *
     * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
     *
     *       0
     *      / \
     *    -3   9
     *    /   /
     *  -10  5
     */
    public TreeNode sortedListToBST(ListNode head) {
        List<ListNode> list = new ArrayList<>();

        while (head != null){
            list.add(head);
            head = head.next;
        }

        return build(list, 0, list.size() - 1);
    }

    public TreeNode build(List<ListNode> list, int left, int right){
        if (left > right){
            return null;
        }

        int mid = (right + left) / 2;
        TreeNode node = new TreeNode(list.get(mid).val);

        node.left = build(list, left, mid - 1);
        node.right = build(list, mid + 1, right);
        return node;
    }


}
