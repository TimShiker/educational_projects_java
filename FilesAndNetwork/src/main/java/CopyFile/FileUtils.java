package CopyFile;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.EnumSet;

public class FileUtils {

    public static void copyFolder(String sourceDirectory, String destinationDirectory) throws IOException {

        Path source = Path.of(sourceDirectory);
        Path target = Path.of(destinationDirectory);

        Files.walkFileTree(Path.of(sourceDirectory), new SimpleFileVisitor<>() {

            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)
                    throws IOException {

                Path resolve = target.resolve(source.relativize(dir));

                if (Files.notExists(resolve)) {
                    Files.createDirectories(resolve);
                }
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
                    throws IOException {

                Path resolve = target.resolve(source.relativize(file));
                Files.copy(file, resolve, StandardCopyOption.REPLACE_EXISTING);

                return FileVisitResult.CONTINUE;
            }
        });
    }
}

