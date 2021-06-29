package 专项3_LinkedNode.删除链表中的某个节点;

import 专项3_LinkedNode.ListNode;

public class lt_203 {
    /**
     * 203. 移除链表元素
     * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
     *
     *
     * 示例 1：
     *
     *
     * 输入：head = [1,2,6,3,4,5,6], val = 6
     * 输出：[1,2,3,4,5]
     * 示例 2：
     *
     * 输入：head = [], val = 1
     * 输出：[]
     * 示例 3：
     *
     * 输入：head = [7,7,7,7], val = 7
     * 输出：[]
     */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode ptr = dummy;
        while (ptr.next != null){
            if (ptr.next.val == val){
                ptr.next = ptr.next.next;
            }else {
                ptr = ptr.next;
            }
        }
        return dummy.next;
    }
}
