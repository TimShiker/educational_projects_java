package Company;

public class TopManager implements Employee {

    private final double fixedSalary = 100_000.0;
    private final double bonusPercentage = 150.0;
    private Company company;

    public TopManager(Company company) {
        this.company = company;
    }

    @Override
    public double getMonthSalary() {

        if (company.getIncome() > 10_000_000) {
            return fixedSalary + getMoneyBonus(fixedSalary, bonusPercentage);
        }
        return fixedSalary;
    }

    @Override
    public double getIncomeEachEmployee() {
        return 0;
    }

    private double getMoneyBonus(double fixedSalary, double bonusPercentage) {

        return fixedSalary * bonusPercentage / 100;
    }

}
