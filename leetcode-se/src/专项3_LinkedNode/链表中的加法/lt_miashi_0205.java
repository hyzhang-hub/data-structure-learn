package 专项3_LinkedNode.链表中的加法;

import 专项3_LinkedNode.ListNode;

import java.util.List;

public class lt_miashi_0205 {
    /**
     * 面试题 02.05. 链表求和
     * 给定两个用链表表示的整数，每个节点包含一个数位。
     *
     * 这些数位是反向存放的，也就是个位排在链表首部。
     *
     * 编写函数对这两个整数求和，并用链表形式返回结果。
     * 示例：
     * 输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
     * 输出：2 -> 1 -> 9，即912
     * 进阶：思考一下，假设这些数位是正向存放的，又该如何解决呢?
     * 示例：
     * 输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
     * 输出：9 -> 1 -> 2，即912
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode ptr = null;
        int carry = 0;
        while (l1 != null || l2 != null){
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum  = n1 + n2 + carry;
            if (head == null){
                head = ptr = new ListNode(sum % 10);
            }else{
                ptr.next = new ListNode(sum % 10);
                ptr = ptr.next;
            }

            carry = sum / 10;
            if (l1 != null){
                l1 = l1.next;
            }
            if (l2 != null){
                l2 = l2.next;
            }
        }
        if (carry > 0){
            ptr.next = new ListNode(carry);
        }
        return head;
    }
}
