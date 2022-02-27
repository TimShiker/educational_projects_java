package CopyFile;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    private final static String ERROR_MSG = "Error. The path does not lead to a directory";
    private final static String EXIT_MSG = "To exit the program, enter \"Exit\".";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String sourceDirectory = "";
        String destinationDirectory = "";

        while (!sourceDirectory.equals("Exit") && !destinationDirectory.equals("Exit")) {

            System.out.println("Enter the path to the folder you want to copy. " + EXIT_MSG);
            sourceDirectory = scanner.nextLine();

            File source = new File(sourceDirectory);

            if (!source.isDirectory()) {
                System.out.println(ERROR_MSG);
                continue;
            }

            System.out.println("Enter the path where you want to copy the directory \"" + source + "\"" +
                    EXIT_MSG);
            destinationDirectory = scanner.nextLine();

            File target = new File(destinationDirectory);

            if (!target.isDirectory()) {
                System.out.println(ERROR_MSG);
                continue;
            }

            try {
                FileUtils.copyFolder(sourceDirectory, destinationDirectory);
                System.out.println("Copy completed successfully.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
