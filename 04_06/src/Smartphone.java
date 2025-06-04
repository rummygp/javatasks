import java.awt.*;
import java.util.List;
import java.util.Optional;

public class Smartphone extends CellPhone {
    protected List<Person> friends;

    public Smartphone(String communicationInterface, Color color, List<Person> friends) {
        super(communicationInterface, color);
        this.friends = friends;
    }

    @Override
    protected void displayCallsHistory() {
        System.out.println("Historia połączeń: ");
        callsHistory.stream()
                .map(number -> findByNumber(number)
                        .map(Record::toString)
                        .orElse(number))
                .forEach(System.out::println);
    }

    private Optional<Person> findByNumber(String number) {
        return friends.stream()
                .filter(person -> person.number().equals(number))
                .findFirst();
    }
}
