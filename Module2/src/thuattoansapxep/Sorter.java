package thuattoansapxep;

public class Sorter {
    public static void bubbleSort(int[] array) {
        boolean isSorted;
        for (int i = 0; i < array.length; i++) {
            isSorted = true;
            for (int j = 1; j < array.length - i; j++) {
                if (array[j] < array[j - 1]) {
                    swap(array, j, j - 1);
                    isSorted = false;
                }
            }

            if (isSorted)
                return;
        }
    }

    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = getMinIndex(array, i);

            swap(array, i, minIndex);
        }
    }

    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            var current = array[i];
            var j = i - 1;
            while (j >= 0 && array[j] > current) {
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = current;
        }
    }

    private static int getMinIndex(int[] array, int startIndex) {
        var minIndex = startIndex;
        for (int j = startIndex; j < array.length; j++) {
            if (array[j] < array[minIndex])
                minIndex = j;
        }
        return minIndex;
    }

    private static void swap(int[] array, int index1, int index2) {
        var temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

}
