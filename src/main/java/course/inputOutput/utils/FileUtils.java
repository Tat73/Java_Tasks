package course.inputOutput.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

public class FileUtils {
    public static StringBuilder callRecursiveFunctionOfDirectory(Path path, int depthLevel) {
        File file = new File("filesForReading\\directoryStructure.txt");
        StringBuilder stringBuilder = new StringBuilder();
        BasicFileAttributes attr = null;
        try {
            attr = Files.readAttributes(path, BasicFileAttributes.class);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        assert attr != null;
        if (attr.isDirectory()) {
            DirectoryStream<Path> paths = null;
            try {
                paths = Files.newDirectoryStream(path);
            } catch (IOException exception) {
                exception.printStackTrace();
            }
            stringBuilder.append(addSpecialSymbolsToTreeStructure(depthLevel)).append("|----")
                    .append(path.getFileName()).append("\n");
            assert paths != null;
            for (Path tempPath : paths) {
                stringBuilder.append(callRecursiveFunctionOfDirectory(tempPath, depthLevel + 1));
            }
        } else {
            stringBuilder.append(addSpecialSymbolsToTreeStructure(depthLevel)).append("*")
                    .append(path.getFileName()).append("\n");
        }
        try (PrintStream stream = new PrintStream(new FileOutputStream(file))) {
            stream.print(stringBuilder);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return stringBuilder;
    }

    public static String addSpecialSymbolsToTreeStructure(int depthLevel) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < depthLevel; i++) {
            builder.append("|" + "    ");
        }
        return builder.toString();
    }

    public static String readAFile() {
        StringBuilder stringBuilder = new StringBuilder();
        String line = null;
        try (FileReader reader = new FileReader("filesForReading\\directoryStructure.txt");
             BufferedReader bufferedReader = new BufferedReader(reader)) {
            line = bufferedReader.readLine();
            while (line != null) {
                line = bufferedReader.readLine();
                stringBuilder.append(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return stringBuilder.toString();
    }

    public static int lengthOfFilesName() {
        int fileLength = 0;
        String line = readAFile();
        String[] fileNames = splitForFileName(line);
        for (int i = 0; i < fileNames.length; i++) {
            if (fileNames[i].contains("*")) {
                fileLength += fileNames[i].length();
            }
        }
        return fileLength;
    }

    public static int getAverageFileNameLength() {
        int averageFileNameLength;
        int fileLength = lengthOfFilesName();
        int filesCounter = countFiles();

        averageFileNameLength = fileLength / filesCounter;

        return averageFileNameLength;
    }

    public static int averageQuantityOfFiles() {
        int averageQuantityOfFilesInFolder = 0;
        int filesCounter = countFiles();
        int foldersCounter = countFolders();

        averageQuantityOfFilesInFolder = filesCounter / foldersCounter;

        return averageQuantityOfFilesInFolder;
    }

    public static int countFolders() {
        int foldersCounter = 0;
        String line = readAFile();
        String[] fileNames = split(line);
        for (String file : fileNames) {
            if (file.contains("|----")) {
                foldersCounter++;
            }
        }
        return foldersCounter;
    }

    public static int countFiles() {
        int filesCounter = 0;
        String line = readAFile();
        String[] fileNames = split(line);
        for (String file : fileNames) {
            if (file.contains("*")) {
                filesCounter++;
            }
        }
        return filesCounter;
    }

    private static String[] split(String line) {
        line = line.replaceAll("[^a-zA-Z.|*-]", " ").trim();
        return line.split("\\s+");
    }

    private static String[] splitForFileName(String line) {
        line = line.replaceAll("[^a-zA-Z*]", " ").trim();
        return line.split("\\s+");
    }

}
