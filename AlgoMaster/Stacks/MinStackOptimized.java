package AlgoMaster.Stacks;

import java.util.Stack;

public class MinStackOptimized {
    Stack<Integer> stack;
    int min;
    public MinStackOptimized() {
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        // If the stack is empty, set min to the val
        if (stack.isEmpty()) {
            min = val;
        } else if (val <= min) {
            // Push current minimum to the stack before the new min
            stack.push(min);
            min = val;
        }
        // Push the value to stack
        stack.push(val);
    }

    public void pop() {
        // If we pop the min value, pop another element to update min
        if (stack.pop() == min && !stack.isEmpty()) {
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
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
