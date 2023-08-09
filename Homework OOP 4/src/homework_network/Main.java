package homework_network;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        String spec = "https://dom.ria.com";
        String htmlText = "";
        String filePath = "linksFromPage.txt";

        try {
            htmlText = HttpUrlService.getStringFromURL(spec, "UTF-8");
            System.out.println(htmlText);
        } catch (IOException e) {
            e.printStackTrace();
        }
        HttpUrlService.allLinksToFile(spec, filePath);
        HttpUrlService.checkIfLinksAreValid(filePath);
    }
}
