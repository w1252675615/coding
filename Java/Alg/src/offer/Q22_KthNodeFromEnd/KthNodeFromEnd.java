package Offer.Q22_KthNodeFromEnd;

public class KthNodeFromEnd {
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head == null || k < 1) return null;
        ListNode result = head;
        for (int i = 0;i < k - 1; ++i) {
            if (head.next != null) head = head.next;
            else return null;
        }
        while (head.next != null) {
            head = head.next;
            result = result.next;
        }
        return result;
    }
}
