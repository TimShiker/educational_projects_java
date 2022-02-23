package FullNameFormatterRegExp;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FullNameFormatterRegExp {

    public static final String INVALID_INPUT = "The entered string is not a full name";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            }

            String regex = "^[А-Я]([а-я]+)-?[А-Я]?([а-я]+)?\\s" +
                    "[А-Я]([а-я]+)-?[А-Я]?([а-я]+)?\\s" +
                    "[А-Я]([а-я]+)-?[А-Я]?([а-я]+)?$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String[] fullName = input.split("\\s");
                System.out.println("Surname: " + fullName[0] + "\n" +
                        "Name: " + fullName[1] + "\n" +
                        "Patronymic: " + fullName[2]);
            } else {
                System.out.println(INVALID_INPUT);
            }
        }
    }

}