package ToDoList;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static TodoList todoList = new TodoList();
    private static final String COMMAND_ADD = "ADD";
    private static final String COMMAND_LIST = "LIST";
    private static final String COMMAND_EDIT = "EDIT";
    private static final String COMMAND_DELETE = "DELETE";
    private static final String COMMAND_EXIT = "EXIT";
    private static final String ERROR_MSG = "Error. Command entry example: " + "\"" + "ADD buy milk" + "\"." +
            " The name of the command should come first, the index if necessary, and then the to-do. ";

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String input = "";

        System.out.println("Hello. This is a console application for working with a to-do list. ");

        while (!input.contains("EXIT")) {
            System.out.println("\nChoose what you want to do with the to-do list and enter " +
                    "the corresponding command. For example: " +
                    "\n\tADD buy milk - Add to-do where " + "\"" + "buy milk" + "\"" + " is the name of the to-do;" +
                    "\n\tADD 3 buy milk - Add to-do where " + "\"" + "buy milk" + "\"" + " is " +
                    "the name of the to-do and " + "\"3" + "\" - is index on which to place it;" +
                    "\n\tLIST - Publish a to-do list with serial numbers;" +
                    "\n\tEDIT 0 make a cup of tea - replace case where " + "\"" + "0" + "\"" +
                    " replacement case index, and " + "\"" + "make a cup of tea" + "\"" + " - new to-do name;" +
                    "\n\tDELETE 4 - delete case where " + "\"" + "4" + "\"" + " is its index;" +
                    "\n\tEXIT - to exit the program." + "\n");

            input = in.nextLine();

            if (!isHaveCommand(input)) {
                continue;
            }
            getCommand(input);

        }
    }

    // this method defines, in the input String there is command or no
    public static boolean isHaveCommand(String input) {

        String[] inputWords = input.split("\\s");

        if (!inputWords[0].equals(COMMAND_EXIT) &&
                !inputWords[0].equals(COMMAND_LIST) &&
                inputWords.length < 2) {
            System.out.println(ERROR_MSG);
            return false;
        }

        if (inputWords[0].equals(COMMAND_ADD) || inputWords[0].equals(COMMAND_EDIT) ||
                inputWords[0].equals(COMMAND_EXIT) || inputWords[0].equals(COMMAND_LIST) ||
                inputWords[0].equals(COMMAND_DELETE)) {
            return true;
        }

        System.out.println(ERROR_MSG);
        return false;
    }

    // method to get command from input String
    public static void getCommand(String input) {

        String[] inputWords = input.split("\\s");
        StringBuilder stringBuilder;

        switch (inputWords[0]) {
            case COMMAND_ADD:
                if (inputWords[1].matches("\\d+") && inputWords.length > 2) {

                    stringBuilder = new StringBuilder();

                    for (int i = 2; i < inputWords.length; i++) {
                        stringBuilder.append(inputWords[i]).append(" ");
                    }
                    todoList.add(Integer.parseInt(inputWords[1]), stringBuilder.toString().trim());
                } else {

                    stringBuilder = new StringBuilder();

                    for (int i = 1; i < inputWords.length; i++) {
                        stringBuilder.append(inputWords[i]).append(" ");
                    }
                    todoList.add(stringBuilder.toString().trim());
                }
                break;
            case COMMAND_LIST:

                List<String> printTodoList = todoList.getTodos();

                if (printTodoList.isEmpty()) {
                    System.out.println("There are no items on the list yet.");
                } else {
                    for (String item : printTodoList) {

                        System.out.println(printTodoList.indexOf(item) + " - " + item);
                    }
                }
                break;
            case COMMAND_EDIT:

                if (inputWords[1].matches("\\d+") && inputWords.length > 2) {

                    stringBuilder = new StringBuilder();

                    for (int i = 2; i < inputWords.length; i++) {
                        stringBuilder.append(inputWords[i]).append(" ");
                    }
                    todoList.edit(stringBuilder.toString().trim(), Integer.parseInt(inputWords[1]));
                } else {
                    System.out.println(ERROR_MSG);
                }
                break;
            case COMMAND_DELETE:
                if (inputWords[1].matches("\\d+") && inputWords.length == 2) {

                    todoList.delete(Integer.parseInt(inputWords[1]));
                }
                break;
            case COMMAND_EXIT:
                System.out.println("You have exited the program.");
                break;
            default:
                System.out.println(ERROR_MSG);
                break;
        }
    }
}
