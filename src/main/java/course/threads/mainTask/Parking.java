package course.threads.mainTask;


import java.util.Random;

public class Parking implements Runnable {
    private final ParkingPlaces parkingPlaces;
    private final int carCount;

    public Parking(ParkingPlaces parkingPlaces, int carCount) {
        this.parkingPlaces = parkingPlaces;
        this.carCount = carCount;
    }

    @Override
    public void run() {
        int count = 0;
        while (count < carCount) {
            count++;
            parkingPlaces.add(new Car(getRandomCarName()));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    private CarName getRandomCarName() {
        return CarName.values()[new Random().nextInt(CarName.values().length)];
    }
}
