package PhoneBook;

import java.util.Scanner;
import java.util.TreeSet;

public class Main {

    private static final PhoneBook phoneBook = new PhoneBook();
    private static final String NOT_VALID_PHONE_RESPONSE = "Invalid number format. Mobile phone number\n " +
            "should contain from 10 to 11 digits, start with " +
            "\"7, 8, +, +7\".\n" +
            "Examples of valid numbers: +7 909 123-45-67, " +
            "+7 (909) 1234567, 8-905-1234567, 905-1234567.\n";
    private static final String NOT_VALID_NAME_RESPONSE = "Invalid name format. The name can only contain " +
            "Cyrillic and start with a capital letter.\n";
    private static final String COMMAND_LIST = "LIST";
    private static Scanner scanner;

    public static void main(String[] args) {

        scanner = new Scanner(System.in);

        System.out.println("\nPhone book");

        while (true) {
            System.out.println("\nEnter number, name or command." +
                    "\nCommands that work in this program: " +
                    "\n\t" + "\"LIST" + "\" - to list all contacts." +
                    "\n\t" + "\"EXIT" + "\" - to exit the program.\n");

            String input = scanner.nextLine();

            if (input.contains("EXIT")) {
                break;
            }
            getCommand(input);
        }
    }

    // added method to get command from input String
    public static void getCommand(String input) {

        if (input.contains(COMMAND_LIST)) {
            TreeSet<String> allContacts = new TreeSet<>(phoneBook.getAllContacts());

            if (!allContacts.isEmpty()) {
                System.out.println("List of all contacts:");
                allContacts.forEach(System.out::println);
            } else {
                System.out.println("There are no contacts in the phone book yet.");
            }
        } else if (phoneBook.isName(input)) {

            nameProcessing(input);

        } else if (phoneBook.isPhoneNumber(input)) {

            phoneProcessing(cleanPhone(input));

        } else {
            if (!phoneBook.isName(input)) System.out.println(NOT_VALID_NAME_RESPONSE);

            if (!phoneBook.isPhoneNumber(input)) System.out.println(NOT_VALID_PHONE_RESPONSE);
        }
    }

    // add to phone book name first and after - phone
    public static void nameProcessing(String input) {

        TreeSet<String> phonesByName = new TreeSet<>(phoneBook.getPhonesByName(input));

        if (phonesByName.isEmpty()) {
            System.out.println("This name is not in the phone book.\n" +
                    "Enter the phone number for the contact " + "\"" + input + "\":");

            String inputPhoneNumber = scanner.nextLine();

            if (!phoneBook.isPhoneNumber(inputPhoneNumber)) {
                System.out.println(NOT_VALID_PHONE_RESPONSE);
            } else {

                phoneBook.addContact(cleanPhone(inputPhoneNumber), input);
            }
        } else {
            phonesByName.forEach(System.out::println);
        }
    }

    // add to phone book phone first and after - name
    public static void phoneProcessing(String input) {

        if (phoneBook.getNameByPhone(input).isEmpty()) {
            System.out.println("There is no name with this number in the phone book.\n" +
                    "Enter a name for the phone " + "\"" + input + "\":");

            String inputName = scanner.nextLine();

            if (!phoneBook.isName(inputName)) {
                System.out.println(NOT_VALID_NAME_RESPONSE);
            } else {
                phoneBook.addContact(input, inputName);
            }
        } else {
            System.out.println(phoneBook.getNameByPhone(input));
        }
    }

    public static String cleanPhone(String phone){

        String numberWithOnlyDigits = phone.replaceAll("[^\\d]", "");
        System.out.println(numberWithOnlyDigits + " ");
        String numberCleaned = "";

        if (numberWithOnlyDigits.length() == 10) {
            numberCleaned = "7" + numberWithOnlyDigits;
            return numberCleaned;
        }

        switch (phone.charAt(0)) {
            case ('+'):
                numberCleaned = numberWithOnlyDigits;
                break;
            case ('8'):
                numberCleaned = numberWithOnlyDigits.replaceAll("^8", "7");
                break;
            case ('7'):
                numberCleaned = phone;
                break;

        }

        return numberCleaned;
    }

}
