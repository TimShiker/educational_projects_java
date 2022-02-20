package PrinterAndBasket;

public class Basket {

    private String items;
    private int totalPrice = 0;
    private int limit;
    private double weight;

    private static double totalWeight = 0;
    private static int totalCountBaskets = 0;
    private static int totalCost = 0;
    private static int countProducts = 0;

    // created overload constructors
    public Basket() {
        increaseTotalCountBaskets(1);
        items = "List of products:";
        this.limit = 1000000;
    }

    public Basket(int limit) {
        this();
        this.limit = limit;
    }

    public Basket(String items, int totalPrice) {
        this();
        this.items = this.items + items;
        this.totalPrice = totalPrice;
    }

    // created overload methods 'add'
    public void add(String name, int price) {
        add(name, price, 1);
    }

    public void add(String name, int price, int count) {
        add(name, price, count, 0);
    }

    public void add(String name, int price, double weight) {
        add(name, price, 1, weight);
    }

    public void add(String name, int price, int count, double weight) {
        boolean error = contains(name);

        if (totalPrice + count * price >= limit) {
            error = true;
        }

        if (error) {
            System.out.println("Error occured :(");
            return;
        }

        items = items + "\n" + name + " - " +
                count + " p. - " + price;
        totalPrice = totalPrice + count * price;
        totalWeight = totalWeight + weight;
        increaseTotalCost(count, price);
        increaseCountProducts(count);
    }

    public void clear() {
        items = "";
        totalPrice = 0;
    }

    // created static methods
    public static int getTotalCountBaskets() {
        return totalCountBaskets;
    }

    private static void increaseTotalCountBaskets(int count) {
        Basket.totalCountBaskets = Basket.totalCountBaskets + count;
    }

    private static void increaseTotalCost(int count, int price) {
        Basket.totalCost = Basket.totalCost + count * price;
    }

    public static int getTotalCost() {
        return totalCost;
    }

    private static void increaseCountProducts(int countProducts) {
        Basket.countProducts = Basket.countProducts + countProducts;
    }

    public static int getCountProducts() {
        return countProducts;
    }

    public static double calculatedAveragePriceProduct(){
        return (double) totalCost / (double) countProducts;
    }

    public static double calculatedAveragePriceBasket(){
        return (double) totalCost / (double) totalCountBaskets;
    }

    public static double getTotalWeight() {
        return totalWeight;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public boolean contains(String name) {
        return items.contains(name);
    }

    public void print(String title) {
        System.out.println(title);
        if (items.isEmpty()) {
            System.out.println("PrinterAndBasket.Basket is empty");
        } else {
            System.out.println(items);
        }
    }
}
