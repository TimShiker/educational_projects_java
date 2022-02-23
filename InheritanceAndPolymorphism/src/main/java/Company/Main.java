package Company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Company companyTest = new Company();

        // hire operators with method hire
        for (int i = 0; i < 180; i++) {
            companyTest.hire(new Operator());
        }

        // created List with managers and hire managers
        List<Employee> managers = new ArrayList<>();

        for (int i = 0; i < 80; i++) {
            managers.add(new Manager());
        }
        companyTest.hireAll(managers);

        // hire top managers
        for (int i = 0; i < 10; i++) {
            companyTest.hire(new TopManager(companyTest));
        }

        System.out.println("The company's income before layoffs is: " + (int) companyTest.getIncome() + " rub.");
        System.out.println("\nList of highest paid employees before leaving: ");
        int count = 1;
        for (Employee employee : companyTest.getTopSalaryStaff(20)) {
            System.out.println(employee.getMonthSalary() + " rub. Number: " + count + ".");
            count++;
        }

        System.out.println("\nList of the lowest paid employees before layoffs: ");
        count = 1;
        for (Employee employee : companyTest.getLowestSalaryStaff(30)) {
            System.out.println(employee.getMonthSalary() + " rub. Number: " + count);
            count++;
        }

        System.out.println("\nNumber of employees before layoffs: " + companyTest.getAllEmployees().size());

        // fire 135 employees
        for (int i = 0; i < 135; i++) {
            companyTest.fire(companyTest.getAllEmployees().get(i));
        }

        System.out.println("The company's income after termination is: " + companyTest.getIncome() + " rub.");
        System.out.println("Number of employees after leaving: " + companyTest.getAllEmployees().size());

        System.out.println("\nList of highest paid employees after leaving: ");
        count = 1;
        for (Employee employee : companyTest.getTopSalaryStaff(20)) {

            System.out.println(employee.getMonthSalary() + " " + count);
            count++;
        }

        System.out.println("\nList of the lowest paid employees after leaving: ");
        count = 1;
        for (Employee employee : companyTest.getLowestSalaryStaff(30)) {
            System.out.println(employee.getMonthSalary() + " " + count);
            count++;
        }
    }
}
