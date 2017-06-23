package concurency;

import connectors.URLConnector;
import htmlworkers.HtmlExtractor;
import htmlworkers.HtmlParser;

import java.util.List;
import java.util.concurrent.Callable;

public class LibraryExtractor implements Callable<List<String>> {

    private String webLink;

    public LibraryExtractor(String webLink) {
        this.webLink = webLink;
    }

    @Override
    public List<String> call() throws Exception {
        HtmlExtractor htmlExtractor = new HtmlExtractor();
        HtmlParser htmlParser = new HtmlParser();
        URLConnector urlConnector = new URLConnector(webLink);
        return htmlParser.getJavascriptLibraries(htmlExtractor.extractHtml(urlConnector.getConnection()));
    }
}
