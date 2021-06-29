package 专项3_LinkedNode.反转链表;

import 专项3_LinkedNode.ListNode;

public class lt_25 {
    /**
     * 25. K 个一组翻转链表
     * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
     * k 是一个正整数，它的值小于或等于链表的长度。
     * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
     * 进阶：
     * 你可以设计一个只使用常数额外空间的算法来解决此问题吗？
     * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
     * 示例 1：
     * 输入：head = [1,2,3,4,5], k = 2
     * 输出：[2,1,4,3,5]
     * 示例 2：
     * 输入：head = [1,2,3,4,5], k = 3
     * 输出：[3,2,1,4,5]
     * 示例 3：
     * 输入：head = [1,2,3,4,5], k = 1
     * 输出：[1,2,3,4,5]
     * 示例 4：
     * 输入：head = [1], k = 1
     * 输出：[1]
     * 提示：
     * 列表中节点的数量在范围 sz 内
     * 1 <= sz <= 5000
     * 0 <= Node.val <= 1000
     * 1 <= k <= sz
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode ptr = dummy;
        ListNode start, end = ptr;
        while (end != null){
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null){
                break;
            }
            ListNode next = end.next;
            end.next = null;
            start = ptr.next;
            ptr.next = reverseList(start);
            start.next = next;
            ptr.next = end;
            ptr = start;
            end = start;
        }
        return dummy.next;
    }

    private ListNode reverseList(ListNode head){
        ListNode cur = head;
        ListNode ptr = null;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = ptr;
            ptr = cur;
            cur = next;
        }
        return ptr;
    }
}
