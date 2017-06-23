package helper;

import config.ProgramConstants;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class QueryBuilder {

    public static String generateQuery(String searchTerm) {
        String term = generateTermForSearchQuery(searchTerm);
        return ProgramConstants.GOOGLE + ProgramConstants.SEARCH_QUERY + term;
    }

    private static String generateTermForSearchQuery(String searchTerm) {
        StringBuilder res = new StringBuilder();
        String[] termParts = searchTerm.split(" ");
        if (termParts.length == 1) return toUtf8(termParts[0]);
        for (String termPart : termParts) {
            res.append(toUtf8(termPart)).append("+");
        }
        return res.substring(0, res.length() - 1);
    }

    private static String toUtf8(String termPart) {
        try {
            return URLEncoder.encode(termPart, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

}
