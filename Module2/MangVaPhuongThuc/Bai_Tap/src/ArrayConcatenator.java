import java.util.Arrays;

public class ArrayConcatenator {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        int[] b = {6,7,8,9,10,11,12,13,14,15};
        var sizeA = a.length;
        var sizeB = b.length;
        int[] result = new int[sizeA + sizeB];

        for(int i = 0; i < sizeA; i++)
            result[i] = a[i];

        int k = 0;
        for(int j = sizeA; j < result.length; j++){
            result[j] = b[k];
            if(k < sizeB - 1) k++;
            else break;
        }

        System.out.println(Arrays.toString(result));
    }
}
