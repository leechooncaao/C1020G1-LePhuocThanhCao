package string_regex.thuc_hanh.crawl_songs;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CrawlSongExample {
    public static void main(String[] args) {
        try{
            URL url = new URL("https://www.nhaccuatui.com/bai-hat/nhac-tre-moi.html");
            Scanner scanner = new Scanner(new InputStreamReader(url.openStream()));
            scanner.useDelimiter("\\Z");
            var content = scanner.next();

            scanner.close();

            content = content.replaceAll("\\n+","");

            var pattern = Pattern.compile("name_song\">(.*?)</a>");
            var matcher = pattern.matcher(content);

            while (matcher.find())
                System.out.println(matcher.group(1));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
