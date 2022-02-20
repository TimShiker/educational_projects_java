public class Main {

    public static void main(String[] args) {

        // Example first cargo
        Dimensions dimensionsFirst = new Dimensions(12, 38, 59);
        Cargo cargo = new Cargo(dimensionsFirst, 345, "Back street, 5", true, "0001", false);

        System.out.println("Volume of cargo: " + cargo.getDimensions().calculatedVolume());

        // Example second cargo
        Dimensions dimensionsSecond = new Dimensions(10, 30, 50);
        Cargo cargo2 = cargo.setDimensions(dimensionsSecond).setDeliveryAddress("Summer bulvar, 15").setWeight(900);

        // tested method 'toString'
        System.out.println(cargo);
        System.out.println(cargo2);

    }
}
