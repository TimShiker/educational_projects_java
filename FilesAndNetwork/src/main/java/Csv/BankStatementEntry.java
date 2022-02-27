package Csv;

public class BankStatementEntry {

    private final String organisation;
    private final double income;
    private final double expense;

    public BankStatementEntry(String organisation, double income, double expense) {
        this.organisation = organisation;
        this.income = income;
        this.expense = expense;
    }

    public String getOrganisation() {
        return organisation;
    }

    public double getIncome() {
        return income;
    }

    public double getExpense() {
        return expense;
    }

    @Override
    public String toString() {
        return "Organisation: " + organisation + "\n" +
                "Income: " + income + "\n" +
                "Expense: " + expense + "\n";
    }
}
