public class Main {

    public static void main(String[] args) {

        /*
            Example for class Basket
         */

        Basket basketFirst = new Basket();

        //work with overloading methods
        basketFirst.add("Banana", 40, 9.4);
        basketFirst.add("Apple", 30, 45);
        basketFirst.add("Milk", 20);

        basketFirst.print("My first basket");

        //work with static methods
        System.out.println("\nTotal count of baskets is: " + Basket.getTotalCountBaskets() +
                "\nTotal cost is: " + Basket.getTotalCost());

        //work with overloading constructor
        Basket basketSecond = new Basket("My", 100000);
        basketSecond.add("Bread", 22, 50);
        basketSecond.add("Salt", 4, 30);

        basketFirst.print("My second basket");

        System.out.println("\nTotal count of baskets is: " + Basket.getTotalCountBaskets() +
                "\nTotal cost is: " + Basket.getTotalCost());

        /*
         Example for class Printer
         */

        Printer printerFirst = new Printer();

        //work with overloading methods
        printerFirst.append("Hello, this first document for print", "First document", 5);
        printerFirst.append("Second document", 23);

        printerFirst.print("First print.");

        //work with static methods
        System.out.println("Total count of print documents and pages is: "
                + Printer.getTotalPrintDocumentsAndPages());

        printerFirst.clear();

        printerFirst.append("Hello, this first document for second print", "Third document", 3);
        printerFirst.append("Fourth document", 2);
        printerFirst.print("Second print.");

        System.out.println("Total count of print documents and pages is: "
                + Printer.getTotalPrintDocumentsAndPages() + ".");

    }
}
