public class Main {
    public static void main(String[] args) {
        Thread pingThread = new Thread(new MyThread("ping", 0));
        Thread pongThread = new Thread(new MyThread("pong", 500));

        pingThread.start();
        pongThread.start();
    }
}