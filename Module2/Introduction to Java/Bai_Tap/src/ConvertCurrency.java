import java.util.Scanner;

public class ConvertCurrency {
    public static void main(String[] args) {
        final int rate = 23000;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter USD : ");
        var usd = scanner.nextInt();

        var vnd = usd*rate;

        System.out.println("Money in VND : " + vnd);
    }
}
