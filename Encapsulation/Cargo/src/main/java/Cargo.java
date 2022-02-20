public class Cargo {

    private final Dimensions dimensions;
    private final double weight;
    private final String deliveryAddress;
    private final boolean isFlipped;
    private final String registrationNumber;
    private final boolean isFragile;

    public Cargo(Dimensions dimensions, double weight, String deliveryAddress,
                 boolean isFlipped, String registrationNumber, boolean isFragile) {
        this.dimensions = dimensions;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.isFlipped = isFlipped;
        this.registrationNumber = registrationNumber;
        this.isFragile = isFragile;
    }

    // added methods for copying objects with immutable variables
    public Cargo setDeliveryAddress(String deliveryAddress){
        return new Cargo(dimensions, weight, deliveryAddress, isFlipped, registrationNumber, isFragile);
    }

    public Cargo setWeight(double weight){
        return new Cargo(dimensions, weight, deliveryAddress, isFlipped, registrationNumber, isFragile);
    }

    public Cargo setDimensions(Dimensions dimensions){
        return new Cargo(dimensions, weight, deliveryAddress, isFlipped, registrationNumber, isFragile);
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public double getWeight() {
        return weight;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public boolean isFlipped() {
        return isFlipped;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public boolean isFragile() {
        return isFragile;
    }

    public String toString() {
        return "Cargo dimensions: " + dimensions + "\n" +
                "Сargo weight, kg: " + weight + ".\n" +
                "Сargo weight: " + deliveryAddress + ".\n" +
                "Is it possible to flipp the cargo: " + isFlipped + ".\n" +
                "Registration number of cargo: " + registrationNumber + ".\n" +
                "Is the cargo fragile: " + isFragile + ".\n";
    }


}
