package course.inputOutput.mainTask;

import course.inputOutput.mainTask.utils.FileUtils;

import java.nio.file.Path;



public class GetTreeStructure {
    public static void main(String[] args) {
        Path currentPath = Path.of(args[0]);
        FileUtils.callRecursiveFunctionOfDirectory(currentPath, 0);

        System.out.println("Folders quantity: " + FileUtils.countFolders());
        System.out.println("Files quantity: " + FileUtils.countFiles());
        System.out.println("Average quantity files: " + FileUtils.averageQuantityOfFiles());
        System.out.println("Average length of file name: " + FileUtils.getAverageFileNameLength());
    }

}
