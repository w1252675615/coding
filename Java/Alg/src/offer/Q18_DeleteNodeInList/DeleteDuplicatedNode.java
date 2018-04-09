package Offer.Q18_DeleteNodeInList;

public class DeleteDuplicatedNode {
    public static ListNode deleteDuplication(ListNode pHead)
    {
        if (pHead == null || pHead.next == null) return pHead;
        ListNode tHead = new ListNode(-1);
        tHead.next = pHead;
        ListNode pre = tHead;
        ListNode current = pHead;
        ListNode nextNode = pHead.next;
        while (nextNode != null) {
            if (current.val == nextNode.val) {
                while (nextNode.next != null && nextNode.val == nextNode.next.val) nextNode = nextNode.next;
                pre.next = nextNode.next;
            }else {
                pre = current;
            }
            if (pre.next == null) break;
            else {
                current = pre.next;
                nextNode = current.next;
            }
        }
        return tHead.next;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,3,4};
        ListNode pHead = new ListNode(1);
        ListNode t = pHead;
        for (int i = 1;i<a.length;++i) {
            ListNode p = new ListNode(a[i]);
            t.next = p;
            p.next = null;
            t = p;
        }
        ListNode re = deleteDuplication(pHead);
        while (re != null){
            System.out.println(re.val);
            re = re.next;
        }

    }
}