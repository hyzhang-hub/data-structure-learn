package 专项3_LinkedNode.删除链表中的某个节点;

import 专项3_LinkedNode.ListNode;

public class lt_19 {
    /**
     * 19. 删除链表的倒数第 N 个结点
     * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     * 进阶：你能尝试使用一趟扫描实现吗？
     * 示例 1：
     * 输入：head = [1,2,3,4,5], n = 2
     * 输出：[1,2,3,5]
     * 示例 2：
     * 输入：head = [1], n = 1
     * 输出：[]
     * 示例 3：
     * 输入：head = [1,2], n = 1
     * 输出：[1]
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode start = dummy;
        ListNode end = dummy;

        while(n >= 0) {
            start = start.next;
            n--;
        }
        while(start != null) {
            end = end.next;
            start = start.next;
        }
        end.next = end.next.next;
        return dummy.next;
    }
}
