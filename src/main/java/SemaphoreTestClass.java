public class SemaphoreTestClass {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore();

        Thread thread;

        int readerId = 0, writerId = 0;

        for (int index = 1; index <= 10; ++index) {
            if (index != 6) {
                thread = new Thread(new Reader(semaphore, ++readerId));
            }
            else {
                thread = new Thread(new Writer(semaphore, ++writerId));
            }
            thread.start();
        }
    }
}
