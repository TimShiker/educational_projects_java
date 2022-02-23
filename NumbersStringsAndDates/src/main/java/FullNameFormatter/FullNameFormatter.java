package FullNameFormatter;

import java.util.Scanner;

public class FullNameFormatter {

    public static final char SPACE = ' ';
    public static final String INVALID_INPUT = "The entered string is not a full name";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {

            System.out.println("Please, enter your full name with patronymic. " +
                    "For example: 'Kogan Shlomo Adam'.");

            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            }

            if (!isThreeWords(input)) {
                System.out.println(INVALID_INPUT);
                continue;
            }

            if (!isLatin(input)) {
                System.out.println(INVALID_INPUT);
                continue;
            }

            printFullName(input);
        }
    }

    public static Boolean isThreeWords(String input) {

        int countOfSpace = 0;

        if (!Character.isUpperCase(input.charAt(0))) return false;

        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == SPACE) {
                countOfSpace++;

                if (countOfSpace > 2) return false;
                if (!Character.isUpperCase(input.charAt(i + 1))) return false;
            }
        }
        return countOfSpace == 2;
    }

    public static Boolean isLatin(String input) {

        char hyphen = '-';
        boolean isCyrillic = true;

        for (int i = 0; i < input.trim().length(); i++) {
            if (input.charAt(i) != SPACE) {
                if (!((input.charAt(i) >= 'A' && input.charAt(i) <= 'Z') ||
                        (input.charAt(i) >= 'a' && input.charAt(i) <= 'z'))
                        && input.charAt(i) != hyphen) {
                    isCyrillic = false;
                }

                if (input.charAt(i) == hyphen) {
                    if (i == input.length() - 1) isCyrillic = false;
                    i++;
                    if (!Character.isUpperCase(input.charAt(i))) isCyrillic = false;
                }
            }
        }

        return isCyrillic;
    }

    public static void printFullName(String input) {

        int firstIndexSpace = input.indexOf(SPACE);
        int secondIndexSpace = input.lastIndexOf(SPACE);

        String surname = input.substring(0, firstIndexSpace).trim();
        String name = input.substring(firstIndexSpace, secondIndexSpace).trim();
        String patronymic = input.substring(secondIndexSpace).trim();

        System.out.println("Surname: " + surname + "\n" +
                "Name: " + name + "\n" +
                "Patronymic: " + patronymic);
    }
}