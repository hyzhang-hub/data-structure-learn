package 专项3_LinkedNode.反转链表;

import 专项3_LinkedNode.ListNode;

import java.util.Stack;

public class lt_offer_06 {
    /**
     * 剑指 Offer 06. 从尾到头打印链表
     * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
     * 示例 1：
     * 输入：head = [1,3,2]
     * 输出：[2,3,1]
     */
    public int[] reversePrint(ListNode head) {
        if (head == null){
            return new int[]{};
        }
        int len = 0;
        Stack<Integer> stack = new Stack<>();
        while (head != null){
            len++;
            stack.push(head.val);
            head = head.next;
        }
        int[] res = new int[len];
        int num = 0;
        while (!stack.isEmpty()){
            res[num++] = stack.pop();
        }
        return res;
    }
}
