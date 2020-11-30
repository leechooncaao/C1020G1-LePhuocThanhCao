package mangVaPhuongThuc.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class SumOfDiagonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter size of square matrix : ");
        var size = scanner.nextInt();

        int[][] numbers = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print("numbers[" + i + "][" + j + "] : ");
                numbers[i][j] = scanner.nextInt();
            }
        }

        int sum = 0;
        int i = 0;
        while (i < size){
            sum += numbers[i][i];
            i++;
        }

        // print the matrix to screen
        for (int j = 0; j < size; j++)
            System.out.println(Arrays.toString(numbers[j]));

        System.out.println("Sum of elements in the main diagonal : " + sum);
    }
}
