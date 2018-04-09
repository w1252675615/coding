package Offer.Q06_PrintListReversedOrder;

public class ListReversed {
    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode Reversedhead = ReverseList(head.next);
        head.next.next = head;
        head.next = null;
        return Reversedhead;
    }
}
