package mangVaPhuongThuc.thuc_hanh;

import java.util.Arrays;
import java.util.Scanner;

public class FindMaxInArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size;
        do{
            System.out.print("Enter a size : ");
            size = scanner.nextInt();
            if(size > 20)
                System.out.println("Invalid input");
        }while (size > 20);

        int[] numbers = new int[size];
        for(int i = 0; i < size; i++){
            System.out.print("Element at position " + i + " : ");
            numbers[i] = scanner.nextInt();
        }

        System.out.println("The entered array : " + Arrays.toString(numbers));

        // find max value
        var max = Integer.MIN_VALUE;
        var index = 0;
        for(int i = 0; i < size; i++){
            if(numbers[i] > max){
                max = numbers[i];
                index = i;
            }
        }

        System.out.println("The max value in entered array is " + max + " at position " + index);
    }
}
