package 专项3_LinkedNode.删除链表中的某个节点;

import 专项3_LinkedNode.ListNode;

import java.util.HashSet;
import java.util.Set;

public class lt_mianshi0201 {
    /**
     * 面试题 02.01. 移除重复节点
     * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
     *
     * 示例1:
     *
     *  输入：[1, 2, 3, 3, 2, 1]
     *  输出：[1, 2, 3]
     * 示例2:
     *
     *  输入：[1, 1, 1, 1, 2]
     *  输出：[1, 2]
     * 提示：
     *
     * 链表长度在[0, 20000]范围内。
     * 链表元素在[0, 20000]范围内。
     */
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode ptr = dummy;
        Set<Integer> set = new HashSet<>();
        while (ptr.next != null){
            if (!set.contains(ptr.next.val)){
                set.add(ptr.next.val);
                ptr = ptr.next;
            }else{
                ptr.next = ptr.next.next;
            }
        }
        return dummy.next;
    }

    public ListNode removeDuplicateNodes2(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode cur = head;
        while (cur != null){
            ListNode temp = cur;
            while (temp.next != null){
                if (temp.next.val == cur.val){
                    temp.next = temp.next.next;
                }else{
                    temp = temp.next;
                }
            }
            cur = cur.next;
        }
        return head;
    }
}
