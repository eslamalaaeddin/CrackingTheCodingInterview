package StacksAndQueues;

import java.util.Stack;

public class MyQueue {
    //enqueue
    //deque
    //empty?
    //peek

    private final Stack<Integer> stack1 = new Stack<>();
    private final Stack<Integer> stack2 = new Stack<>();


    void enqueue(int data) {
        stack1.add(data);
        stack2.clear();
        copyElementsOfS1ToS2Reversed();
    }

    int dequeue() {
        if (stack2.empty())
            throw new RuntimeException("Stack is Empty");
        return stack2.pop();
    }

    boolean isEmpty(){
        return stack2.empty();
    }

    int peek(){
        return stack2.peek();
    }

    private void copyElementsOfS1ToS2Reversed() {
        for (int i = stack1.size() - 1; i >= 0; i--)
            stack2.push(stack1.get(i));
    }

    public Stack<Integer> getStack1() {
        return stack1;
    }

    public Stack<Integer> getStack2() {
        return stack2;
    }
}
