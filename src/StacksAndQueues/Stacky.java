package StacksAndQueues;
 class Stacky {

    private int size = 0;
    private Item top;
    private Item lowest;

    void push(int data) {
        Item newItem = new Item(data);

        if (isEmpty()) {
            top = newItem;
            lowest = newItem;
        } else if (newItem.getData() <= lowest.getData())
            lowest = newItem;

        newItem.setNext(top);
        top = newItem;
        size++;
    }

    Item pop() {
        if (size == 0) throw new RuntimeException("Stack is empty!");

        size--;
        Item deleted = top;
        top = top.getNext();
        return deleted;
    }

    Item min() {
        return lowest;
    }

    boolean isEmpty() {
        return size == 0;
    }

    void print() {
        int tempSize = size;
        Item temptop = top;
        if (size == 0) {
            throw new RuntimeException("Stack is empty!");
        }

        while (size > 0) {
            System.out.println(top.getData());
            top = top.getNext();
            size--;
        }
        size = tempSize;
        top = temptop;
        System.out.println("--");
    }
}