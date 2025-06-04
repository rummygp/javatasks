import java.awt.*;

public class Telephone {
    protected String communicationInterface;
    protected Color color;

    public Telephone(String communicationInterface, Color color) {
        this.communicationInterface = communicationInterface;
        this.color = color;
    }

    public void call(String number) {
        System.out.println("Calling to: " + number);
    }

    protected void displayCallsHistory () {
        System.out.println("brak historii");
    }
}
