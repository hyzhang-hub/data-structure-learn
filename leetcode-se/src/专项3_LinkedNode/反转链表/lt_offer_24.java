package 专项3_LinkedNode.反转链表;

import 专项3_LinkedNode.ListNode;

public class lt_offer_24 {
    /**
     * 剑指 Offer 24. 反转链表
     * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
     * 示例:
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     * 限制：
     * 0 <= 节点个数 <= 5000
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode ptr = null;
        ListNode cur = head;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = ptr;
            ptr = cur;
            cur = next;
        }
        return ptr;
    }
}
