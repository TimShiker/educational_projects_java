package LambdaExpressions;

import java.util.List;

public class Main {

    public static final String STAFF_TXT = "C:\\Users\\timpa\\Documents\\GitHub\\educational_projects_java" +
            "\\AdvancedOOPFeatures\\data\\staff.txt";

    public static void main(String[] args) {
        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);
        sortBySalaryAndAlphabet(staff);

        System.out.println("Sorted list: ");
        staff.forEach(System.out::println);

    }

    // method to sort list by salary and alphabet
    public static void sortBySalaryAndAlphabet(List<Employee> staff) {

        staff.sort((o1, o2) -> {
            if (o1.getSalary().compareTo(o2.getSalary()) == 0) {
                return o1.getName().compareTo(o2.getName());
            } else return o1.getSalary().compareTo(o2.getSalary());
        });

        // the second solution
        //staff.sort(Comparator.comparing(Employee::getSalary).thenComparing(Employee::getName));


    }
}