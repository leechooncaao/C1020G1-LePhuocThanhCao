package commons.validation;

import java.util.regex.Pattern;

public class ServiceValidator {

    public static boolean validateIdVilla(String id) {
        String idRegexVilla = "^SVVL-\\d{4}$";

        var pattern = Pattern.compile(idRegexVilla);
        var matcher = pattern.matcher(id);
        if (matcher.matches())
            return true;

        return false;
    }

    public static boolean validateIdHouse(String id) {
        String idRegexHouse = "^SVHO-\\d{4}$";

        var pattern = Pattern.compile(idRegexHouse);
        var matcher = pattern.matcher(id);
        if (matcher.matches())
            return true;

        return false;
    }

    public static boolean validateIdRoom(String id) {
        String idRegexRoom = "^SVRO-\\d{4}$";

        var pattern = Pattern.compile(idRegexRoom);
        var matcher = pattern.matcher(id);
        if (matcher.matches())
            return true;

        return false;
    }

    public static boolean validateServiceName(String serviceName){
        serviceName = serviceName.trim();
        var firstChar =  serviceName.charAt(0);

        for(int i = 1; i < serviceName.length(); i++){
            if(Character.isUpperCase(serviceName.charAt(i)))
                return false;
        }

        return Character.isUpperCase(firstChar);
    }

    public static boolean validateArea(int area){
        return area > 30;
    }

    public static boolean validatePrice(double price){
        return price > 0;
    }

    public static boolean validateNumberTenants(int numberTenants){
        return numberTenants > 0 && numberTenants < 20;
    }

    public static boolean validateFloorNumber(int floorNumber){
        return floorNumber > 0;
    }

}
