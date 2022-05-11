public class Reader implements Runnable {
    private Semaphore semaphore;

    private int id = 0;

    private int semaphoreValue = 1;

    public Reader(Semaphore semaphore, int id) {
        this.semaphore = semaphore;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire(semaphoreValue);
            System.out.println("Работает читатель № " + id);
            Thread.sleep(1000);
            System.out.println("Читатель № " + id + " завершает работу");
            semaphore.release(semaphoreValue);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
