package connectors;

import config.ProgramConstants;
import org.junit.Test;

import java.io.IOException;
import java.net.HttpURLConnection;

import static org.junit.Assert.assertEquals;

public class URLConnectorTest {

    @Test
    public void testGetConnectionForValidURL() {
        String url = ProgramConstants.GOOGLE + ProgramConstants.SEARCH_QUERY + "test";
        URLConnector urlConnector = new URLConnector(url);
        try {
            assertEquals(HttpURLConnection.HTTP_OK, urlConnector.getConnection().getResponseCode());
        } catch (IOException e) {
            System.err.println("Error creating HTTP connection");
        }
    }

    @Test
    public void testGetConnectionForNotFoundWebPageURL() {
        String url = "http://google.com/test";
        URLConnector urlConnector = new URLConnector(url);
        try {
            assertEquals(HttpURLConnection.HTTP_NOT_FOUND, urlConnector.getConnection().getResponseCode());
        } catch (IOException e) {
            System.err.println("Error creating HTTP connection");
        }
    }
}
