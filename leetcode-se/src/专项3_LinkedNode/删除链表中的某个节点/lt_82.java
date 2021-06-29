package 专项3_LinkedNode.删除链表中的某个节点;

import 专项3_LinkedNode.ListNode;

public class lt_82 {
    /**
     * 82. 删除排序链表中的重复元素 II
     * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。
     *
     * 返回同样按升序排列的结果链表。
     * 示例 1：
     * 输入：head = [1,2,3,3,4,4,5]
     * 输出：[1,2,5]
     * 示例 2：
     * 输入：head = [1,1,1,2,3]
     * 输出：[2,3]
     * 提示：
     * 链表中节点数目在范围 [0, 300] 内
     * -100 <= Node.val <= 100
     * 题目数据保证链表已经按升序排列
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode ptr = dummy;

        while (ptr.next != null && ptr.next.next != null){
            if (ptr.next.val == ptr.next.next.val){
                ListNode temp = ptr;
                while (temp.next != null && temp.next.next != null && temp.next.val == temp.next.next.val){
                    temp = temp.next;
                }
                ptr.next = temp.next.next;
            }else{
                ptr = ptr.next;
            }

        }
        return dummy.next;
    }
}
