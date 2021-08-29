package course.inputOutput;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class WorkWithFile {
    public static void main(String[] args) {
        int foldersCounter = 0;
        int filesCounter = 0;
        int averageQuantityOfFilesInFolder = 0;
        int fileLength = 0;
        int averageFileLength = 0;

        try (FileReader reader = new FileReader("filesForReading\\directoryStructure.txt");
             BufferedReader bufferedReader = new BufferedReader(reader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.contains("|----")) {
                    foldersCounter++;
                } else {
                    filesCounter++;
                    String[] fileNames = split(line);
                    for (String fileName : fileNames) {
                        fileLength += fileName.length();
                    }
                    averageFileLength = fileLength / filesCounter;
                }
                averageQuantityOfFilesInFolder = filesCounter / foldersCounter;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        System.out.println("Folders quantity in directory: " + foldersCounter + "\n" +
                "Files quantity in directory: " + filesCounter + "\n" +
                "Average file quantity in a folder: " + averageQuantityOfFilesInFolder + "\n" +
                "Average file name length: " + averageFileLength);

    }

    private static String[] split(String line) {
        line = line.replaceAll("[^a-zA-Z.]", " ").trim();
        return line.split("\\s+");
    }
}
