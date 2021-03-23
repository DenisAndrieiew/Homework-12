import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Hydrogen extends Element{
   private static final CyclicBarrier BARRIER1 = new CyclicBarrier(2, ()-> Oxygen.releaseOxygen());
    @Override
    public void run() {
        System.out.println("Hydrogen is ready");
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            BARRIER1.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
releaseHydrogen();

    }
    public static void releaseHydrogen(){
        System.out.print("Hydrogen is released");

    }
}
