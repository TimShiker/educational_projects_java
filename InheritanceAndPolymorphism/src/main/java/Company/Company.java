package Company;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Company {

    private List<Employee> allEmployees;
    private double income;

    public Company() {
        allEmployees = new ArrayList<>();
        income = 0.0;
    }

    public Company(List<Employee> employees) {
        this();
        hireAll(employees);
    }

    public Company(double income) {
        this();
        this.income += income;
    }

    public void hire(Employee employee) {

        if (employee != null && !allEmployees.contains(employee)) {
            allEmployees.add(employee);
        } else {
            System.out.println("Error. The employee you were planning to hire, " +
                    "is null or already hired by this company.");
        }
    }

    public void hireAll(List<Employee> addEmployeeList) {

        if (!addEmployeeList.isEmpty()) {
            for (Employee employee : addEmployeeList) {
                hire(employee);
            }
        } else {
            System.out.println("Error. The list of employees you planned to hire is empty.");
        }
    }

    public void fire(Employee employee) {
        if (employee != null && allEmployees.contains(employee)) {
            allEmployees.remove(employee);
        } else {
            System.out.println("Error. The employee you planned to fire is null " +
                    "or has already been fired from this company.");
        }
    }

    public double getIncome() {

        double sumIncomesEachEmployee = 0.0;

        for (Employee employee : allEmployees) {
            sumIncomesEachEmployee += employee.getIncomeEachEmployee();
        }

        BigDecimal resultRounding = new BigDecimal(sumIncomesEachEmployee);
        resultRounding = resultRounding.setScale(2, RoundingMode.HALF_DOWN);

        income = resultRounding.doubleValue();

        return income;
    }

    public List<Employee> getTopSalaryStaff(int count) {

        if (count < 0 || count > allEmployees.size()) {
            return new ArrayList<>();
        }

        List<Employee> copiedAllEmployees = new ArrayList<>();
        copiedAllEmployees.addAll(allEmployees);

        Collections.sort(copiedAllEmployees, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if (o1.getMonthSalary() > o2.getMonthSalary()) {
                    return -1;
                }
                if (o1.getMonthSalary() < o2.getMonthSalary()) {
                    return 1;
                }
                return 0;
            }
        });

        List<Employee> topSalaryStaff = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            topSalaryStaff.add(copiedAllEmployees.get(i));
        }

        return Collections.unmodifiableList(topSalaryStaff);
    }

    public List<Employee> getLowestSalaryStaff(int count) {

        if (count < 0 || count > allEmployees.size()) {
            return new ArrayList<>();
        }

        List<Employee> copiedAllEmployees = new ArrayList<>();
        copiedAllEmployees.addAll(allEmployees);

        Collections.sort(copiedAllEmployees, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if (o1.getMonthSalary() > o2.getMonthSalary()) {
                    return 1;
                }
                if (o1.getMonthSalary() < o2.getMonthSalary()) {
                    return -1;
                }
                return 0;
            }
        });

        List<Employee> lowestSalaryStaff = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lowestSalaryStaff.add(copiedAllEmployees.get(i));
        }

        return Collections.unmodifiableList(lowestSalaryStaff);
    }

    public List<Employee> getAllEmployees() {

        return Collections.unmodifiableList(allEmployees);
    }
}
