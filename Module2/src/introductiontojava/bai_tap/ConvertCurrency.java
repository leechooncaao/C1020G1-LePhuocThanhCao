package introductiontojava.bai_tap;

import java.util.Scanner;

public class ConvertCurrency {
    public static void main(String[] args) {
        final int RATE = 23000;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter USD : ");
        var usd = scanner.nextInt();

        var vnd = usd* RATE;

        System.out.println("Money in VND : " + vnd);
    }
}
