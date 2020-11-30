package mangVaPhuongThuc.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class DeleteElementFromArray {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a value which need to delete : ");
        var deleting = scanner.nextInt();
        var index = searchElement(numbers, deleting);

        var size = numbers.length;
        if (index == -1)
            System.out.println("Not found !");
        else {
            for (int i = index; i < size - 1; i++)
                numbers[i] = numbers[i + 1];

            numbers[size - 1] = 0;

            System.out.println("After deleting : " + Arrays.toString(numbers));
        }


    }

    public static int searchElement(int[] numbers, int element) {
        var index = -1;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == element) {
                index = i;
                break;
            }
        }

        return index;
    }
}
