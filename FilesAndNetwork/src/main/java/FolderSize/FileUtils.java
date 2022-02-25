package FolderSize;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileUtils {

    public static long calculateFolderSize(String path) throws IOException {

        long folderSize = 0L;

        folderSize = Files.walk(Path.of(path), Integer.MAX_VALUE).
                filter(p -> p.toFile().isFile()).
                mapToLong(p -> p.toFile().length()).sum();

        return folderSize;

        //second solution
        /*

        File folder = new File(path);
        File[] files = folder.listFiles();
        long folderSize = 0L;

        for (File file : files) {

            if(file.isFile()){
                folderSize += file.length();
            }
            else{
                folderSize += calculateFolderSize(file.getPath());
            }
        }
        return folderSize;

         */
    }
}
