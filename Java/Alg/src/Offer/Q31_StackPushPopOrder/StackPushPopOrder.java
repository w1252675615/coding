package Offer.Q31_StackPushPopOrder;

import java.util.Stack;

public class StackPushPopOrder {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        int push = 0;
        int pop = 0;
        boolean result = false;
        Stack<Integer> stack = new Stack<>();
        stack.push(pushA[push++]);
        while (pop < popA.length ) {
            if (popA[pop] != stack.peek()) {
                if(push < pushA.length) stack.push(pushA[push++]);
                else break;
            }else {
                stack.pop();
                ++pop;
            }
        }
        if (pop == popA.length) result = true;
        return result;
    }

    public static void main(String[] args) {
        StackPushPopOrder stackPushPopOrder = new StackPushPopOrder();
        int[] a = {7,2,3,4,5};
        int[] b = {5,4,3,2,1};
        System.out.println(stackPushPopOrder.IsPopOrder(a,b));
    }
}
