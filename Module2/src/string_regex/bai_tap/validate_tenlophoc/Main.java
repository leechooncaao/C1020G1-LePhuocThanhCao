package string_regex.bai_tap.validate_tenlophoc;

import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String input = "A0313G";

        var pattern = Pattern.compile("^[CAP]\\d{4}[GHIKLM]$");
        var matcher = pattern.matcher(input);

        if(matcher.matches())
            System.out.println("input valid !");
        else
            System.out.println("invalid input");
    }
}
