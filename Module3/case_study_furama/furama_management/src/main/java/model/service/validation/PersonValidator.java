package model.service.validation;

import java.util.regex.Pattern;

public class PersonValidator {
    public static boolean validateCustomerCode (String code){
        String regex = "^(KH-)\\d{4}$";

        var pattern = Pattern.compile(regex);
        var matcher = pattern.matcher(code);

        return matcher.find();
    }

    public static boolean validatePhone(String phone){
        String regex = "(^(090)\\d{7}$)|(^(091)\\d{7}$)|(^(\\+\\(84\\) 90)\\d{7}$)|(^(\\+\\(84\\) 91)\\d{7}$)";

        var pattern = Pattern.compile(regex);
        var matcher = pattern.matcher(phone);

        return matcher.find();
    }

    public static boolean validateIdCard(String idCard){
        String regex = "(^\\d{9}$)|(^\\d{12}$)";

        var pattern = Pattern.compile(regex);
        var matcher = pattern.matcher(idCard);

        return matcher.find();
    }

    public static boolean validateEmail (String email){
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";

        var pattern = Pattern.compile(regex);
        var matcher = pattern.matcher(email);

        return matcher.find();
    }

}
