package 专项3_LinkedNode.环形链表;

import 专项3_LinkedNode.ListNode;

import java.util.HashSet;
import java.util.Set;

public class lt_141 {
    /**
     * 141. 环形链表
     * 给定一个链表，判断链表中是否有环。
     * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
     * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
     * 注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
     * 如果链表中存在环，则返回 true 。 否则，返回 false 。
     * 进阶：
     * 你能用 O(1)（即，常量）内存解决此问题吗？
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null){
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                return true;
            }
        }
        return false;
    }

    public boolean hasCycle2(ListNode head) {
        Set<ListNode> seen = new HashSet<>();
        while (head != null){
            if (!seen.contains(head)){
                seen.add(head);
            }else{
                return true;
            }
        }
        return false;
    }

}
