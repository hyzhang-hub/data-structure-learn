package 专项3_LinkedNode.链表中的加法;

import 专项3_LinkedNode.ListNode;

import java.util.Stack;

public class lt_445 {
    /**
     * 445. 两数相加 II
     * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
     * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
     * 进阶：
     * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
     * 示例：
     * 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 8 -> 0 -> 7
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode nl1 = reverse(l1);
        ListNode nl2 = reverse(l2);
        int carry = 0;
        ListNode head = null;
        ListNode ptr = null;
        while (nl1 != null || nl2 != null){
            int n1 = nl1 != null ? nl1.val : 0;
            int n2 = nl2 != null ? nl2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null){
                head = ptr = new ListNode(sum % 10);
            } else {
                ptr.next = new ListNode(sum % 10);
                ptr = ptr.next;
            }
            carry = sum / 10;
            if (nl1 != null){
                nl1 = nl1.next;
            }

            if (nl2 != null){
                nl2 = nl2.next;
            }
        }
        if (carry > 0){
            ptr.next = new ListNode(carry);
        }
        return reverse(head);
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();

        while (l1 != null){
            stack1.push(l1);
            l1 = l1.next;
        }

        while (l2 != null){
            stack2.push(l2);
            l2 = l2.next;
        }

        int carry = 0;
        ListNode head = null;
        ListNode ptr = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry > 0){
            int sum = carry;
            sum += !stack1.isEmpty() ? stack1.pop().val : 0;
            sum += !stack2.isEmpty() ? stack2.pop().val : 0;
            ListNode node = new ListNode(sum % 10);
            carry = sum /10;
            node.next = head;
            head = node;
        }
        return head;
    }


    public ListNode reverse(ListNode head){
        ListNode ptr = null;
        while (head != null){
            ListNode next = head.next;
            head.next = ptr;
            ptr = head;
            head = next;
        }
        return ptr;
    }

}
