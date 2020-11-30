package mangVaPhuongThuc.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class AddElementToArray {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a value with it's position need to be insert into array : ");
        var value = scanner.nextInt();
        var position = scanner.nextInt();

        if (position < 0 || position >= numbers.length)
            System.out.println("Cannot insert, invalid input !");
        else {
            var result = insert(numbers, value, position);
            System.out.println("After inserting : " + Arrays.toString(result));
        }

    }

    public static int[] insert(int[] numbers, int value, int position) {
        var size = numbers.length;
        int[] result = new int[size + 1];

        if (position == size - 1) {
            System.arraycopy(numbers, 0, result, 0, size);

            result[size] = value;
        } else {
            // clone first part of numbers to result
            System.arraycopy(numbers, 0, result, 0, position);

            // inserting value into position
            result[position] = value;

            // clone the rest of numbers to result
            System.arraycopy(numbers, position, result, position + 1, size - position);
        }

        return result;
    }
}
