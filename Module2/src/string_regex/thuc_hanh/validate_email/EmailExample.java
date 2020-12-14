package string_regex.thuc_hanh.validate_email;

import java.sql.Struct;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailExample {
    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    private static Pattern pattern;
    private Matcher matcher;


    public EmailExample() {
        pattern = pattern.compile(EMAIL_REGEX);
    }

    public boolean validate(String input){
        matcher =  pattern.matcher(input);

        return matcher.matches();
    }
}
