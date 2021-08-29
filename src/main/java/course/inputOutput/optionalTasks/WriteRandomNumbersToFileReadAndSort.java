package course.inputOutput.optionalTasks;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 1.     Создать и заполнить файл случайными целыми числами. Отсортировать содержимое файла по возрастанию.
 */

public class WriteRandomNumbersToFileReadAndSort {
    public static void main(String[] args) {
        fileOutput();

    }

    public static List<Integer> randomNumbers() {
        List<Integer> randomArray = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int number = (int) (Math.random() * 10);
            randomArray.add(number);
        }
        return randomArray;
    }

    public static void fileOutput() {
        File dir = new File("D:\\projects\\Java_Tasks\\data1");
        dir.mkdir();
        File file = new File("data1\\randomNumbers.txt");
        List<Integer> array = randomNumbers();
        try (PrintStream stream = new PrintStream(new FileOutputStream(file))) {
            for (Integer arr : array) {
                stream.print(arr);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try (FileReader reader = new FileReader(file); FileWriter writer = new FileWriter("data1\\sortedRandomNumbers.txt")) {
            char[] value1 = new char[10];
            reader.read(value1);
            bubbleSort(value1);
            writer.write(value1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        }


    }

    public static void bubbleSort(char[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = array.length - 1; j > i; j--) {
                if (array[j - 1] > array[j]) {
                    char temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

}
