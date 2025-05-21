package Task3;

import java.time.Year;

public class Person {
    private final String name;
    private final int birthDate;

    public Person(String name, int birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public Person(String name) {
        this(name, 1990);
    }

    public String returnName() {
        return name;
    }

    public int returnAge() {
        int currentYear = Year.now().getValue();
        return currentYear - birthDate;
    }

    public static Person getOlderPerson(Person a, Person b) {
        return (a.returnAge() > b.returnAge()) ? a : b;
    }

    public static Person getOldestPerson(Person[] a) {
        Person oldestPerson = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i].returnAge() > oldestPerson.returnAge()) {
                oldestPerson = a[i];
            }

        } return oldestPerson;
    }
}

