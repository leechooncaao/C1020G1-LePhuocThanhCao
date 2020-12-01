package mangvaphuongthuc.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class SumInColumn {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter size of matrix, sequentially rows and cols : ");
        var rows = scanner.nextInt();
        var cols = scanner.nextInt();

        int[][] numbers = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("numbers[" + i + "][" + j + "] : ");
                numbers[i][j] = scanner.nextInt();

            }
        }

        // print the matrix to screen
        for (int i = 0; i < rows; i++)
            System.out.println(Arrays.toString(numbers[i]));

        int posCol;
        do {
            System.out.print("Enter position of column(from 0) : ");
            posCol = scanner.nextInt();
            if(posCol >= cols)
                System.out.println("Invalid input !");
        }while (posCol >= cols);

        var sum = 0;
        for (int i = 0; i < rows; i++) {
            sum += numbers[i][posCol];
        }

        System.out.println("Sum of elements in column-" + posCol + " : " + sum);

        scanner.close();

    }
}
