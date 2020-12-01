package mangvaphuongthuc.thuc_hanh;

public class FindMinInArray {
    public static void main(String[] args) {
        int[] arr = {4, 12, 7, 8, 1, 6, 9};

        var min = minValue(arr);
        System.out.println("Min of array : " + min);
    }

    public static int minValue(int[] numbers){
        var min = Integer.MAX_VALUE;

        for(int i = 0; i < numbers.length; i++){
            if(numbers[i] < min)
                min = numbers[i];
        }

        return min;
    }
}
