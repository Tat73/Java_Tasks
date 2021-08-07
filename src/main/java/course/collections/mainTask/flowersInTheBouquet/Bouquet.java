package course.collections.mainTask.flowersInTheBouquet;


import course.collections.mainTask.flowersInTheBouquet.accessory.Accessory;
import course.collections.mainTask.flowersInTheBouquet.accessory.AccessoryName;
import course.collections.mainTask.flowersInTheBouquet.flowers.Flower;
import course.collections.mainTask.flowersInTheBouquet.flowers.FlowerFreshness;
import course.collections.mainTask.flowersInTheBouquet.flowers.FlowerName;

import java.util.Arrays;
import java.util.List;

public class Bouquet {

    List<Flower> flowerList;
    List<Accessory> accessoryList;

    public Bouquet(List<Flower> flowerList, List<Accessory> accessoryList) {
        this.flowerList = flowerList;
        this.accessoryList = accessoryList;
    }

    public static List<Flower> createBouquet() {
        return Arrays.asList(
                new Flower(FlowerName.ROSE, FlowerFreshness.FRESH, 10.5, 3, 2.5),
                new Flower(FlowerName.PEONY, FlowerFreshness.FRESH, 15, 3, 1.5),
                new Flower(FlowerName.GOLDEN_DAISY, FlowerFreshness.CUT_YESTERDAY, 7, 7, 1.0),
                new Flower(FlowerName.ANEMONE, FlowerFreshness.FRESH, 5, 5, 1.0),
                new Flower(FlowerName.ROSE, FlowerFreshness.CUT_YESTERDAY, 13, 2, 2.0)
        );
    }

    public static List<Accessory> addAccessoryToBouquet() {
        return Arrays.asList(
                new Accessory(AccessoryName.PAPER, 1, 4.0),
                new Accessory(AccessoryName.RIBBON, 2, 0.75)
        );
    }

    public static double sumOfBouquet(List<Flower> flowerList, List<Accessory> accessoryList) {
        double summaryOfFlowers = 0;
        double summaryOfAccessories = 0;
        for (Flower flower : flowerList) {
            summaryOfFlowers += flower.getFlowerQuantity() * flower.getFlowerOnePiecePrice();
        }
        for (Accessory accessory : accessoryList) {
            summaryOfAccessories += accessory.getAccessoryQuantity() * accessory.getAccessoryPriceForOnePiece();
        }

        return summaryOfFlowers + summaryOfAccessories;
    }

    public static void flowerStalkLengthFilter(List<Flower> bouquet, double fromThisLength, double toThisLength) {
        for (Flower flower : bouquet) {
            if (flower.getFlowerStalkLength() >= fromThisLength &&
                    flower.getFlowerStalkLength() <= toThisLength) {
                System.out.println(flower);
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
