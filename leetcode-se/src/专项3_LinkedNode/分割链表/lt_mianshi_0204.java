package 专项3_LinkedNode.分割链表;

import 专项3_LinkedNode.ListNode;

public class lt_mianshi_0204 {
    /**
     *面试题 02.04. 分割链表
     * 编写程序以 x 为基准分割链表，使得所有小于 x 的节点排在大于或等于 x 的节点之前。
     * 如果链表中包含 x，x 只需出现在小于 x 的元素之后(如下所示)。
     * 分割元素 x 只需处于“右半部分”即可，其不需要被置于左右两部分之间。
     *
     * 示例:
     *
     * 输入: head = 3->5->8->5->10->2->1, x = 5
     * 输出: 3->1->2->10->5->5->8
     */
    public ListNode partition(ListNode head, int x) {

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
