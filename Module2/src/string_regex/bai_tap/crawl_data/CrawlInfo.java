package string_regex.bai_tap.crawl_data;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CrawlInfo {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://dantri.com.vn/the-gioi.htm");
            Scanner scanner = new Scanner(new InputStreamReader(url.openStream()));
            scanner.useDelimiter("\\Z");
            var content = scanner.next();

            scanner.close();
            content = content.replaceAll("\\n+", "");

            var pattern = Pattern.compile(">(.*?)</a>");
            var matcher = pattern.matcher(content);

            while (matcher.find())
                System.out.println(matcher.group(1));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
