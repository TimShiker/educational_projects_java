package PhoneCleaner;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneCleaner {

    private static final String NOT_VALID_PHONE_RESPONSE = "Invalid number format\n";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            }

            String numberCleaned;

            String regex = "^((\\+?7?)|8?)((\\s?|-?)|\\s\\()" +
                                "(\\d{10}|" +
                                "(\\d{3}((\\s?|-?)|\\)\\s)(\\d{7}|" +
                                "\\d{3}(\\s?|-?)(\\d{4}|\\d{2}(\\s?|-?)\\d{2}))))$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {

                String numberWithOnlyDigits = input.replaceAll("[^\\d]", "");

                if (numberWithOnlyDigits.length() == 10) {
                    numberCleaned = "7" + numberWithOnlyDigits;
                    System.out.println(numberCleaned);
                    continue;
                }

                switch (input.charAt(0)) {
                    case ('+'):
                        numberCleaned = numberWithOnlyDigits;
                        System.out.println(numberCleaned);
                        break;
                    case ('8'):
                        numberCleaned = numberWithOnlyDigits.replaceAll("^8", "7");
                        System.out.println(numberCleaned);
                        break;
                }
            } else {
                System.out.println(NOT_VALID_PHONE_RESPONSE);
            }
        }
    }

}
