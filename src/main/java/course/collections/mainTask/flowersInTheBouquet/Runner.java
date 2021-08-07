package course.collections.mainTask.flowersInTheBouquet;

import course.collections.mainTask.flowersInTheBouquet.flowers.FlowerFreshness;

import static course.collections.mainTask.flowersInTheBouquet.Bouquet.*;

public class Runner {
    public static void main(String[] args) {
        Bouquet bouquet = new Bouquet(createBouquet(), addAccessoryToBouquet());

        System.out.println("Bouquet: " + "\n" + bouquet.flowerList + "\n" + bouquet.accessoryList);
        System.out.println();
        System.out.println("Total price of bouquet is: " + sumOfBouquet(bouquet.flowerList, bouquet.accessoryList));
        System.out.println("\n" + "Filter flowers with stalk length diapason: ");
        flowerStalkLengthFilter(bouquet.flowerList, 4.0, 9.0);
        System.out.println("\n" + "Filter flowers with freshness level: ");
        flowerFreshFilter(bouquet.flowerList, String.valueOf(FlowerFreshness.FRESH));
    }
}
