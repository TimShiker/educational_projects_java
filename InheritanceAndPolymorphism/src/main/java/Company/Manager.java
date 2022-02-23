package Company;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Manager implements Employee {

    private double monthSalary;
    private double amountEarnedMoney;
    private final double bonusPercentage = 5.0;
    private final double fixedSalary = 24_000.0;
    private Company company;

    public Manager() {
        amountEarnedMoney = calculatedAmountEarnedMoney();
    }

    public Manager(Company company) {
        this();
        this.company = company;
    }

    public double getAmountEarnedMoney() {
        return amountEarnedMoney;
    }

    private double calculatedAmountEarnedMoney() {

        int minAmountEarnedMoney = 115_000;
        int maxAmountEarnedMoney = 140_000;
        int difference = maxAmountEarnedMoney - minAmountEarnedMoney;

        double amountEarnedMoney = (Math.random() * (difference + 1)) + minAmountEarnedMoney;

        BigDecimal resultRounding = new BigDecimal(amountEarnedMoney);
        resultRounding = resultRounding.setScale(2, RoundingMode.DOWN);

        return resultRounding.doubleValue();
    }

    @Override
    public double getMonthSalary() {

        double calculatedMonthSalary = fixedSalary + getMoneyBonus(amountEarnedMoney, bonusPercentage);

        BigDecimal resultRounding = new BigDecimal(calculatedMonthSalary);
        resultRounding = resultRounding.setScale(2, RoundingMode.DOWN);
        monthSalary = resultRounding.doubleValue();

        return monthSalary;
    }

    @Override
    public double getIncomeEachEmployee() {
        return amountEarnedMoney;
    }

    private double getMoneyBonus(double amountEarnedMoney, double bonusPercentage) {

        return amountEarnedMoney * bonusPercentage / 100;
    }
}
