package 专项3_LinkedNode.分割链表;

import 专项3_LinkedNode.ListNode;

public class lt_86 {
    /**
     * 86. 分隔链表
     * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
     *
     * 你应当 保留 两个分区中每个节点的初始相对位置。
     * 示例 1：
     * 输入：head = [1,4,3,2,5,2], x = 3
     * 输出：[1,2,2,4,3,5]
     * 示例 2：
     *
     * 输入：head = [2,1], x = 2
     * 输出：[1,2]
     */
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);

        ListNode ptr1 = dummy1;
        ListNode ptr2 = dummy2;

        ListNode cur = head;
        ListNode next = null;

        while (cur != null){
            next = cur.next;
            if (cur.val < x){
                ptr1.next = cur;
                ptr1 = ptr1.next;
            }else{
                ptr2.next = cur;
                ptr2 = ptr2.next;
            }
            cur = next;
        }
        ptr2.next = null;
        ptr1.next = dummy2.next;
        return dummy1.next;
    }
}
