import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CellPhone extends Telephone {
    protected final List<String> callsHistory;

    public CellPhone(String communicationInterface, Color color) {
        super(communicationInterface, color);
        this.callsHistory = new ArrayList<>();
    }

    @Override
    public void call(String number) {
        super.call(number);
        if (callsHistory.size() >= 10) {
            callsHistory.removeFirst();
        }
        callsHistory.add(number);
    }

    @Override
    protected void displayCallsHistory() {
        System.out.println("Historia połączeń: " + callsHistory);
    }
}
