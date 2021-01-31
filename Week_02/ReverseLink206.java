/**
 * @Author: Andrew Lu
 * @Description: 逆转连标
 */
public class ReverseLink206 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * 递归
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head) {
        if(head==null|| head.next==null){return head;}
        ListNode cur=reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return cur;

    }
    /**
     * 迭代
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if(head==null|| head.next==null){return head;}
        ListNode prev=null;
        ListNode now=head;
        while(now!=null) {
            ListNode nextNode=now.next;
            now.next=prev;
            prev=now;
            nextNode=now;
        }
        return prev;

    }
}
