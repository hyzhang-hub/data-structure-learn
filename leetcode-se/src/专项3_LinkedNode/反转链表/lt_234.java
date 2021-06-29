package 专项3_LinkedNode.反转链表;

import 专项3_LinkedNode.ListNode;

public class lt_234 {
    /**
     * 234. 回文链表
     * 请判断一个链表是否为回文链表。
     *
     * 示例 1:
     *
     * 输入: 1->2
     * 输出: false
     * 示例 2:
     *
     * 输入: 1->2->2->1
     * 输出: true
     * 进阶：
     * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null){
            return true;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode next = slow.next;
        slow.next = null;

        ListNode lHead = head;
        ListNode rHead = reverseList(next);

        while (lHead != null && rHead != null){
            if (lHead.val != rHead.val){
                return false;
            }
            lHead = lHead.next;
            rHead = rHead.next;
        }
        return true;
    }

    public ListNode reverseList(ListNode head){
        ListNode ptr = null;
        while (head != null){
            ListNode next = head.next;
            head.next = ptr;
            ptr = head;
            head = next;
        }
        return ptr;
    }
}
