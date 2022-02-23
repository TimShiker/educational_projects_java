package EmailList;

import java.util.Scanner;

public class Main {
    public static final String WRONG_EMAIL_ANSWER = "Wrong format email";
    public static final String ERROR_MSG = "Invalid command input. Need to enter ADD hello@mail.ru for adding " +
            "email or LIST - to list all email";
    public static final String COMMAND_ADD = "ADD";
    public static final String COMMAND_LIST = "LIST";
    private static final EmailList emailList = new EmailList();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nChoose what you want to do with the list of email addresses and enter " +
                    "the corresponding command. For example: " +
                    "\n\tADD hello@skillbox.ru - Add email. Email in different registers is considered the same;" +
                    "\n\tLIST - publish a list of all emails in alphabetical order;" +
                    "\n\tEXIT - to exit the program." + "\n");

            String input = scanner.nextLine();

            if (input.equals("EXIT")) {
                break;
            }

            if (!isHaveCommand(input)) {
                continue;
            }

            getCommand(input);

        }
    }

    public static boolean isHaveCommand(String input) {

        String[] inputWords = input.split("\\s");
        int inputWordsLength = inputWords.length;

        if ((inputWords[0].equals(COMMAND_ADD) && inputWordsLength == 2) ||
                (inputWords[0].equals(COMMAND_LIST) && inputWordsLength == 1)) {
            return true;
        }

        System.out.println(ERROR_MSG);
        return false;

    }

    public static void getCommand(String input) {

        String[] inputWords = input.split("\\s");

        switch (inputWords[0]) {
            case COMMAND_ADD:
                emailList.add(inputWords[1]);
                break;
            case COMMAND_LIST:
                if (emailList.getSortedEmails().isEmpty()) {
                    System.out.println("The list is empty.");
                } else {
                    emailList.getSortedEmails().forEach(System.out::println);
                }
        }
    }
}
