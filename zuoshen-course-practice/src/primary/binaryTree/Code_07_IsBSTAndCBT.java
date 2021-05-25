package primary.binaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Code_07_IsBSTAndCBT {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    /**
     * 判断一棵树是否是搜索二叉树
     * @param head
     * @return
     */
    public static boolean isBST(Node head){
        if (head == null) {
            return true;
        }
        boolean res = true;
        Node pre = null;
        Node cur1 = head;
        Node cur2 = null;
        while (cur1 != null) {
            cur2 = cur1.left;
            if (cur2 != null) {
                while (cur2.right != null && cur2.right != cur1) {
                    cur2 = cur2.right;
                }
                if (cur2.right == null) {
                    cur2.right = cur1;
                    cur1 = cur1.left;
                    continue;
                } else {
                    cur2.right = null;
                }
            }
            if (pre != null && pre.value > cur1.value) {
                res = false;
            }
            pre = cur1;
            cur1 = cur1.right;
        }
        return res;
    }

    public static boolean isBST2(Node head){
        if (head == null){
            return true;
        }
        Node pre = new Node(Integer.MIN_VALUE);
        Node node = head;
        Stack<Node> stack = new Stack<>();

        while (!stack.isEmpty() && node != null){
            if (node != null){
                stack.push(node);
                node = node.left;
            }else{
                node = stack.pop();
                //比较
                if (pre.value >= node.value){
                    return false;
                }else{
                    pre = node;
                }
                node = node.right;
            }
        }

        return true;
    }

    public static class ReturnData{
        public boolean isBST;
        public int min;
        public int max;

        public ReturnData(boolean isBST, int min, int max){
            this.isBST = isBST;
            this.min = min;
            this.max = max;
        }
    }

    public static ReturnData process(Node x){
        if (x == null){
            return null;
        }

        ReturnData leftData = process(x.left);
        ReturnData rightData = process(x.right);

        int min = x.value;
        int max = x.value;

        if (leftData != null){
            min = Math.min(min, leftData.min);
            max = Math.max(max, leftData.max);
        }
        if (rightData != null){
            min = Math.min(min, rightData.min);
            max = Math.max(max, rightData.max);
        }

//        boolean isBst = true;
//        if (leftData != null && (!leftData.isBST || leftData.max >= x.value)){
//            isBst = false;
//        }
//        if (rightData != null && (!rightData.isBST || x.value >=rightData.min)){
//            isBst =false;
//        }
        boolean isBST = false;
        if (
                (leftData != null ? (leftData.isBST && leftData.max < x.value) : true)
                &&
                        (rightData != null ? (leftData.isBST && rightData.min > x.value) :true)
        ){
            isBST = true;
        }

        return new ReturnData(isBST, min, max);
    }

    /**
     * 判断一棵树是否是完全二叉树
     * @param head
     * @return
     */
    public static boolean isCBT(Node head){
        if (head == null){
            return true;
        }

        Queue<Node> queue = new LinkedList<>();
        boolean leaf = false;
        Node l = null;
        Node r = null;
        queue.offer(head);
        while (!queue.isEmpty()){
            head = queue.poll();
            l = head.left;
            r = head.right;
            if ((l == null && r != null) || (leaf && (l != null || r != null))){
                return false;
            }

            if (l != null){
                queue.offer(l);
            }

            if (r != null){
                queue.offer(r);
            }else{
                leaf = true;
            }
        }

        return true;
    }

    public static class Info{
        public int height;
        public int nodes;
        public Info(int height, int nodes){
            this.height = height;
            this.nodes = nodes;
        }
    }

    public static boolean isFull(Node head){
        if (head == null) {
            return true;
        }
        Info data = f(head);
        return data.nodes == (1 << data.height - 1);
    }

    public static Info f(Node x){
        if (x == null){
            return new Info(0, 0);
        }
        Info leftData = f(x.left);
        Info rightData = f(x.right);

        int heght = Math.max(leftData.height, rightData.height);
        int nodes = leftData.nodes + rightData.nodes + 1;
        return new Info(heght, nodes);

    }






    // for test -- print tree
    public static void printTree(Node head) {
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    public static void printInOrder(Node head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.value + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", len);
    }

    public static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }

    public static void main(String[] args) {
        Node head = new Node(4);
        head.left = new Node(2);
        head.right = new Node(6);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.right.left = new Node(5);

        printTree(head);
        System.out.println(isBST(head));
        System.out.println(isBST2(head));
        System.out.println(isCBT(head));

    }
}
