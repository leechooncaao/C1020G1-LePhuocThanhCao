package mangVaPhuongThuc.thuc_hanh;

import java.util.Arrays;
import java.util.Scanner;

public class CountNumbersOfPassedStudent {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number;
        do {
            System.out.print("Enter a number of students (<= 30) : ");
            number = scanner.nextInt();
            if (number > 30)
                System.out.println("Invalid input !");
        } while (number > 30);

        int[] marks = new int[number];
        int count = 0;
        for (int i = 0; i < number; i++) {
            int mark;
            do {
                System.out.print("Mark of student-" + (i + 1) + " : ");
                mark = scanner.nextInt();
                if(mark < 0 || mark > 10)
                    System.out.println("Mark should be in [0;10] !");
            }while (mark < 0 || mark > 10);

            marks[i] = mark;

            if(mark >= 5 && mark <= 10)
                count++;
        }

        System.out.println(Arrays.toString(marks));
        System.out.println("Number of passed-student : " + count);

    }
}
