package course.collections.mainTask.flowersInTheBouquet.accessory;

public class Accessory {
    private AccessoryName accessoryName;
    private int accessoryQuantity;
    private double accessoryPriceForOnePiece;

    public Accessory(AccessoryName accessoryName, int accessoryQuantity, double accessoryPriceForOnePiece) {
        this.accessoryName = accessoryName;
        this.accessoryQuantity = accessoryQuantity;
        this.accessoryPriceForOnePiece = accessoryPriceForOnePiece;
    }

    public AccessoryName getAccessoryName() {
        return accessoryName;
    }

    public void setAccessoryName(AccessoryName accessoryName) {
        this.accessoryName = accessoryName;
    }

    public int getAccessoryQuantity() {
        return accessoryQuantity;
    }

    public void setAccessoryQuantity(int accessoryQuantity) {
        this.accessoryQuantity = accessoryQuantity;
    }

    public double getAccessoryPriceForOnePiece() {
        return accessoryPriceForOnePiece;
    }

    public void setAccessoryPriceForOnePiece(double accessoryPriceForOnePiece) {
        this.accessoryPriceForOnePiece = accessoryPriceForOnePiece;
    }

    @Override
    public String toString() {
        return "Accessory{" +
                "accessoryName=" + accessoryName +
                ", accessoryQuantity=" + accessoryQuantity +
                ", accessoryPriceForOnePiece=" + accessoryPriceForOnePiece +
                '}';
    }
}
