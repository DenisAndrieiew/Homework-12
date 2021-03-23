import java.util.concurrent.*;

public class Water {
    private static CyclicBarrier barrier = new CyclicBarrier(3,System.out::println);
    private static Semaphore semaphore = new Semaphore(3);
    private static final ExecutorService executor = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            executor.execute(new Hydrogen());
            executor.execute(new Oxygen());
            executor.execute(new Hydrogen());
        }

    }
public static class Hydrogen implements Runnable{
private Semaphore semaphoreH = new Semaphore(2);
        @Override
    public void run() {
            try {
                semaphoreH.acquire();
                semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            releaseHydrogen();
    }
    private void releaseHydrogen(){
        System.out.print("H");
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        semaphoreH.release();
        semaphore.release();
    }
}
    public static class Oxygen implements Runnable{
    private Semaphore semaphoreO = new Semaphore(1);
        @Override
        public void run() {
            try {
                semaphoreO.acquire();
                semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            releaseOxygen();
        }
        private void releaseOxygen(){

            System.out.print("O");
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            semaphoreO.release();
            semaphore.release();
        }
    }
}

