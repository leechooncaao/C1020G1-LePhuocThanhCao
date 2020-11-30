package mangVaPhuongThuc.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class FindMaxIn2DArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter size of matrix, sequentially rows and cols : ");
        var rows = scanner.nextInt();
        var cols = scanner.nextInt();

        int[][] numbers = new int[rows][cols];
        var max = Integer.MIN_VALUE;
        var maxRow = 0;
        var maxCol = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("numbers[" + i + "][" + j + "] : ");
                numbers[i][j] =  scanner.nextInt();

                if(max < numbers[i][j]){
                    max = numbers[i][j];
                    maxRow = i;
                    maxCol = j;
                }
            }
        }

        // print the matrix to screen
        for(int i = 0; i < rows; i++){
            System.out.println(Arrays.toString(numbers[i]));
        }

        System.out.println("Max value is " + max + " at position (" + maxRow + ";" + maxCol + ")");
    }
}
