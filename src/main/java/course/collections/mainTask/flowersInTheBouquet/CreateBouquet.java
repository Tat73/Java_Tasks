package course.collections.mainTask.flowersInTheBouquet;

import course.collections.mainTask.flowersInTheBouquet.flowers.Accessory;
import course.collections.mainTask.flowersInTheBouquet.flowers.Flower;
import course.collections.mainTask.flowersInTheBouquet.flowers.FlowerName;

import java.util.*;

public class CreateBouquet {


    public static void main(String[] args) {
        List<Flower> bouquet = createBouquet();

        sumOfBouquet(bouquet);
        flowerStalkLengthSort(bouquet);
        flowerFreshSort(bouquet);

    }
    public static List<Flower> createBouquet() {

        return Arrays.asList(
                new Flower(FlowerName.ROSE, 10.5, "fresh", 3, 2.0),
                new Flower(FlowerName.PEONY, 15, "fresh", 3, 1.5),
                new Flower(FlowerName.GOLDEN_DAISY, 7, "cut yesterday", 7, 1.0),
                new Flower(FlowerName.ANEMONE, 8, "fresh", 5, 1.0),
                new Flower(FlowerName.ROSE, 13, "cut yesterday", 2, 2.0),
                new Flower(Accessory.RIBBON, 2, 0.3)

         );
    }

    public static void sumOfBouquet(List<Flower> bouquet){
        double summary = 0;
        for (Flower flower : bouquet) {
           summary += flower.getFlowerQuantity() * flower.getOnePiecePrice();
           summary += flower.getAccessoryQuantity() * flower.getAccessoryOnePiecePrice();
        }
        System.out.println("Our bouquet is: " + bouquet + "\n");
        System.out.println("Total price of bouquet is: " + summary);
    }

    public static void flowerStalkLengthSort(List<Flower> bouquet){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entry stalk length range for sorting: ");
        double fromThisLength = scanner.nextDouble();
        double toThisLength = scanner.nextDouble();
        for (Flower flower : bouquet){
            if(flower.getFlowerStalkLength() >= fromThisLength &&
                    flower.getFlowerStalkLength() <= toThisLength){
                System.out.println(flower);
            }

        }
    }

    public static void flowerFreshSort(List<Flower> bouquet){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entry fresh lever for sorting: 'fresh' or 'cut yesterday'" );
        String flowerFreshness = scanner.nextLine();
        for (Flower flower : bouquet){
            if(flowerFreshness.equals(flower.getFreshLevel())){
                System.out.println(flower);
            }
        }
    }



}




