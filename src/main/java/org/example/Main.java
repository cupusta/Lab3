package org.example;

import java.util.*;

import task2.*;
import task3.*;


public class Main {
    public static void main(String[] args) {

        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        // Задание 1А
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = rand.nextInt(100);
        }

        System.out.println("Task 1A");

        for (int i : array) {
            System.out.print(i + " ");
        }

        System.out.println();

        // Задание 1B

        List<Integer> list = new ArrayList<>();
        for (int i : array) {
            list.add(i);
        }
        System.out.println("Task 1B");
        System.out.println(list);

        // Задание 1C

        Collections.sort(list);
        System.out.println("Task 1C");
        System.out.println(list);

        // Задание 1D

        Collections.reverse(list);
        System.out.println("Task 1D");
        System.out.println(list);

        // Задание 1E

        Collections.shuffle(list);
        System.out.println("Task 1E");
        System.out.println(list);

        // Задание 1F

        for (int i = 1; i < list.size(); i++) {
            int j = i - 1;
            Collections.swap(list, i, j);

        }
        System.out.println("Task 1F");
        System.out.println(list);

        // Задание 1G
        List<Integer> list1;
        list1 = list;
        for (int i = 0; i < list1.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).equals(list.get(j))) {
                    list1.remove(j);
                    j--;
                }
            }
        }
        System.out.println("Task 1G");
        System.out.println(list1);

        // Задание 1H

        for (int i = 0; i < list.size(); i++) {
            int count = 0;
            for (Integer integer : list)
                if (Objects.equals(list.get(i), integer)) {
                    count++;
                }
            if (count < 2) {
                list.remove(i);
                i--;
            }
        }
        System.out.println("Task 1H");
        System.out.println(list);

        // Задание 1I

        int[] listToArray = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            listToArray[i] = list.get(i);
        }
        System.out.println("Task 1I");
        for (int value : listToArray) {
            System.out.print(value + " ");
        }
        System.out.println();
        // Задание 1J

        System.out.println("Task 1J");
        for (int k : listToArray) {
            int count = 0;
            for (int j : listToArray) {
                if (k == j) {
                    count++;
                }
            }
            System.out.println(k + " - " + count);
        }
        //Задание 2

        PrimesGeneratorTest test = new PrimesGeneratorTest();
        System.out.println("Task 2");
        test.runTest(15);

        //Задание 3

        List<Human> humans = new ArrayList<>();
        humans.add(new Human("Max", "Verstappen", 27));
        humans.add(new Human("Lando", "Norris", 24));
        humans.add(new Human("Danial", "Riccardo", 35));
        System.out.println("Task 3");
        humans.sort(new HumanComparatorByLastName());
        for (Human human : humans) {
            System.out.println(human);
        }

        // Задание 3A
        HashSet<Human> humanSet = new HashSet<>(humans);
        System.out.println("Task 3A");
        System.out.println(humanSet);

        // Задание 3B

        LinkedHashSet<Human> linkedHashSet = new LinkedHashSet<>(humans);
        System.out.println("Task 3B");
        System.out.println(linkedHashSet);

        // Задание 3C
        TreeSet<Human> treeSet = new TreeSet<>(humans);
        System.out.println("Task 3C");
        System.out.println(treeSet);

        // Задание 3D
        TreeSet<Human> treeSetByLastName = new TreeSet<Human>(new HumanComparatorByLastName());
        treeSetByLastName.addAll(humans);
        System.out.println("Task 3D");
        System.out.println(treeSetByLastName);

        // Задание 3E
        TreeSet<Human> treeSetByAge = new TreeSet<Human>(new Comparator<Human>() {
            public int compare(Human human1, Human human2) {
                return Integer.compare(human1.age, human2.age);
            }
        });

        treeSetByAge.addAll(humans);
        System.out.println("Task 3E");
        System.out.println(treeSetByAge);
        // Задание 3f

        // HashSet и LinkedHashSet не выполняют сортировку элементов, но удаляют дубликаты.
        // При этом они хранят элементы по-разному, поэтому порядок хранения не гарантирован.
        // TreeSet, напротив, всегда сортирует элементы и удаляет дубликаты в соответствии с порядком.

        // Задание 4

        Map<String, Integer> count = new HashMap<>();
        StringBuilder word = new StringBuilder();
        String text = "The are a few words code, program, code, IT";
        text=text.toLowerCase();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isLetter(c)) {
                word.append(c);
            } else {
                if (!word.isEmpty()) {
                    String currentWord = word.toString();
                    if (count.containsKey(currentWord)) {
                        count.put(currentWord, count.get(currentWord) + 1);
                    } else {
                        count.put(currentWord, 1);
                    }
                    word.setLength(0);
                }
            }
        }
        System.out.println("Task 4");
        System.out.println(count);

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "two");
        map.put(2, "three");
        map.put(3, "one");

        Map<String, Integer> invertedMap = invertMap(map);

        for (Map.Entry<String, Integer> entry : invertedMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", value: " + entry.getValue());
        }

    }

    public static <K, V> Map<V, K> invertMap(Map<K, V> originalMap) {

        Map<V, K> invertedMap = new HashMap<>();

        for (Map.Entry<K, V> entry : originalMap.entrySet()) {
            invertedMap.put(entry.getValue(), entry.getKey());
        }

        return invertedMap;
    }
}
