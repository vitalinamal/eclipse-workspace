package homewr9;

import java.io.File;

public class Main {

    public static void main(String[] args) {

        var file = new File("Homework OOP 4\\src\\files\\english_words.txt");

        Translator.translateIntoUkrainian(file);
    }

}
