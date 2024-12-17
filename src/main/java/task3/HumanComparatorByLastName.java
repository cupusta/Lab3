package task3;

import java.util.Comparator;

public class HumanComparatorByLastName implements Comparator<Human> {
    public int compare(Human human1, Human human2) {
        return human1.surname.compareTo(human2.surname);
    }
}
