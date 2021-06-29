package 专项3_LinkedNode.合并链表;

import 专项3_LinkedNode.ListNode;

public class lt_23 {
    /**
     * 23. 合并K个升序链表
     * 给你一个链表数组，每个链表都已经按升序排列。
     * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
     * 示例 1：
     * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
     * 输出：[1,1,2,3,4,4,5,6]
     * 解释：链表数组如下：
     * [
     *   1->4->5,
     *   1->3->4,
     *   2->6
     * ]
     * 将它们合并到一个有序链表中得到。
     * 1->1->2->3->4->4->5->6
     * 示例 2：
     * 输入：lists = []
     * 输出：[]
     * 示例 3：
     *
     * 输入：lists = [[]]
     * 输出：[]
     * 提示：
     * k == lists.length
     * 0 <= k <= 10^4
     * 0 <= lists[i].length <= 500
     * -10^4 <= lists[i][j] <= 10^4
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0){
            return null;
        }
        ListNode dummy = new ListNode(-1);
        ListNode ptr = dummy;
        ptr.next  = lists[0];
        for (int i = 1; i < lists.length; i++) {
            ptr.next = mergeTwoList(ptr.next, lists[i]);
        }
        return dummy.next;
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int l, int r){
        if (l == r){
            return lists[l];
        }

        if (l > r){
            return null;
        }

        int mid = (l + r) >> 1;
        return mergeTwoList(merge(lists, l, mid), merge(lists, mid + 1, r));
    }

    public ListNode mergeTwoList(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode ptr = dummy;
        while (l1 != null && l2 != null){
            if (l1.val <= l2.val){
                ptr.next = l1;
                l1 = l1.next;
            }else {
                ptr.next = l2;
                l2 = l2.next;
            }
            ptr = ptr.next;
        }
        ptr.next = l1 != null ? l1 : l2;
        return dummy.next;
    }
}
