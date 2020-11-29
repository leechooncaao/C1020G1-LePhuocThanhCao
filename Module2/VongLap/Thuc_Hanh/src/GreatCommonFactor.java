import java.util.Scanner;

public class GreatCommonFactor {
    public static void main(String[] args) {
        Scanner nhap = new Scanner(System.in);

        System.out.println("Enter the first number: ");
        var a = nhap.nextInt();

        System.out.println("Enter the second number: ");
        var b = nhap.nextInt();

        a = Math.abs(a);
        b = Math.abs(b);

        if (a == 0 || b == 0)
            System.out.println("No greatest common factor");
        else {
            while (a != b) {

                if (a > b) a = a - b;
                else b = b - a;
            }

            System.out.println("Greatest common factor: " + a);
        }
    }
}
