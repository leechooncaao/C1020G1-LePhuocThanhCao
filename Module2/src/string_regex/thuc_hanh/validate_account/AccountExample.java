package string_regex.thuc_hanh.validate_account;

import java.util.regex.Pattern;

public class AccountExample {
    private static final String ACCOUNT_REGEX = "^[_a-z0-9]{6,}$";

    public boolean validate(String input) {
        var pattern = Pattern.compile(ACCOUNT_REGEX);
        var matcher = pattern.matcher(input);
        return matcher.matches();
    }
}
