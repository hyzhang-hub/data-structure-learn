package 专项3_LinkedNode;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }

    public static ListNode create(int[] nums){
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (int num : nums) {
            cur.next = new ListNode(num);
            cur = cur.next;
        }
        return dummy.next;
    }

    public static void printList(ListNode head){
        while (head != null){
            if (head.next != null){
                System.out.print(head.val + "->");
            }else{
                System.out.print(head.val);
            }
            head = head.next;
        }
        System.out.println();
    }
}
