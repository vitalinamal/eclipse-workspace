package homework5;

import java.io.File;
import java.io.IOException;

public class MainTaskOne {
    public static void main(String[] args) throws IOException {
        File inputFolder = new File("Homework OOP 4\\src\\in");
        File outputFolder = new File("Homework OOP 4\\src\\out");
        String extensionFilter = ".doc";

        FileService.copyFolderWithExtension(inputFolder, outputFolder, extensionFilter);
    }
}
