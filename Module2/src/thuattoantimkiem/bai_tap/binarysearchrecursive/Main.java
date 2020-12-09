package thuattoantimkiem.bai_tap.binarysearchrecursive;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {2, 4, 7, 10, 11, 45, 50, 59, 60, 66, 69, 70, 79};
        Search search = new Search();

        var result = search.binarySearchRecursively(numbers,79);
        System.out.println(result);
    }
}
