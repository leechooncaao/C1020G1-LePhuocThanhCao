package introductionToJava.bai_tap;

import java.util.Scanner;

public class ReadNumToWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number;
        do {
            System.out.println("Enter a number (max 3 digits):");
            number = scanner.nextInt();
            if(number >= 1000 || number < 0)
                System.out.println("Invalid input !");
        }while (number >= 1000 || number < 0);

        if (number == 0)
            System.out.println("zero");
        else {
            var dozen = number % 100;
            var hundred = number - dozen;
            String result = "";

            if (hundred == 0)
                result = getdozens(dozen);
            else if (dozen == 0)
                result = getHundreds(hundred);
            else result = getHundreds(hundred) + " and " + getdozens(dozen);

            System.out.println(result);
        }
    }

    public static String getUnit(int unit) {
        StringBuffer result = new StringBuffer();

        if (unit == 0)
            return "";

        result.append(" ");
        switch (unit) {
            case 1:
                result.append("one");
                break;
            case 2:
                result.append("two");
                break;
            case 3:
                result.append("three");
                break;
            case 4:
                result.append("four");
                break;
            case 5:
                result.append("five");
                break;
            case 6:
                result.append("six");
                break;
            case 7:
                result.append("seven");
                break;
            case 8:
                result.append("eight");
                break;
            case 9:
                result.append("nine");
                break;
        }

        return result.toString();
    }

    public static String getHundreds(int hundred) {
        StringBuffer result = new StringBuffer();

        if (hundred == 0)
            return "";

        switch (hundred) {
            case 100:
                result.append("one");
                break;
            case 200:
                result.append("two");
                break;
            case 300:
                result.append("three");
                break;
            case 400:
                result.append("four");
                break;
            case 500:
                result.append("five");
                break;
            case 600:
                result.append("six");
                break;
            case 700:
                result.append("seven");
                break;
            case 800:
                result.append("eight");
                break;
            case 900:
                result.append("nine");
                break;
        }
        result.append(" hundred");

        return result.toString();
    }

    public static String getdozens(int dozen) {
        StringBuffer result = new StringBuffer();

        if (dozen == 0)
            return "";

        if (dozen >= 10 && dozen < 20) {
            switch (dozen) {
                case 10:
                    result.append("ten");
                    break;
                case 11:
                    result.append("eleven");
                    break;
                case 12:
                    result.append("twelve");
                    break;
                case 13:
                    result.append("thirteen");
                    break;
                case 14:
                    result.append("fourteen");
                    break;
                case 15:
                    result.append("fifteen");
                    break;
                case 16:
                    result.append("sixteen");
                    break;
                case 17:
                    result.append("seventeen");
                    break;
                case 18:
                    result.append("eighteen");
                    break;
                case 19:
                    result.append("nineteen");
                    break;
            }
        } else {
            var unit = dozen % 10;
            dozen -= unit;
            var resUnit = getUnit(unit);
            switch (dozen) {
                case 20:
                    result.append("twenty");
                    break;
                case 30:
                    result.append("thirty");
                    break;
                case 40:
                    result.append("forty");
                    break;
                case 50:
                    result.append("fifty");
                    break;
                case 60:
                    result.append("sixty");
                    break;
                case 70:
                    result.append("seventy");
                    break;
                case 80:
                    result.append("eighty");
                    break;
                case 90:
                    result.append("ninety");
                    break;
            }

            result.append(resUnit);
        }

        return result.toString();
    }

}
