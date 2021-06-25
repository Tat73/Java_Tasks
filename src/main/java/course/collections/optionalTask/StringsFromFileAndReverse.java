/*
1.   Ввести строки из файла, записать в список. Вывести строки в файл в обратном порядке.
 */

package course.collections.optionalTask;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;


public class StringsFromFileAndReverse {
    public static void main(String[] args) throws IOException {

        File file = new File("D:\\project\\JavaTasks\\src\\main\\resources\\text");
        List<String> list = Files.readAllLines(Paths.get(String.valueOf(file)));
        System.out.println(list);

        Collections.reverse(list);
        file = new File("D:\\project\\JavaTasks\\src\\main\\resources\\fileNew.txt");

        try (FileWriter writer = new FileWriter(file)) {
            for (String string : list) {
                writer.write(string);
                writer.write("\n");
            }
        }

    }
}


