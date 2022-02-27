package Csv;

public class Main {

    public static String pathToFileCsv = "files/movementList.csv";

    public static void main(String[] args) {

        Movements movements = new Movements(pathToFileCsv);

        System.out.println("Amount of income: " + movements.getIncomeSum() + ".\n");
        System.out.println("Amount of expenses: " + movements.getExpenseSum() + ".\n");

        movements.getExpenseSumEachOrganisation();
    }
}
