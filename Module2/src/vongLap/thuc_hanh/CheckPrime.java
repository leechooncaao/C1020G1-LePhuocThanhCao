package vongLap.thuc_hanh;

import java.util.Scanner;

public class CheckPrime {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a number: ");
        var number = input.nextInt();
        var isPrime = true;
        if(number < 2)
            isPrime = false;

        var i = 2;
        while (i <= Math.sqrt(number)) {
            if (number % i == 0) {
                isPrime = false;
                break;
            }
            i++;
        }

        if (isPrime)
            System.out.println(number + " is a prime.");
        else
            System.out.println(number + " is not a prime.");

    }
}
