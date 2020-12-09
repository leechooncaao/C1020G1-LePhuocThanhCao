package thuattoantimkiem.bai_tap.binarysearchrecursive;

public class Search {
    public int binarySearchRecursively(int[] numbers , int target){
        return binarySearchRecursively(numbers,target,0,numbers.length -1);
    }

    private int binarySearchRecursively(int[] numbers, int target, int left, int right){
        if(left > right)
            return -1;

        var middle = (left + right)/2;

        if(target == numbers[middle])
            return middle;

        if(target > numbers[middle])
            return binarySearchRecursively(numbers,target,middle + 1,right);

        return binarySearchRecursively(numbers,target,left,middle -1);
    }
}
