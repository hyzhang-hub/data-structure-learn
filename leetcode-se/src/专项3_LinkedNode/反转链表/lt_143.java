package 专项3_LinkedNode.反转链表;

import 专项3_LinkedNode.ListNode;

public class lt_143 {
    /**
     * 143. 重排链表
     * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
     * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
     * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     * 示例 1:
     * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
     * 示例 2:
     * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
     */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null){
            return;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode next = slow.next;
        slow.next = null;
        ListNode head1 = head;
        ListNode head2 = reverse(next);
        ListNode n1 = null;
        ListNode n2 = null;
        while (head1 != null && head2 != null){
            n1 = head1.next;
            n2 = head2.next;
            head1.next = head2;
            head1 = n1;

            head2.next = head1;
            head2 = n2;
        }
    }

    public ListNode reverse(ListNode head){
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
