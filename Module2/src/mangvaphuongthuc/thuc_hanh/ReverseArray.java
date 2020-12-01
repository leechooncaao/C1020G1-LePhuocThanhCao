package mangvaphuongthuc.thuc_hanh;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseArray {
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

        // reversing array
        for(int i = 0; i < size/2; i++){
            var temp = numbers[i];
            numbers[i] = numbers[size - 1 - i];
            numbers[size - 1 - i] = temp;
        }
        System.out.println("The reversed array : " + Arrays.toString(numbers));

    }
}
