package 专项3_LinkedNode.链表相交;

import 专项3_LinkedNode.ListNode;

public class lt_offer_52 {
    /**
     * 两个链表的第一个公共相交的节点
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB){
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
