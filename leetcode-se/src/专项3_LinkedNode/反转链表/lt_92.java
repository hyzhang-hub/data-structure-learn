package 专项3_LinkedNode.反转链表;

import 专项3_LinkedNode.ListNode;

import java.util.List;

public class lt_92 {
    /**
     * 92. 反转链表 II
     * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。
     * 请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
     * 示例 1：
     * 输入：head = [1,2,3,4,5], left = 2, right = 4
     * 输出：[1,4,3,2,5]
     * 示例 2：
     * 输入：head = [5], left = 1, right = 1
     * 输出：[5]
     * 提示：
     * 链表中节点数目为 n
     * 1 <= n <= 500
     * -500 <= Node.val <= 500
     * 1 <= left <= right <= n
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || right <= left){
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode ptr = dummy;
        for (int i = 0; i < left - 1; i++) {
            ptr = ptr.next;
        }

        ListNode cur = ptr.next;
        ListNode next = null;
        for (int i = left; i < right; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = ptr.next;
            ptr.next = next;
        }

        return dummy.next;
    }
    public ListNode reverseBetween2(ListNode head, int left, int right) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode ptr = dummy;
        for (int i = 0; i < left - 1; i++) {
            ptr = ptr.next;
        }

        ListNode start = ptr.next;
        ListNode end = ptr;
        for (int i = left; i <= right; i++) {
            end = end.next;
        }
        ListNode ptr2 = end.next;

        ptr.next = null;
        end.next = null;

        reverse(start);

        ptr.next = end;
        start.next = ptr2;

        return dummy.next;
    }

    public void reverse(ListNode head){
        ListNode ptr = null;
        ListNode cur = head;
        while (cur != null){
            ListNode next = cur;
            cur.next = ptr;
            ptr = cur;
            cur = next;
        }
    }
}
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 因为头节点有可能发生变化，使用虚拟头节点可以避免复杂的分类讨论
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode pre = dummyNode;
        // 第 1 步：从虚拟头节点走 left - 1 步，来到 left 节点的前一个节点
        // 建议写在 for 循环里，语义清晰
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        // 第 2 步：从 pre 再走 right - left + 1 步，来到 right 节点
        ListNode rightNode = pre;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }

        // 第 3 步：切断出一个子链表（截取链表）
        ListNode leftNode = pre.next;
        ListNode curr = rightNode.next;

        // 注意：切断链接
        pre.next = null;
        rightNode.next = null;

        // 第 4 步：同第 206 题，反转链表的子区间
        reverseLinkedList(leftNode);

        // 第 5 步：接回到原来的链表中
        pre.next = rightNode;
        leftNode.next = curr;
        return dummyNode.next;
    }

    private void reverseLinkedList(ListNode head) {
        // 也可以使用递归反转一个链表
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
    }
}
