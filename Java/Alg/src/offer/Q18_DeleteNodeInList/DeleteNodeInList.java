package offer.Q18_DeleteNodeInList;
/*
    O(1)时间删除单链表中节点
 */
public class DeleteNodeInList {
    public void deleteNode(ListNode pHead,ListNode pDelete) {
        if (pHead == null || pDelete == null) return;
        if (pDelete.next != null) {
            pDelete.val = pDelete.next.val;
            pDelete.next = pDelete.next.next;
        }
        else if (pDelete == pHead) {
            pHead = null;
        }else {
            ListNode p = pHead;
            while (p.next != pDelete) {
                p = p.next;
            }
            p.next = null;
        }
    }
}
