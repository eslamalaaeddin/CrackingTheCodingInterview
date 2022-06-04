import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class StacksAndQueues {

    static class Item {
        int data;
        Item next;

        public Item(int data) {
            this.data = data;
        }

        public Item(int data, Item next) {
            this.data = data;
            this.next = next;
        }
    }

    static class Stacky<Integer> {

        int size = 0;
        Item top;
        Item lowest;

        void push(int data) {
            Item newItem = new Item(data);

            if (isEmpty()) {
                top = newItem;
                lowest = newItem;
            } else if (newItem.data <= lowest.data)
                lowest = newItem;

            newItem.next = top;
            top = newItem;
            size++;
        }

        Item pop() {
            if (size == 0) throw new RuntimeException("Stack is empty!");

            size--;
            Item deleted = top;
            top = top.next;
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
                System.out.println(top.data);
                top = top.next;
                size--;
            }
            size = tempSize;
            top = temptop;
            System.out.println("--");
        }
    }

    static class AnimalShelter {
        List<String> animals = new LinkedList<>();

        void enqueue(String type) {
            animals.add(type);
        }

        String dequeue(String type) {
            String removed = "Selected: ";
            String animalType = "";
            for (String animal : animals) {
                if (animal.contains(type)){
                    removed += animal;
                    animalType = animal;
                    break;
                }
            }
            animals.remove(animalType);
            return removed;
        }

        public String selectSpecific(String type){
            if (type.equals("dog"))
                return dequeueDog();
            else if (type.equals("cat"))
                return dequeueCat();
            else
                throw new RuntimeException("No pets of this type available!");
        }

        String dequeueDog() {
            return dequeue("dog");
        }

        String dequeueCat() {
            return dequeue("cat");
        }
    }


    public static void main(String[] args) {

    }

    static void testStackMin() {
        Stacky<Integer> stack = new Stacky<>();

        stack.push(0);
        stack.push(3);
        stack.push(1);
        stack.push(5);
        stack.push(4);
        stack.push(10);

        stack.print();

        System.out.println(stack.min().data);
    }

    static void testAnimalShelter(){
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
