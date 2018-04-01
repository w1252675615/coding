package offer.Q09_QueueWithTwoStack;
/*
    两个栈实现队列
 */
import java.util.Stack;

public class QueueWithTwoStack {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack1 == null && stack2 == null) throw new RuntimeException("Queue is Empty");
        if (stack2.empty()){
            while (!stack1.empty()) stack2.push(stack1.pop());
        }
        return stack2.pop();
    }
}
