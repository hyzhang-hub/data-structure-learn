package 专项3_LinkedNode.合并链表;

import 专项3_LinkedNode.ListNode;

public class lt_offer_25 {
    /**
     *
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null){
            return l1 == null ? l2 : l1;
        }

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
}
