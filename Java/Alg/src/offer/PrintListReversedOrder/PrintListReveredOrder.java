package offer.PrintListReversedOrder;

import java.util.ArrayList;
import java.util.Stack;
/**
 *    public class ListNode {
 *        int val;
 *        ListNode next = null;
 *
 *        ListNode(int val) {
 *            this.val = val;
 *        }
 *    }
 *
 */
/*

 */

public class PrintListReveredOrder {
    private ArrayList<Integer> resultList = new ArrayList<>();
    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        if (listNode == null) throw new IllegalArgumentException();
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (!stack.empty()) {
            list.add(stack.pop());
        }
        return list;
    }
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        if(listNode != null) {
            printListFromTailToHead2(listNode.next);
            resultList.add(listNode.val);
        }
        return resultList;
    }
}
