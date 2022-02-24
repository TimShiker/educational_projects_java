package Employees;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.List;

public class Main {

    private static final String STAFF_TXT = "C:\\Users\\timpa\\Documents\\GitHub\\educational_projects_java\\" +
            "AdvancedOOPFeatures\\data\\staff.txt";

    public static void main(String[] args) {
        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);

        Employee employeeMaxSalary = findEmployeeWithHighestSalary(staff, 2016);
        System.out.println(employeeMaxSalary);
    }

    // method to find employee with the highest salary with lambda
    public static Employee findEmployeeWithHighestSalary(List<Employee> staff, int year) {

        if(staff.isEmpty() || year < 0){
            return null;
        }

        DateFormat dateFormat = new SimpleDateFormat("yyyy");
        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.YEAR, year);
        String dateToCompare = dateFormat.format(calendar.getTime());

        return staff.stream().
                filter(employee ->
                        dateFormat.format(employee.getWorkStart()).
                        equals(dateToCompare)).
                        max(Comparator.comparing(Employee::getSalary)).orElse(null);
    }
}