package 专项3_LinkedNode.链表相交;

import 专项3_LinkedNode.ListNode;

public class lt_160 {
    /**
     * 160. 相交链表
     * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headA == null){
            return null;
        }
        ListNode ptrA = headA;
        ListNode ptrB = headB;
        while (ptrA != ptrB){
            ptrA = ptrA == null ? headB : ptrA.next;
            ptrB = ptrB == null ? headA : ptrB.next;
        }
        return ptrA;
    }
}
