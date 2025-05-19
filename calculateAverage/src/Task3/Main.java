package Task3;

public class Main {
    public static void main(String[] args) {
        Person adam = new Person("Adam", 1991);
        Person pawel = new Person("Pawel");
        Person jarek = new Person("Jarek", 2002);

        Person[] array = {adam, pawel, jarek};

        System.out.println(adam.returnName());
        System.out.println(pawel.returnName());
        System.out.println(adam.returnAge());
        System.out.println(pawel.returnAge());
        System.out.println(Person.getOlderPerson(adam, pawel).returnName());
        System.out.println(Person.getOldestPerson(array).returnName());

    }
}
