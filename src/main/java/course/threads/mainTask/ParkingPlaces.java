package course.threads.mainTask;

import java.util.ArrayList;
import java.util.List;

public class ParkingPlaces {
    private final List<Car> parkingPlaces;
    private static final int maxCarsInParking = 5;
    private int carsCounter = 0;

    public ParkingPlaces() {
        parkingPlaces = new ArrayList<>();
    }

    public synchronized void add(Car element) {
        if (carsCounter < maxCarsInParking) {
            notifyAll();
            parkingPlaces.add(element);
            System.out.println(element.getCarName() + " " + "Car is parked");
            carsCounter++;
            int freeParkingPlaces = maxCarsInParking - carsCounter;
            System.out.println("Free parking places" + " " + freeParkingPlaces);
        } else {
            System.out.println(element.getCarName() + " " + "Parking is full");

        }
    }

}
