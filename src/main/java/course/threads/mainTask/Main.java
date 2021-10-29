package course.threads.mainTask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ParkingPlaces parkingPlaces = new ParkingPlaces();
        Parking parking = new Parking(parkingPlaces, 10);

        ExecutorService service = Executors.newSingleThreadExecutor();
        service.execute(parking);
        service.shutdown();

    }
}
