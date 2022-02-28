package ImageResizer;

import java.io.File;

public class Main
{

    public static int newWidth = 1500;
    public static int countThreads = 4;


    public static void main(String[] args)
    {
        String srcFolder = "C:\\Users\\timpa\\Desktop\\src";
        String dstFolder = "C:\\Users\\timpa\\Desktop\\dst";

        File srcDir = new File(srcFolder);
        File[] files = srcDir.listFiles();
        int lengthOfFiles = files.length;
        int middle = files.length / countThreads;

        File[] files1 = new File[middle];
        System.arraycopy(files, 0, files1, 0, files1.length);
        ImageResizer imageResizer = new ImageResizer(files1, newWidth, dstFolder);
        imageResizer.run();

        File[] files2 = new File[middle];
        System.arraycopy(files, middle, files2, 0, files2.length);
        ImageResizer imageResizer2 = new ImageResizer(files2, newWidth, dstFolder);
        imageResizer2.run();

        File[] files3 = new File[middle];
        System.arraycopy(files, (middle + middle), files3, 0, files3.length);
        ImageResizer imageResizer3 = new ImageResizer(files3, newWidth, dstFolder);
        imageResizer3.run();

        File[] files4 = new File[lengthOfFiles - (files1.length + files2.length + files3.length)];
        System.arraycopy(files, (middle + middle + middle), files4, 0, files4.length);
        ImageResizer imageResizer4 = new ImageResizer(files4, newWidth, dstFolder);
        imageResizer4.run();
    }
}
