/*
3.   Создать список из элементов каталога и его подкаталогов.

 */
package course.collections.optionalTask;

import java.io.File;
import java.util.Scanner;

public class CatalogList {


    public static void main(String[] args) {
        System.out.println("Entry directory path: ");
        Scanner scanner = new Scanner(System.in);
        String directoryPath = scanner.nextLine();
        File directory = new File(directoryPath);

        findFoldersAndFiles(directory);

    }

    public static void findFoldersAndFiles(File file) {
        System.out.println(file.getAbsolutePath());

        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File findFile : files) {
                findFoldersAndFiles(findFile);

            }
        }
    }
}

