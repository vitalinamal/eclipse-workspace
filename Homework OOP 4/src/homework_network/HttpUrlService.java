package homework_network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HttpUrlService {

    public static String getStringFromURL(String spec, String code) throws IOException {
        URL url = new URL(spec);
        URLConnection connection = url.openConnection();
        String result = "";
        try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), code))) {
            String temp;
            while ((temp = br.readLine()) != null) {
                result += temp + System.lineSeparator();
            }
        }
        return result;
    }

    public static void allLinksToFile(String spec, String filePath) {
        try {

            List<String> links = new ArrayList<>();

            URL url = new URL(spec);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            BufferedReader bf = new BufferedReader(new InputStreamReader(http.getInputStream()));
            String line;
            Pattern pattern = Pattern.compile("http[s]?://[\\w\\d./?=#&_-]+");

            while ((line = bf.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    links.add(matcher.group());
                }
            }
            saveLinksToFile(links, filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveLinksToFile(List<String> links, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String link : links) {
                writer.write(link);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void checkIfLinksAreValid(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                URL url = new URL(line);
                try {
                    HttpURLConnection huc = (HttpURLConnection) url.openConnection();

                    int responseCode = huc.getResponseCode();
                    if (responseCode == HttpURLConnection.HTTP_OK) {
                        System.out.println("Site on url " + line + " IS available!");
                    } else {
                        System.out.println("Site on url " + line + " is NOT available!");
                    }
                } catch (IOException e) {
                    System.out.format("There was an exception for url %s: %s", line, e.getLocalizedMessage());
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
