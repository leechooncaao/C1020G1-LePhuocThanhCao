package string_regex.bai_tap.validate_phonenumber;

import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String input = "(84)-(0978489648)";

        var pattern = Pattern.compile("^\\(\\d{2}\\)-\\([0]\\d{9}\\)$");
        var matcher = pattern.matcher(input);

        if(matcher.matches())
            System.out.println("Valid phone number");
        else
            System.out.println("Invalid phone number");
    }
}
