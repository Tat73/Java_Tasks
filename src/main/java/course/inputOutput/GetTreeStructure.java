package course.inputOutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;


public class GetTreeStructure {
    public static void main(String[] args) {
        Path currentPath = Path.of(args[0]);
        callRecursiveFunctionOfDirectory(currentPath, 0);
    }

    public static StringBuilder callRecursiveFunctionOfDirectory(Path path, int depthLevel) {
        File file = new File("filesForReading\\directoryStructure.txt");
        StringBuilder sb = new StringBuilder();
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
            sb.append(addSpecialSymbolsToTreeStructure(depthLevel)).append("|----").append(path.getFileName()).append("\n");
            assert paths != null;
            for (Path tempPath : paths) {
                sb.append(callRecursiveFunctionOfDirectory(tempPath, depthLevel + 1));
            }
        } else {
            sb.append(addSpecialSymbolsToTreeStructure(depthLevel)).append(path.getFileName()).append("\n");
        }
        try(PrintStream stream = new PrintStream(new FileOutputStream(file))){
            stream.print(sb);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return sb;
    }

    public static String addSpecialSymbolsToTreeStructure(int depthLevel) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < depthLevel; i++) {
            builder.append("|" + "   ");
        }
        return builder.toString();
    }
}
