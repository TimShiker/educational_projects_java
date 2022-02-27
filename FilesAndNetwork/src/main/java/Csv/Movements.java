package Csv;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Movements {

    private final ArrayList<BankStatementEntry> bankStatementEntries;
    private final TreeMap<String, Double> expenseSumEachOrganisation;

    public Movements(String pathMovementsCsv) {

        bankStatementEntries = new ArrayList<>();
        expenseSumEachOrganisation = new TreeMap<>();
        Path pathCsv = Paths.get(pathMovementsCsv);
        parseCsv(pathCsv);
    }

    private void parseCsv(Path path) {

        try {
            List<String> movements = Files.readAllLines(path);

            for (int i = 1; i < movements.size(); i++) {

                String[] fragmentsMovement = movements.get(i).split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                if (fragmentsMovement.length != 8) {
                    System.out.println("This line was parsed with an error: " + movements.get(i));
                }

                double income = formatIncomeOrExpense(fragmentsMovement[6]);
                double expense = formatIncomeOrExpense(fragmentsMovement[7]);

                bankStatementEntries.add(new BankStatementEntry(formatOrganisation(fragmentsMovement[5]),
                        income, expense));

                calculatedExpenseSumEachOrganisation(formatOrganisation(fragmentsMovement[5]),
                        expense);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public double getExpenseSum() {

        return bankStatementEntries.stream().mapToDouble(BankStatementEntry::getExpense).sum();
    }

    public double getIncomeSum() {
        return bankStatementEntries.stream().mapToDouble(BankStatementEntry::getIncome).sum();
    }

    private double formatIncomeOrExpense(String num) {

        return Double.parseDouble(num.replaceAll("\"", "").replaceAll(",", "."));
    }

    private String formatOrganisation(String organisation) {

        String[] fragmentsOfOrganizations = organisation.split("    ");

        if (!organisation.contains("/")) {
            return fragmentsOfOrganizations[1].replaceAll("\\\\", " ").trim();
        } else {
            return fragmentsOfOrganizations[1].replaceAll("/", " ").trim();
        }
    }

    private void calculatedExpenseSumEachOrganisation(String organisation, double expense) {

        if (!expenseSumEachOrganisation.containsKey(organisation)) {
            expenseSumEachOrganisation.put(organisation, expense);
        } else {
            double sum = expenseSumEachOrganisation.get(organisation) + expense;
            expenseSumEachOrganisation.put(organisation, sum);
        }
    }

    public void getExpenseSumEachOrganisation() {

        System.out.println("Amounts of expenses by organizations: ");

        for (String name : expenseSumEachOrganisation.keySet()) {
            String value = expenseSumEachOrganisation.get(name).toString();
            System.out.println(name + " = " + value);
        }
    }
}
