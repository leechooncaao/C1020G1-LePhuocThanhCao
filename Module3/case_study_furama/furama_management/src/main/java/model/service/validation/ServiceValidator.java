package model.service.validation;

import java.util.regex.Pattern;

public class ServiceValidator {
    public static boolean validateServiceCode(String code){
        String regex = "^(DV-)\\d{4}$";

        var pattern = Pattern.compile(regex);
        var matcher = pattern.matcher(code);

        return matcher.find();
    }
}
