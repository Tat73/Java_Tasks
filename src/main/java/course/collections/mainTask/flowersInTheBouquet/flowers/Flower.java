package course.collections.mainTask.flowersInTheBouquet.flowers;

public class Flower {
    private FlowerName name;
    private FlowerFreshness flowerFreshLevel;
    private double flowerStalkLength;
    private int flowerQuantity;
    private double flowerOnePiecePrice;

    public Flower(FlowerName name, FlowerFreshness flowerFreshLevel, double flowerStalkLength, int flowerQuantity,
                  double flowerOnePiecePrice) {
        this.name = name;
        this.flowerFreshLevel = flowerFreshLevel;
        this.flowerStalkLength = flowerStalkLength;
        this.flowerQuantity = flowerQuantity;
        this.flowerOnePiecePrice = flowerOnePiecePrice;
    }

    public FlowerName getName() {
        return name;
    }

    public void setName(FlowerName name) {
        this.name = name;
    }

    public FlowerFreshness getFlowerFreshLevel() {
        return flowerFreshLevel;
    }

    public void setFlowerFreshLevel(FlowerFreshness flowerFreshLevel) {
        this.flowerFreshLevel = flowerFreshLevel;
    }

    public double getFlowerStalkLength() {
        return flowerStalkLength;
    }

    public void setFlowerStalkLength(double flowerStalkLength) {
        this.flowerStalkLength = flowerStalkLength;
    }

    public int getFlowerQuantity() {
        return flowerQuantity;
    }

    public void setFlowerQuantity(int flowerQuantity) {
        this.flowerQuantity = flowerQuantity;
    }

    public double getFlowerOnePiecePrice() {
        return flowerOnePiecePrice;
    }

    public void setFlowerOnePiecePrice(double flowerOnePiecePrice) {
        this.flowerOnePiecePrice = flowerOnePiecePrice;
    }

    @Override
    public String toString() {
        return "Flower{" +
                "name=" + name +
                ", flowerFreshLevel=" + flowerFreshLevel +
                ", flowerStalkLength=" + flowerStalkLength +
                ", flowerQuantity=" + flowerQuantity +
                ", flowerOnePiecePrice=" + flowerOnePiecePrice +
                '}';
    }
}
