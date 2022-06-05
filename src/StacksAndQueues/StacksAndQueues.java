package StacksAndQueues;

public class StacksAndQueues {

    public static void main(String[] args) {


    }

    static void testQueueViaStacks(){
        MyQueue myQueue = new MyQueue();
        System.out.println(myQueue.isEmpty());
        myQueue.enqueue(5);
        myQueue.enqueue(2);
        myQueue.enqueue(3);
        myQueue.enqueue(4);
        System.out.println(myQueue.isEmpty());

        System.out.println(myQueue.getStack1());
        System.out.println(myQueue.getStack2());

        System.out.println(myQueue.dequeue());

        System.out.println(myQueue.peek());
    }

    static void testStackOfPlates(){
        StackOfPlates stackOfPlates = new StackOfPlates(5);
        for (int i = 1; i <= 9; i++) {
            stackOfPlates.push(i);
        }
        stackOfPlates.getCurrentStack().print();
    }

    static void testStackMin() {
        Stacky stacky = new Stacky();

        stacky.push(0);
        stacky.push(3);
        stacky.push(-1);
        stacky.push(5);
        stacky.push(4);
        stacky.push(10);

        stacky.print();

        System.out.println(stacky.min().getData());
    }

    static void testAnimalShelter() {
        AnimalShelter animalShelter = new AnimalShelter();

        animalShelter.enqueue("dog1");
        animalShelter.enqueue("cat2");
        animalShelter.enqueue("dog3");
        animalShelter.enqueue("dog4");
        animalShelter.enqueue("cat5");
        animalShelter.enqueue("cat6");
        animalShelter.enqueue("cat7");

        System.out.println(animalShelter.dequeue("cat"));
        System.out.println(animalShelter.dequeue("dog"));
        System.out.println(animalShelter.selectSpecific("dog"));
        System.out.println(animalShelter.selectSpecific("cat"));
    }

}
