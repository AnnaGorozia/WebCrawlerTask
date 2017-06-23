package htmlworkers;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlParser {

    public List<String> getGoogleLinksFromResultPage(String html) {
        List<String> res = new ArrayList<>();
        String pattern1 = "<a href=\"/url?q=";
        String pattern2 = "\">";
        Pattern p = Pattern.compile(Pattern.quote(pattern1) + "(.*?)" + Pattern.quote(pattern2));
        Matcher m = p.matcher(html);

        while (m.find()) {
            String domainName = m.group(0).trim();
            domainName = domainName.substring(domainName.indexOf("/url?q=") + 7);
            domainName = domainName.substring(0, domainName.indexOf("&amp;"));
            res.add(domainName);
        }
        return res;
    }

    public List<String> getJavascriptLibraries(String html) {
        List<String> res = new ArrayList<>();
        String pattern1 = "src=\"";
        String pattern3 = "src=\'";
        String pattern2 = ".js\"";
        String pattern4 = ".js\'";
        Pattern p = Pattern.compile("(" + Pattern.quote(pattern1) + "|" + Pattern.quote(pattern3)  + ")" + "(.*?)" + "(" + Pattern.quote(pattern2) + "|" + Pattern.quote(pattern4) + ")");
        Matcher m = p.matcher(html);

        while (m.find()) {
            String domainName = m.group(0).trim();
            domainName = domainName.substring(domainName.indexOf("src=") + 5);
            domainName = domainName.substring(domainName.lastIndexOf("/") + 1);
            domainName = domainName.substring(0, domainName.indexOf(".js"));
            domainName = removeExcessPartsOfJsName(domainName);
            res.add(domainName);
        }
        return res;
    }

    private String removeExcessPartsOfJsName(String domainName) {
        if (domainName.contains(".min")) {
            domainName = domainName.substring(0, domainName.indexOf(".min"));
        }
        if (domainName.contains(".minified")) {
            domainName = domainName.substring(0, domainName.indexOf(".minified"));
        }
        if (Pattern.compile("-[0-9]").matcher(domainName).find()) {
            domainName = domainName.replaceAll("-[0-9][0-9]", "");
            domainName = domainName.replaceAll(".[0-9][0-9]", "");
            domainName = domainName.replaceAll("-[0-9]", "");
            domainName = domainName.replaceAll(".[0-9]", "");
        }
        return domainName;
    }

}
