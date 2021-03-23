import java.util.concurrent.CyclicBarrier;

public abstract class Element extends Thread {
    @Override
    public void run(){
        System.out.println(Thread.currentThread());
    }
}
