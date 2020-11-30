package vongLap.bai_tap;

public class TheSmallerThan100Primes {
    public static void main(String[] args) {
        int i = 2;
        while (i < 100){
            if(isPrime(i))
                System.out.print(i + " ");

            i++;

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
