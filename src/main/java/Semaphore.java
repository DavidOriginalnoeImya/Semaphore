import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.atomic.AtomicInteger;

public class Semaphore {
    private volatile int counter = 1000000;

    public void acquire(int delta) throws InterruptedException {
        while (counter <= 0) {
            Thread.yield();
        }

        changeCounterValue(-delta);

        while (counter < 0) {
            Thread.yield();
        }
    }

    public void release(int delta) throws InterruptedException {
        changeCounterValue(delta);
    }

    synchronized void changeCounterValue(int delta) {
        counter += delta;
    }
}
