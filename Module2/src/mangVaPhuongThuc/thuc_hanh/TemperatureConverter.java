package mangVaPhuongThuc.thuc_hanh;

import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Fahrenheit to Celsius");
        System.out.println("2. Celsius to Fahrenheit");
        System.out.println("3. Exit ");

        int choice = -1;
        int temperature;
        while (choice != 3) {
            System.out.println("Your choice : ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter a temperature by Fahrenheit :");
                    temperature = scanner.nextInt();

                    System.out.println("Temperature by Celcius : " + toCelcius(temperature));

                    break;
                case 2:
                    System.out.println("Enter a temperature by Celcius :");
                    temperature = scanner.nextInt();

                    System.out.println("Temperature by Fahrenheit : " + toFahrenheit(temperature));

                    break;
                default:
                    System.out.println("Invalid input");
            }
        }

    }

    public static double toCelcius(int temperature) {
        return (5.0 / 9) * (temperature - 32);
    }

    public static double toFahrenheit(int temperature) {
        return (9.0 / 5) * temperature + 32;
    }

}
