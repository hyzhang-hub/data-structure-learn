package 专项3_LinkedNode.排序链表;

import 专项3_LinkedNode.ListNode;

public class lt_148 {
    /**
     * 148. 排序链表
     * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
     * 进阶：
     * 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
     * 示例 1：
     * 输入：head = [4,2,1,3]
     * 输出：[1,2,3,4]
     * 示例 2：
     * 输入：head = [-1,5,3,4,0]
     * 输出：[-1,0,3,4,5]
     * 示例 3：
     * 输入：head = []
     * 输出：[]
     * 提示：
     * 链表中节点的数目在范围 [0, 5 * 104] 内
     * -105 <= Node.val <= 105
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        int len = getLen(head);
        for (int subLen = 1; subLen < len; subLen<<=1) {
            ListNode ptr = dummy;
            ListNode cur = dummy.next;
            while (cur != null){
                ListNode head1 = cur;
                for (int i = 1; i < subLen && cur.next != null; i++) {
                    cur = cur.next;
                }
                ListNode head2 = cur.next;
                cur.next = null;
                cur = head2;
                for (int i = 1; i < subLen && cur.next != null; i++) {
                    cur = cur.next;
                }
                ListNode next = null;
                if (cur != null){
                    next = cur.next;
                    cur.next = null;
                }
                ListNode merged = merge(head1, head2);
                ptr.next = merged;
                while (ptr.next != null){
                    ptr = ptr.next;
                }
                cur = next;
            }

        }


        return dummy.next;
    }

    public ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode ptr = dummy;
        while (l1 != null && l2 != null){
            if (l1.val <= l2.val){
                ptr.next = l1;
                l1 = l1.next;
            }else{
                ptr.next = l2;
                l2 = l2.next;
            }
            ptr = ptr.next;
        }
        ptr.next = l1 == null ? l2 : l1;
        return dummy.next;
    }

    public int getLen(ListNode head){
        int len = 0;
        while (head != null){
            len++;
            head = head.next;
        }
        return len;
    }

}
