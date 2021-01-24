/**
 * @Author: Andrew Lu
 * @Description: 合并两个有序链表
 */
public class MergeTwoSortedLinkedList21 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * 迭代
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null) {
            return l2;
        }
        if(l2==null) {
            return l1;
        }
        if(l1==null && l2==null) {
            return new ListNode(0);
        }
        //虚拟头节点，返回dummyHead.next
        ListNode dummyHead= new ListNode(0);
        ListNode p=dummyHead;
        while (l1!=null && l2!=null) {
            if(l1.val>l2.val){
                p.next=new ListNode(l2.val);
                l2=l2.next;
            }else{
                p.next=new ListNode(l1.val);
                l1=l1.next;
            }
            p=p.next;
        }
        p.next=l1==null?l2:l1;
        return dummyHead.next;
    }

    /**
     * 通过递归
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if(l1==null) {
            return l2;
        }
        if(l2==null) {
            return l1;
        }
        if(l1.val>l2.val){
            l2.next=mergeTwoLists2(l1,l2.next);
            return l2;
        }else{
            l1.next=mergeTwoLists2(l1.next,l2);
            return l1;
        }
    }
}
