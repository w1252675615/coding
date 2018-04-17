package Offer.Q35_CopyComplexList;
/*
    复制复杂的链表
 */
public class CopyComplexList {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) return null;
        addCloneNodeBehind(pHead);
        setRandom(pHead);
        return returnCloneNode(pHead);
    }
    private void addCloneNodeBehind(RandomListNode pHead) {
        RandomListNode pNode = pHead;
        while (pNode != null) {
            RandomListNode pCopy = new RandomListNode(pNode.label);
            pCopy.next = pNode.next;
            pCopy.random = null;
            pNode.next = pCopy;
            pNode = pCopy.next;
        }
    }
    private void setRandom(RandomListNode pHead) {
        RandomListNode pNode = pHead;
        while (pNode != null) {
            RandomListNode pCopy = pNode.next;
            if (pNode.random != null) pCopy.random = pNode.random.next;
            pNode = pCopy.next;
        }
    }
    private RandomListNode returnCloneNode(RandomListNode pHead) {
        RandomListNode pNode = pHead;
        RandomListNode cHead = pHead.next;
        while (pNode != null) {
            RandomListNode pCopy = pNode.next;
            pNode.next = pCopy.next;
            pNode = pNode.next;
            pCopy.next = pNode == null? null:pNode.next;
        }
        return cHead;
    }
}
