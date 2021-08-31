package course.inputOutput.optionalTasks;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 2.     Прочитать текст Java-программы и все слова public в объявлении атрибутов и методов класса заменить на слово private.
 */

public class ChangePublicToPrivate {
        public static void changePublicToPrivateWords(){
        File dir = new File("D:\\projects\\Java_Tasks\\data2");
        dir.mkdir();
        try (FileReader reader = new FileReader("filesForReading\\ChangePublicToPrivate.txt");
             BufferedReader bufferedReader = new BufferedReader(reader);
             FileWriter writer = new FileWriter("data2\\ChangedPublicToPrivate.txt");
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.contains("public") && !line.contains("class") &&
                        !line.contains("public static void main(String[] args)")) {
                    line = line.replaceAll("public", "private");
                }
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

}
