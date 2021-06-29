package 专项3_LinkedNode.反转链表;

import 专项3_LinkedNode.ListNode;

public class lt_206 {
    /**
     * 206. 反转链表
     * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
     * 示例 1：
     * 输入：head = [1,2,3,4,5]
     * 输出：[5,4,3,2,1]
     * 示例 2：
     * 输入：head = [1,2]
     * 输出：[2,1]
     * 示例 3：
     * 输入：head = []
     * 输出：[]
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode ptr = null;
        while (head != null){
            ListNode next = head.next;
            head.next = ptr;
            ptr = head;
            head = next;
        }
        return ptr;
    }

    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode ptr = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return ptr;
    }
}
