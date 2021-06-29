package 专项3_LinkedNode.倒数第k个节点;

import 专项3_LinkedNode.ListNode;

public class lt_offer_20 {
    /**
     * 剑指 Offer 22. 链表中倒数第k个节点
     * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
     *
     * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null || k < 1){
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;
        for (int i = 1; i <= k; i++) {
            if (fast != null){
                fast = fast.next;
            }
        }


        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
