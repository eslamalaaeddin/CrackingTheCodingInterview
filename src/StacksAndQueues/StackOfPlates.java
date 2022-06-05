package StacksAndQueues;

import java.util.ArrayList;
import java.util.List;

public class StackOfPlates {
    private int threshold;
    private Stacky currentStack;
    private int currentIndex;
    private List<Integer> arrayOfTops = new ArrayList<>();

    public StackOfPlates(int threshold) {
        this.threshold = threshold;
        currentStack = new Stacky();
    }

    void push(int data) {
        if (currentStack.getSize() < threshold)
            currentStack.push(data);

        else if (currentStack.getSize() == threshold){
            Stacky oldStack = currentStack;
            currentStack = new Stacky();
            currentStack.push(data);
            currentStack.setSize(oldStack.getSize() + 1);
            currentStack.getTop().setNext(oldStack.getTop());
        }
        else{
            currentStack.push(data);
        }
    }

    Item pop() {
        return currentStack.pop();
    }

    //What i get is that index refers to a stack not an element
    int popAt(int index) {
        //TODO FOLLOW UP
        Stacky originalStack = currentStack;

        System.out.println(currentStack.getTop().getData());
        while (currentStack.getSize() > 0 && currentStack.getTop().getNext() != null){
            if (currentStack.getSize() % threshold == 0){
                System.out.println(currentStack.getTop().getData());
            }
            currentStack.setTop(currentStack.getTop().getNext());
            currentStack.setSize(currentStack.getSize()-1);
        }
        return 0;
    }

    public Stacky getCurrentStack() {
        return currentStack;
    }

    public List<Integer> getArrayOfTops() {
        return arrayOfTops;
    }

    public void setCurrentStack(Stacky currentStack) {
        this.currentStack = currentStack;
    }
}
