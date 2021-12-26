package Week11;

import java.util.Comparator;

public class Person implements Comparable<Person> {
    public static Comparator<Person> NAMEORDER = new ByName();
    public static Comparator<Person> AGEORDER = new ByAge();
    private String name;
    private int age;
    private String address;

    public Person() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private static class ByName implements Comparator<Person> {
        @Override
        public int compare(Person o1, Person o2) {
            return o1.name.compareTo(o2.name);
        }
    }

    private static class ByAge implements Comparator<Person> {
        @Override
        public int compare(Person o1, Person o2) {
            return o1.age - o2.age;
        }
    }

    @Override
    public int compareTo(Person o) {
        return Person.NAMEORDER.compare(this, o) != 0
            ? Person.NAMEORDER.compare(this, o) : Person.AGEORDER.compare(this, o);
    }
}
