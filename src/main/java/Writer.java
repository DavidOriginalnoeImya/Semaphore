public class Writer implements Runnable {
    private Semaphore semaphore;
    private int id = 0;

    private int semaphoreValue = 1000000;

    public Writer(Semaphore semaphore, int id) {
        this.semaphore = semaphore;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire(semaphoreValue);
            System.out.println("Работает писатель № " + id);
            Thread.sleep(5000);
            System.out.println("Писатель № " + id + " завершает работу");
            semaphore.release(semaphoreValue);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
