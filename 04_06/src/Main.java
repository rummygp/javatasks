import java.awt.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> znajomi = List.of(
                new Person("Jan", "Kowalski", "123-456-789"),
                new Person("Anna", "Nowak", "987-654-321"),
                new Person("Piotr", "Wiśniewski", "555-666-777")
        );

        List<Telephone> telefony = List.of(
                new Telephone("Analogowy", Color.BLACK),
                new CellPhone("GSM", Color.BLUE),
                new Smartphone("LTE", Color.RED, znajomi)
        );

        List<String> numery = List.of(
                "123-456-789", "111-222-333", "987-654-321", "444-555-666", "555-666-777",
                "777-888-999", "123-456-789", "222-333-444", "987-654-321", "666-777-888"
        );

        for (Telephone telefon : telefony) {
            for (int i = 0; i < 10; i++) {
                telefon.call(numery.get(i));
            }
        }

        for (Telephone telefon : telefony) {
            telefon.displayCallsHistory();
            System.out.println();
        }
    }
}