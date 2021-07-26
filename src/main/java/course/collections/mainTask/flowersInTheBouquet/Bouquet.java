package course.collections.mainTask.flowersInTheBouquet;


import course.collections.mainTask.flowersInTheBouquet.accessory.Accessory;
import course.collections.mainTask.flowersInTheBouquet.flowers.Flower;

import java.util.List;

public class Bouquet {

    public static double sumOfBouquet(List<Flower> bouquet, List<Accessory> accessories) {
        double summaryOfFlowers = 0;
        double summaryOfAccessories = 0;
        for (Flower flower : bouquet) {
            summaryOfFlowers += flower.getFlowerQuantity() * flower.getFlowerOnePiecePrice();
        }
        for (Accessory accessory : accessories) {
            summaryOfAccessories += accessory.getAccessoryQuantity() * accessory.getAccessoryPriceForOnePiece();
        }

        return summaryOfFlowers + summaryOfAccessories;
    }

    public static void flowerStalkLengthFilter(List<Flower> bouquet, double fromThisLength, double toThisLength) {
        for (Flower flower : bouquet) {
            if (flower.getFlowerStalkLength() >= fromThisLength &&
                    flower.getFlowerStalkLength() <= toThisLength) {
                System.out.println("Flower stalk length has next flowers: " + flower);
            }

        }
    }

    public static void flowerFreshFilter(List<Flower> bouquet, String flowerFreshness) {
        for (Flower flower : bouquet) {
            if (flowerFreshness.equalsIgnoreCase(String.valueOf(flower.getFlowerFreshLevel()))) {
                System.out.println(flower);
            }
        }
    }

}
