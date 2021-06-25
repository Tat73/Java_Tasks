package course.collections.mainTask.flowersInTheBouquet.flowers;

public class Flower{
    private FlowerName name;
    private double flowerStalkLength;
    private String freshLevel;
    private int flowerQuantity;
    private double onePiecePrice;
    private Accessory accessory;
    private int accessoryQuantity;
    private double accessoryOnePiecePrice;

    public Flower(FlowerName name, double flowerStalkLength, String freshLevel,
                  int flowerQuantity, double onePiecePrice) {
        this.name = name;
        this.flowerStalkLength = flowerStalkLength;
        this.freshLevel = freshLevel;
        this.flowerQuantity = flowerQuantity;
        this.onePiecePrice = onePiecePrice;
    }

    public Flower(Accessory accessory, int accessoryQuantity, double accessoryOnePiecePrice) {
        this.accessory = accessory;
        this.accessoryQuantity = accessoryQuantity;
        this.accessoryOnePiecePrice = accessoryOnePiecePrice;
    }

    public int getAccessoryQuantity() {
        return accessoryQuantity;
    }

    public void setAccessoryQuantity(int accessoryQuantity) {
        this.accessoryQuantity = accessoryQuantity;
    }

    public double getAccessoryOnePiecePrice() {
        return accessoryOnePiecePrice;
    }

    public void setAccessoryOnePiecePrice(double accessoryOnePiecePrice) {
        this.accessoryOnePiecePrice = accessoryOnePiecePrice;
    }

    public Accessory getAccessory() {
        return accessory;
    }

    public void setAccessory(Accessory accessory) {
        this.accessory = accessory;
    }

    public FlowerName getName() {
        return name;
    }

    public void setName(FlowerName name) {
        this.name = name;
    }

    public double getFlowerStalkLength() {
        return flowerStalkLength;
    }

    public void setFlowerStalkLength(double flowerStalkLength) {
        this.flowerStalkLength = flowerStalkLength;
    }

    public String getFreshLevel() {
        return freshLevel;
    }

    public void setFreshLevel(String freshLevel) {
        this.freshLevel = freshLevel;
    }

    public int getFlowerQuantity() {
        return flowerQuantity;
    }

    public void setFlowerQuantity(int flowerQuantity) {
        this.flowerQuantity = flowerQuantity;
    }

    public double getOnePiecePrice() {
        return onePiecePrice;
    }

    public void setOnePiecePrice(double onePiecePrice) {
        this.onePiecePrice = onePiecePrice;
    }

    @Override
    public String toString() {
        return "Flower{" +
                "name=" + name +
                ", flowerStalkLength=" + flowerStalkLength +
                ", freshLevel='" + freshLevel + '\'' +
                ", flowerQuantity=" + flowerQuantity +
                ", onePiecePrice=" + onePiecePrice +
                ", accessory=" + accessory +
                ", accessoryQuantity=" + accessoryQuantity +
                ", accessoryOnePiecePrice=" + accessoryOnePiecePrice +
                '}';
    }
}
