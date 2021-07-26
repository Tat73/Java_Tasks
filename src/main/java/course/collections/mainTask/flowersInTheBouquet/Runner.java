package course.collections.mainTask.flowersInTheBouquet;

import course.collections.mainTask.flowersInTheBouquet.accessory.Accessory;
import course.collections.mainTask.flowersInTheBouquet.accessory.AccessoryName;
import course.collections.mainTask.flowersInTheBouquet.flowers.Flower;
import course.collections.mainTask.flowersInTheBouquet.flowers.FlowerFreshness;
import course.collections.mainTask.flowersInTheBouquet.flowers.FlowerName;

import java.util.Arrays;
import java.util.List;

import static course.collections.mainTask.flowersInTheBouquet.Bouquet.*;

public class Runner {
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

    public static void main(String[] args) {
        List<Flower> flowerList = createBouquet();
        List<Accessory> accessoryList = addAccessoryToBouquet();


        System.out.println("Total price of bouquet is: " + sumOfBouquet(flowerList, accessoryList));
        System.out.println("\n" + "Filter flowers with stalk length diapason: ");
        flowerStalkLengthFilter(flowerList, 4.0, 9.0);
        System.out.println("\n" + "Filter flowers with freshness level: ");
        flowerFreshFilter(flowerList, String.valueOf(FlowerFreshness.FRESH));
    }

}
