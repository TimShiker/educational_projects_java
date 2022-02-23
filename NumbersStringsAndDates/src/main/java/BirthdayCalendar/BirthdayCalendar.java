package BirthdayCalendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class BirthdayCalendar {

    public static final String errorMessage = "Date input is incorrect. " +
            "Need to enter a date that is less or equal to the current date.\n" +
            "Also entered year must be more 0; month must be from 1 to 12; " +
            "the day must be more 0 and not more, \nthan the number of days in the corresponding month.";

    public static void main(String[] args) {

        int day = 4;
        int month = 1;
        int year = 1992;

        System.out.println(collectBirthdays(year, month, day));
    }

    public static String collectBirthdays(int year, int month, int day) {

        if (month < 1 || month > 12 || year < 1 || day < 1) {
            return errorMessage;
        }

        month -= 1;

        Calendar calendarNow = new GregorianCalendar();
        Calendar birthday = new GregorianCalendar();
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy - EEE", Locale.US);

        birthday.set(Calendar.YEAR, year);
        birthday.set(Calendar.MONTH, month);

        if (day > birthday.getActualMaximum(Calendar.DAY_OF_MONTH)) return errorMessage;
        birthday.set(Calendar.DAY_OF_MONTH, day);

        if(birthday.after(calendarNow)) return errorMessage;

        StringBuilder stringBuilder = new StringBuilder();
        int countOfYear = 0;

        while (!birthday.after(calendarNow)) {

            stringBuilder.append(countOfYear + " - " + formatter.format(birthday.getTime()) + "\n");

            countOfYear++;
            birthday.add(Calendar.YEAR, 1);

        }

        return stringBuilder.toString();
    }
}
