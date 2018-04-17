package Offer.Q24_ReversedList;
/*
    给出链表头结点，返回反转之后链表的头结点
 */
public class ReversedList {
    public ListNode ReverseList(ListNode head) {
        if(head == null || head.next == null) return head; //注意head == null防止输入是个null节点的情况
        ListNode reversedHead = ReverseList(head.next);
        head.next.next = head;
        head.next = null;
        return reversedHead;
    }
}
