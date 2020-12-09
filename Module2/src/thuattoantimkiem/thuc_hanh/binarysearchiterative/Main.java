package thuattoantimkiem.thuc_hanh.binarysearchiterative;

import java.util.Arrays;

public class Main {
    public static int binarySearch(int[] numbers, int target){
        var left = 0;
        var right = numbers.length -1;
        while (left <= right){
            var middle = (left + right)/2;

            if(numbers[middle] == target)
                return middle;

            if(target > numbers[middle])
                left = middle + 1;
            else
                right = middle - 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] numbers = {2, 4, 7, 10, 12, 45, 50, 62, 63, 66, 69, 70, 79};
        var result = binarySearch(numbers,79);
        System.out.println(result);
    }
}
