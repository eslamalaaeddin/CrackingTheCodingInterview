package StacksAndQueues;

import java.util.LinkedList;
import java.util.List;

 class AnimalShelter {
    private final List<String> animals = new LinkedList<>();

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
