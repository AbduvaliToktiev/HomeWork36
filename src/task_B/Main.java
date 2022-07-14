package task_B;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        LinkedList<Animal> animals = new LinkedList<>();
        for (int i = 1; i <= 50; i++) {
            Animal cat = new Animal(i, "cat" + i, "cat");
            Animal dog = new Animal(i, "dog" + i, "dog");
            animals.add(cat);
            animals.add(dog);
            deleteFivesCat(animals);
            // addMouse(animals);
            //   getNeigborCatAndMouse(animals);
            massDog(animals);
            sumAnimals(animals);
            allocateAnimal(animals);
        }
    }

    public static void deleteFivesCat(LinkedList<Animal> animals) {
        LinkedList<Animal> deletableAnimals = new LinkedList<>();
        for (int i = 0; i < animals.size(); i++) {
            Animal cat = animals.get(i);
            if (animals.get(i).getAge() % 5 == 0 && animals.get(i).getType().equals("cat")) {
                deletableAnimals.add(animals.get(i));
            }
        }
        animals.removeAll(deletableAnimals);
    }

    public static void addMouse(LinkedList<Animal> animals) {
        for (int i = 0; i < animals.size(); i++) {
            Animal dog = animals.get(i);
            if (dog.getAge() % 3 == 0 && dog.getType().equals("dog")) {
                Animal mouse = new Animal(i, "mouse" + i, "mouse");
                animals.add(i + 1, mouse);

            }
        }
    }

    public static LinkedList<Animal> getNeigborCatAndMouse(LinkedList<Animal> animals) {
        LinkedList<Animal> newList = new LinkedList<>();
        for (int i = 0; i < animals.size(); i++) {
            ListIterator<Animal> animalsIterator = animals.listIterator();
            if (animalsIterator.hasNext()) {
                if (animalsIterator.next().getType().equals("cat")
                        || animalsIterator.next().getType().equals("mouse")) {
                    if (animalsIterator.next().equals("cat")
                            && animals.get(animalsIterator.nextIndex()).getType().equals("mouse")) {
                        newList.add(animalsIterator.next());
                        newList.add(animals.get(animalsIterator.nextIndex()));
                    }
                    if (animalsIterator.next().equals("mouse")
                            && animals.get(animalsIterator.nextIndex()).getType().equals("cat")) {
                        newList.add(animalsIterator.next());
                        newList.add(animals.get(animalsIterator.nextIndex()));
                    }
                }
            }
        }
        return newList;
    }

    public static void massDog(LinkedList<Animal> animals) {
        for (int i = 0; i < animals.size(); i++) {
            Animal dog = animals.get(i);
            if (dog.getAge() % 3 == 0 && dog.getType().equals("dog")) {
                Animal mouse = new Animal(i, "mouse" + i, "mouse");
                animals.add(i + 1, mouse);
                List<Animal> animalList = new ArrayList<>(animals);
                for (Animal dog2 : animalList) {
                    System.out.println(dog2);
                }
            }
        }
    }

    public static void sumAnimals(LinkedList<Animal> animals) {
        int counterCat = 0;
        int counterDog = 0;
        int counterMouse = 0;
        int sumCat = 0;
        int sumDog = 0;
        int sumMouse = 0;
        for (Animal animal : animals) {
            if (animal.getType().equals("cat")) {
                counterCat++;
            } else if (animal.getType().equals("dog")) {
                counterDog++;
            } else if (animal.getType().equals("mouse")) {
                counterMouse++;
            }
            sumCat = sumCat + counterCat;
            sumDog = sumDog + counterDog;
            sumMouse = sumMouse + counterMouse;
        }
        System.out.println("Сумма всех котов равна: " + sumCat);
        System.out.println("Сумма всех собак равна: " + sumDog);
        System.out.println("Сумма всех мышей равна: " + sumMouse);
    }

    public static void allocateAnimal(LinkedList<Animal> animals) {
        animals.addFirst(animals.get(0));
        animals.add(animals.get(1));
        animals.addLast(animals.get(1));
        System.out.println(animals);
    }
}
