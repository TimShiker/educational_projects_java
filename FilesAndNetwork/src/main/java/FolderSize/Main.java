package FolderSize;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

    private static final long bytesInKb = 1024L;
    private static final long bytesInMb = bytesInKb * bytesInKb;
    private static final long bytesInGb = bytesInMb * bytesInKb;
    private static final long bytesInTb = bytesInGb * bytesInKb;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String path = "";

        while (!path.equals("Exit")) {
            System.out.println("Enter path to the folder. For exit from program enter \"Exit\".");
            path = scanner.nextLine();
            File folder = new File(path);

            if (!folder.isDirectory() && !folder.isFile()) {
                System.out.println("Error. Entered path does not lead to any file or folder.");
                continue;
            } else if (folder.isFile()) {
                System.out.println("Entered path lead to the file, not to folder." +
                        "His size: " + folder.length());
            }

            try {
                long sizeFolder = FileUtils.calculateFolderSize(path);


                if (sizeFolder > bytesInKb - 1) {
                    formattedBytes(sizeFolder, path);
                } else {
                    System.out.println("Folder's size \"" + path + "\" is " + sizeFolder + " bytes.\n");
                }
            } catch (IOException e) {
                e.getStackTrace();
            }
        }
    }

    public static void formattedBytes(long sizeFolder, String path) {

        double sizeForPrint;
        String formattedSize;

        if (sizeFolder > bytesInKb - 1 && sizeFolder < bytesInMb - 1) {
            sizeForPrint = (double) sizeFolder / bytesInKb;
            formattedSize = new DecimalFormat("#0.00").format(sizeForPrint);
            System.out.println("Folder's size \"" + path + "\" is " + formattedSize + " Kb.\n");
        } else if (sizeFolder > bytesInMb - 1 && sizeFolder < bytesInGb - 1) {
            sizeForPrint = (double) sizeFolder / bytesInMb;
            formattedSize = new DecimalFormat("#0.00").format(sizeForPrint);
            System.out.println("Folder's size \"" + path + "\" is " + formattedSize + " Mb.\n");
        } else if (sizeFolder > bytesInGb - 1 && sizeFolder < bytesInTb - 1) {
            sizeForPrint = (double) sizeFolder / bytesInGb;
            formattedSize = new DecimalFormat("#0.00").format(sizeForPrint);
            System.out.println("Folder's size \"" + path + "\" is " + formattedSize + " Gb.\n");
        } else if (sizeFolder > bytesInTb - 1) {
            sizeForPrint = (double) sizeFolder / bytesInTb;
            formattedSize = new DecimalFormat("#0.00").format(sizeForPrint);
            System.out.println("Folder's size \"" + path + "\" is " + formattedSize + " Tb.\n");
        }
    }
}
