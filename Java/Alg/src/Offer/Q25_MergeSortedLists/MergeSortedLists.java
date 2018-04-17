package Offer.Q25_MergeSortedLists;

public class MergeSortedLists {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }
        ListNode newHead = null;
        if (list1.val < list2.val) {
            newHead = list1;
            newHead.next = Merge(list1.next,list2);
        }else {
            newHead = list2;
            newHead.next = Merge(list1,list2.next);
        }
        return newHead;
    }
}
