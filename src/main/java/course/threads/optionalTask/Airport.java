package course.threads.optionalTask;

import java.util.concurrent.Semaphore;

public class Airport {
    public static void main(String[] args) {
        Semaphore sem = new Semaphore(5);
        for (int i = 0; i < 10; i++) {
        new Airplane( sem, "Plane" + i).start();
        }
    }
}
