package htmlworkers;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class HtmlParserTest {

    @Test
    public void testGetJavascriptLibraries() {
        String exampleString = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<body>\n" +
                "<script src=\"/lib/w3schools_footer.min.js\"></script>\n" +
                "\n" +
                "<p>My first paragraph.</p>\n" +
                "\n" +
                "</body>\n" +
                "</html>";

        HtmlParser htmlParser = new HtmlParser();
        List<String> actualRes = htmlParser.getJavascriptLibraries(exampleString);
        List<String> expectedRes = new ArrayList<>();
        expectedRes.add("w3schools_footer");
        assertEquals(expectedRes.size(), actualRes.size());
        assertEquals(expectedRes, actualRes);
    }

    @Test
    public void testGetJavascriptLibrariesZeroCase() {
        String exampleString = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<body>\n" +
                "\n" +
                "<p>My first paragraph.</p>\n" +
                "\n" +
                "</body>\n" +
                "</html>";

        HtmlParser htmlParser = new HtmlParser();
        List<String> actualRes = htmlParser.getJavascriptLibraries(exampleString);
        assertEquals(0, actualRes.size());
    }

    @Test
    public void testGetJavascriptLibrariesMultipleCase() {
        String exampleString = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<body>\n" +
                "<script src=\"/lib/w3schools_footer.js\"></script>\n" +
                "<script src=\"/lib/jquery.js\"></script>\n" +
                "<script src=\"/lib/slider.js\"></script>\n" +
                "\n" +
                "<p>My first paragraph.</p>\n" +
                "\n" +
                "</body>\n" +
                "</html>";

        HtmlParser htmlParser = new HtmlParser();
        List<String> actualRes = htmlParser.getJavascriptLibraries(exampleString);
        List<String> expectedRes = new ArrayList<>();
        expectedRes.add("w3schools_footer");
        expectedRes.add("jquery");
        expectedRes.add("slider");
        assertEquals(expectedRes.size(), actualRes.size());
        assertEquals(expectedRes, actualRes);
    }

    @Test
    public void testGetGoogleLinks() {
        String exampleString = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<body>\n" +
                "<a href=\"/url?q=https://search.yahoo.com/&amp;\">" +
                "\n" +
                "<p>My first paragraph.</p>\n" +
                "\n" +
                "</body>\n" +
                "</html>";

        HtmlParser htmlParser = new HtmlParser();
        List<String> actualRes = htmlParser.getGoogleLinksFromResultPage(exampleString);
        List<String> expectedRes = new ArrayList<>();
        expectedRes.add("https://search.yahoo.com/");
        assertEquals(expectedRes.size(), actualRes.size());
        assertEquals(expectedRes, actualRes);
    }

    @Test
    public void testGetGoogleLinksEmpty() {
        String exampleString = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<body>\n" +
                "\n" +
                "<p>My first paragraph.</p>\n" +
                "\n" +
                "</body>\n" +
                "</html>";

        HtmlParser htmlParser = new HtmlParser();
        List<String> actualRes = htmlParser.getGoogleLinksFromResultPage(exampleString);
        assertEquals(0, actualRes.size());
    }

    @Test
    public void testGetGoogleLinksMultiple() {
        String exampleString = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<body>\n" +
                "<a href=\"/url?q=https://search.yahoo.com/&amp;\">" +
                "<a href=\"/url?q=https://facebook.com/&amp;\">" +
                "<a href=\"/url?q=https://twitter.com/&amp;\">" +
                "\n" +
                "<p>My first paragraph.</p>\n" +
                "\n" +
                "</body>\n" +
                "</html>";

        HtmlParser htmlParser = new HtmlParser();
        List<String> actualRes = htmlParser.getGoogleLinksFromResultPage(exampleString);
        List<String> expectedRes = new ArrayList<>();
        expectedRes.add("https://search.yahoo.com/");
        expectedRes.add("https://facebook.com/");
        expectedRes.add("https://twitter.com/");
        assertEquals(expectedRes.size(), actualRes.size());
        assertEquals(expectedRes, actualRes);
    }

}
