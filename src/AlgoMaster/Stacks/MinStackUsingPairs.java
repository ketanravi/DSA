package AlgoMaster.Stacks;

import java.util.Stack;

public class MinStackUsingPairs {

    private Stack<int[]> stack;

    public MinStackUsingPairs() {
        stack = new Stack<>();
    }

    public void push(int val) {
        // If the stack is empty, the minimum is the value itself
        if (stack.isEmpty()) {
            stack.push(new int[]{val, val});
        } else {
            // Otherwise, push a pair of val and minimum of val and stack's current minimum
            int currentMin = Math.min(val, stack.peek()[1]);
            stack.push(new int[]{val, currentMin});
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }
    public static void main(String[] args){
        MinStackOptimized obj = new MinStackOptimized();
        obj.push(512);
        obj.push(-1024);
        obj.push(-1024);
        obj.push(512);
        obj.pop();
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.getMin());
    }

}
