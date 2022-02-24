package Company;

public class Operator implements Employee {

    // value of fixed salary take from task
    private final double fixedSalary = 30_000.0;

    public Operator() {
    }

    @Override
    public double getMonthSalary() {
        return fixedSalary;
    }

    @Override
    public double getIncomeEachEmployee() {
        return 0;
    }

}
