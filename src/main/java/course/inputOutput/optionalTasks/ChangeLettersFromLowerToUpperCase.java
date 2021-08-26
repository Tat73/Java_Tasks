package course.inputOutput.optionalTasks;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


/**
 * 4.     Прочитать текст Java-программы и в каждом слове длиннее двух символов все строчные символы заменить прописными.
 */

public class ChangeLettersFromLowerToUpperCase {
    public static void main(String[] args) throws FileNotFoundException {
        File dir = new File("D:\\projects\\Java_Tasks\\data4");
        dir.mkdir();
        try (FileReader reader = new FileReader("filesForReading\\ChangePublicToPrivate.txt");
             BufferedReader bufferedReader = new BufferedReader(reader);
             FileWriter writer = new FileWriter("data4\\ChangeLettersFromLowerToUpperCase.txt");
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {

            String line;
            StringBuilder stringBuilder = new StringBuilder();

            while ((line = bufferedReader.readLine()) != null) {
                String[] lineArr = line.split(" ");
                for (int i = 0; i < lineArr.length; i++) {
                    if (lineArr[i].length() > 2) {
                        stringBuilder.append(lineArr[i].toUpperCase()).append(" ");
                    } else {
                        stringBuilder.append(lineArr[i]).append(" ");
                    }
                }
            }
            bufferedWriter.write(String.valueOf(stringBuilder));
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

}
