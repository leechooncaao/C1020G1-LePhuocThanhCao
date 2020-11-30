package vongLap.thuc_hanh;

import java.util.Scanner;

public class InterestRate {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Money: ");
        var money = input.nextDouble();

        System.out.println("Time (month): ");
        var month = input.nextInt();

        System.out.println("Interest rate: ");
        var interset_rate = input.nextDouble();

        double total_interset = 0;
        for (int i = 0; i < month; i++) {
            total_interset = money * (interset_rate / 100) / 12 * month;
        }

        System.out.println("Total interset: " + total_interset);
    }
}
