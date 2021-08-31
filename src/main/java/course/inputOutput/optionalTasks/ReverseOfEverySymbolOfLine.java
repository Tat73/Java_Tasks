package course.inputOutput.optionalTasks;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 3.     Прочитать текст Java-программы и записать в другой файл в обратном порядке символы каждой строки.
 */
public class ReverseOfEverySymbolOfLine {
        public static void stringReverses(){
        File dir = new File("D:\\projects\\Java_Tasks\\data3");
        dir.mkdir();
        try (FileReader reader = new FileReader("filesForReading\\ChangePublicToPrivate.txt");
             BufferedReader bufferedReader = new BufferedReader(reader);
             FileWriter writer = new FileWriter("data3\\ReversedLines.txt");
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String reversed = new StringBuffer(line).reverse().toString();
                bufferedWriter.write(reversed);
                bufferedWriter.newLine();
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
