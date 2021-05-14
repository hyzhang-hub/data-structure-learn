package binaryTree;

import java.util.Stack;

public class Code_01_PreInPosTraversal {
    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int data){
            this.value = data;
        }
    }

    /**
     * 递归解法
     * @param head
     */
    //先序遍历
    public static void preOrderRecur(Node head){
        if(head == null){
            return;
        }
        System.out.println(head.value + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    //中序遍历
    public static void inOrderRecur(Node head){
        if (head == null){
            return;
        }

        inOrderRecur(head.left);
        System.out.println(head.value + " ");
        inOrderRecur(head.right);
    }

    //后续遍历
    public static void posOrderRecur(Node head){
        if (head == null){
            return;
        }
        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.println(head.value + " ");
    }

    /**
     * 非递归解法
     */

    //先序遍历
    public static void preOrderUnRecur(Node head){
        System.out.print("pre order: ");
        if (head != null){
            Stack<Node> stack = new Stack<>();
            stack.push(head);
            while (!stack.isEmpty()){
                Node node  = stack.pop();
                System.out.print(node.value + " ");
                if (node.right != null){
                    stack.push(node.right);
                }
                if (node.left != null){
                    stack.push(node.left);
                }
            }
        }
        System.out.println();
    }


    //中序遍历
    public static void inOrderUnRecur(Node head){
        System.out.print("in order: ");
        if (head != null){
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || head != null){
                if (head != null){
                    stack.push(head);
                    head = head.left;
                }else{
                    head = stack.pop();
                    System.out.print(head.value + " ");
                    head = head.right;
                }
            }
        }
        System.out.println();
    }

    //后序遍历
    public static void posOrderUnRecur1(Node head){
        System.out.print("pos order1: ");
        if (head != null){
            Stack<Node> s1 = new Stack<>();
            Stack<Node> s2 = new Stack<>();
            s1.push(head);
            while (!s1.isEmpty()){
                Node node = s1.pop();
                s2.push(node);
                if (node.left != null){
                    s1.push(node.left);
                }
                if (node.right != null){
                    s1.push(node.right);
                }
            }
            while (!s2.isEmpty()){
                System.out.print(s2.pop().value + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head.left = new Node(3);
        head.right = new Node(8);
        head.left.left = new Node(2);
        head.left.right = new Node(4);
        head.left.left.left = new Node(1);
        head.right.left = new Node(7);
        head.right.left.left = new Node(6);
        head.right.right = new Node(10);
        head.right.right.left = new Node(9);
        head.right.right.right = new Node(11);

        // recursive
        System.out.println("==============recursive==============");
        System.out.print("pre-order: ");
        preOrderRecur(head);
        System.out.println();
        System.out.print("in-order: ");
        inOrderRecur(head);
        System.out.println();
        System.out.print("pos-order: ");
        posOrderRecur(head);
        System.out.println();

        // unrecursive
        System.out.println("============unrecursive=============");
        preOrderUnRecur(head);
        inOrderUnRecur(head);
        posOrderUnRecur1(head);
//        posOrderUnRecur2(head);

    }

}
