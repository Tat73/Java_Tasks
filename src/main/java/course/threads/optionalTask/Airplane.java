package course.threads.optionalTask;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Airplane extends Thread{
    private final Semaphore sem;
    private boolean full = false;
    private final String plane;

    public Airplane(Semaphore sem, String plane) {
        this.sem = sem;
        this.plane = plane;
    }
    public void run(){
        try{
            if(!full){
                sem.acquire();
                System.out.println(Thread.currentThread().getName() + " " + plane + " " + "Is going to the runway");
                System.out.println(Thread.currentThread().getName() + " " + plane + " " + "Took off");
                System.out.println(Thread.currentThread().getName() + " " + plane + " " +  "The runway accepted that plane");
                TimeUnit.SECONDS.sleep(3);
                full = true;
                System.out.println(Thread.currentThread().getName() + " " + plane + " " +  "The Runway after this plane is free");
                sem.release();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
