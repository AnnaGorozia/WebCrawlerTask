package connectors;

import config.ProgramConstants;

import java.net.HttpURLConnection;
import java.net.URL;

public class URLConnector {

    private String url;

    public URLConnector(String url) {
        this.url = url;
    }

    public URLConnector() {}

    public HttpURLConnection getConnection() {
        HttpURLConnection connection;
        try {
            URL urlConnection = new URL(url);
            connection = (HttpURLConnection) urlConnection.openConnection();
            connection.addRequestProperty("User-Agent", "Mozilla/4.76");
            return connection;
        }catch ( Exception ex ) {
            System.out.println(ProgramConstants.UNABLE_TO_CONNECT);
            return null;
        }
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
