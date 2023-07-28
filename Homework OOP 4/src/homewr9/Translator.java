package homewr9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Translator {

    private static Map<String, String> englishUkrainianDictionary = new HashMap<>();

    static {
        englishUkrainianDictionary.put("car", "машина");
        englishUkrainianDictionary.put("plane", "літак");
        englishUkrainianDictionary.put("train", "потяг");
        englishUkrainianDictionary.put("ship", "корабель");
        englishUkrainianDictionary.put("bird", "птах");
        englishUkrainianDictionary.put("fish", "риба");
        englishUkrainianDictionary.put("cat", "кіт");
        englishUkrainianDictionary.put("dog", "собака");
    }

    public static void translateIntoUkrainian(File file) {
        updateDictionary();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            String fileName = "Homework OOP 4\\src\\files\\" + file.getName() + "-translated.txt";

            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(new FileOutputStream(fileName), StandardCharsets.UTF_8));
            while ((line = reader.readLine()) != null) {
                List<String> data = Arrays.asList(line.split(" "));

                for (String string : data) {
                    System.out.println(string);
                    writer.write(englishUkrainianDictionary.get(string) != null ? englishUkrainianDictionary.get(string)
                            : "cannot_translate");
                    writer.write(" ");
                }
                writer.newLine();
            }
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void updateDictionary() {
        Scanner sc = new Scanner(System.in);
        String fileName = "Homework OOP 4\\src\\files\\dictionary.csv";
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    new FileInputStream(fileName), StandardCharsets.UTF_8));
            String line;
            while ((line = br.readLine()) != null) {
                List<String> data = Arrays.asList(line.split(","));
                englishUkrainianDictionary.put(data.get(0), data.get(1));
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            System.out.println("Put english word which you want to add to dictionary: ");
            String key = sc.nextLine();
            if (key.equals("0")) {
                break;
            }
            System.out.println("Put ukrainian translation for word " + key + ": ");
            String value = sc.nextLine();
            englishUkrainianDictionary.put(key, value);
            System.out.println("If you want exit updating dictionary put 0(zero)");
        }

        try (BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(fileName), StandardCharsets.UTF_8))) {
            for (Map.Entry<String, String> entry : englishUkrainianDictionary.entrySet()) {
                writer.write(entry.getKey() + "," + entry.getValue());
                writer.newLine();
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        sc.close();
    }

}
