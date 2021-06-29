package 专项3_LinkedNode.合并链表;

import 专项3_LinkedNode.ListNode;

public class lt_1669 {
    /**
     * 1669. 合并两个链表
     * 给你两个链表 list1 和 list2 ，它们包含的元素分别为 n 个和 m 个。
     * 请你将 list1 中第 a 个节点到第 b 个节点删除，并将list2 接在被删除节点的位置。
     * 下图中蓝色边和节点展示了操作后的结果：
     * 请你返回结果链表的头指针。
     * 示例 1：
     * 输入：list1 = [0,1,2,3,4,5], a = 3, b = 4, list2 = [1000000,1000001,1000002]
     * 输出：[0,1,2,1000000,1000001,1000002,5]
     * 解释：我们删除 list1 中第三和第四个节点，并将 list2 接在该位置。上图中蓝色的边和节点为答案链表。
     * 示例 2：
     * 输入：list1 = [0,1,2,3,4,5,6], a = 2, b = 5, list2 = [1000000,1000001,1000002,1000003,1000004]
     * 输出：[0,1,1000000,1000001,1000002,1000003,1000004,6]
     * 解释：上图中蓝色的边和节点为答案链表。
     */
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        dummy.next = list1;
        ListNode ptr = dummy;

        for (int i = 0; i < a; i++) {
            ptr = ptr.next;
        }
        ListNode next = ptr.next;
        ptr.next = null;
        ptr.next = list2;

        for (int i = a - 1; i < b; i++) {
            next = next.next;
        }
        ListNode tail = null;
        if (next != null){
            tail = next.next;
            next.next = null;
        }

        while (ptr.next != null){
            ptr = ptr.next;
        }

        ptr.next = tail;
        return dummy.next;
    }
}
