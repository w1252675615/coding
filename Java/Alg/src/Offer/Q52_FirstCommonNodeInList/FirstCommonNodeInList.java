package Offer.Q52_FirstCommonNodeInList;
/*
    找到两个链表的第一个公共节点
 */
public class FirstCommonNodeInList {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) return null;
        int length1 = getLength(pHead1);
        int length2 = getLength(pHead2);
        if (length1 < length2) {
            ListNode temp = pHead1;
            pHead1 = pHead2;
            pHead2 = temp;
        }
        for (int i = 0; i < Math.abs(length1-length2);++i) {
            pHead1 = pHead1.next;
        }
        while (pHead1 != null && pHead2 != null && pHead1 != pHead2) {
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        return pHead1;
    }
    private int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            head = head.next;
            ++length;
        }
        return length;
    }
}
