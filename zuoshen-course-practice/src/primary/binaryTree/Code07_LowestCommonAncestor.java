package primary.binaryTree;

public class Code07_LowestCommonAncestor {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }
    /**
     * 给定两个二叉树的节点node1和node2， 找到他们的最低公共祖先节点
     */

    public static Node lowestAncestor(Node head, Node o1, Node o2){
        if (head == null || head == o1 || head == o2){
            return head;
        }

        Node left = lowestAncestor(head.left, o1, o2);
        Node right = lowestAncestor(head.right, o1, o2);
        if (left != null && right != null){
            return head;
        }
        return left != null ? left : right;
    }


}
