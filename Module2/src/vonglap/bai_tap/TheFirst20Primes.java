package vonglap.bai_tap;

import java.util.Scanner;

public class TheFirst20Primes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of primes :");
        var number = scanner.nextInt();

        int count = 0;
        int element = 2;
        while (count < number) {
            if (isPrime(element)) {
                System.out.print(element + " ");
                count++;
            }

            element++;
        }
    }

    public static boolean isPrime(int number) {
        int i = 2;
        boolean check = true;

        while (i <= Math.sqrt(number)) {
            if (number % i == 0) {
                check = false;
                break;
            }

            i++;
        }

        return check;
    }

}
