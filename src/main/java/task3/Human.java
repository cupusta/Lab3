package task3;

public class Human implements Comparable<Human> {
    public final String name;
    public final String surname;
    public final int age;
    public Human(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }
    @Override
    public int compareTo(Human human) {
        return this.name.compareTo(human.name);
    }

    @Override
    public String toString() {
        return "Name = " + name + ", Surname = " + surname + ", age = " + age;
    }
}

