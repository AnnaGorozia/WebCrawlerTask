package htmlworkers;

import connectors.URLConnector;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.nio.charset.StandardCharsets;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class HtmlExtractorTest {

    @Test
    public void testExtractHtml() {
        String exampleString = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<body>\n" +
                "\n" +
                "<h1>My First Heading</h1>\n" +
                "\n" +
                "<p>My first paragraph.</p>\n" +
                "\n" +
                "</body>\n" +
                "</html>";

        HtmlExtractor htmlExtractor = new HtmlExtractor();
        assertEquals(exampleString, htmlExtractor.extractHtml(mockOfUrlConnection(exampleString)));
    }

    @Test
    public void testExtractEmptyHtml() {
        String exampleString = "";
        HtmlExtractor htmlExtractor = new HtmlExtractor();
        assertEquals(exampleString, htmlExtractor.extractHtml(mockOfUrlConnection(exampleString)));
    }

    private HttpURLConnection mockOfUrlConnection(String exampleString) {
        HttpURLConnection httpURLConnection = mock(HttpURLConnection.class);
        try {
            when(httpURLConnection.getInputStream()).thenReturn(new ByteArrayInputStream(exampleString.getBytes(StandardCharsets.UTF_8)));
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        URLConnector urlConnector = mock(URLConnector.class);
        when(urlConnector.getConnection()).thenReturn(httpURLConnection);
        return urlConnector.getConnection();
    }

}
