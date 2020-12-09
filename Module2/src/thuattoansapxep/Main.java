package thuattoansapxep;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {1,2,6,7,3,4,10,21,19,22,14,8,5};
//        Sorter.bubbleSort(numbers);
//        Sorter.selectionSort(numbers);
        Sorter.insertionSort(numbers);
        System.out.println(Arrays.toString(numbers));
    }
}
