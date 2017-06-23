package htmlworkers;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Scanner;

public class HtmlExtractor {

    public String extractHtml(HttpURLConnection connection) {
        if (connection == null) return "";
        Scanner scanner;
        try {
            scanner = new Scanner(connection.getInputStream());
        } catch (IOException e) {
            return "";
        }
        scanner.useDelimiter("\\Z");
        try {
            return scanner.next();
        } catch (Exception e) {
            return "";
        }
    }


}
