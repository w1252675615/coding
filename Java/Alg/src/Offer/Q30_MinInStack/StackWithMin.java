package Offer.Q30_MinInStack;

import java.util.Stack;

/*
    带Min函数的栈
 */
public class StackWithMin {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    public void push(int node) {
        if (stack.isEmpty() || node <= minStack.peek()) {
            minStack.push(node);
        }
        stack.push(node);
    }

    public void pop() {
        if (stack.isEmpty()) return;
        int temp = stack.peek();
        stack.pop();
        if(temp == minStack.peek()) minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
