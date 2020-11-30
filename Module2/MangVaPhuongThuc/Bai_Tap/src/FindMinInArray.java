import java.util.Arrays;
import java.util.Scanner;

public class FindMinInArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter size of array : ");
        var size = scanner.nextInt();

        int[] numbers = new int[size];
        var min = Integer.MAX_VALUE;
        for (int i = 0; i < size; i++){
            System.out.print("numbers[" + i + "] : ");
            numbers[i] = scanner.nextInt();

            if(min > numbers[i])
                min = numbers[i];
        }

        System.out.println(Arrays.toString(numbers));
        System.out.println("The min value : " + min);


        scanner.close();
    }
}
