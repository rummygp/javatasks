import static java.lang.Thread.sleep;

public class MyThread implements Runnable{
    private final String message;
    private final int delayTime;

    public MyThread(String message, int delayTime) {
        this.message = message;
        this.delayTime = delayTime;
    }

    @Override
    public void run() {
        try{
            sleep(delayTime);
            for (int i = 0; i < 10; i++) {
                System.out.println(message);
                sleep(1000);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
