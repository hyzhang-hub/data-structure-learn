package 专项3_LinkedNode.倒数第k个节点;

import 专项3_LinkedNode.ListNode;

public class lt_mianshi_0202 {
    /**
     * 面试题 02.02. 返回倒数第 k 个节点
     * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
     *
     * 注意：本题相对原题稍作改动
     *
     * 示例：
     *
     * 输入： 1->2->3->4->5 和 k = 2
     * 输出： 4
     * 说明：
     *
     * 给定的 k 保证是有效的。
     */
    public int kthToLast(ListNode head, int k) {
        if (head == null || k < 1){
            return -1;
        }

        ListNode fast = head;
        ListNode slow = head;
        for (int i = 1; i <= k; i++) {
            if (fast.next != null){
                fast = fast.next;
            }else{
                return -1;
            }
        }

        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow.val;
    }
}
