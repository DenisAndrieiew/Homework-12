import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Oxygen extends Element{
   private final static CyclicBarrier BARRIER2 = new CyclicBarrier(1);
    @Override
    public void run() {
        System.out.println("Oxygen is ready");
        try {
            BARRIER2.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        releaseOxygen();
    }
    public static void releaseOxygen() {
        System.out.print("Oxygen released");

    }
}
