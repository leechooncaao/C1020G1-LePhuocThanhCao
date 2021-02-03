package model.service.validation;

import java.util.regex.Pattern;

public class CommonValidator {
    public static boolean validateDate (String date){
        String regex = "^(\\d{4})-(1[0-2]|0[1-9])-(3[01]|[12][0-9]|0[1-9])$";

        var pattern = Pattern.compile(regex);
        var matcher = pattern.matcher(date);

        return matcher.find();
    }

    public static boolean validateNumber (Number number){
        return number.doubleValue() > 0;
    }


}
