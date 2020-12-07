package dsa_stack_queue.bai_tap.reverser;

import java.util.Arrays;
import java.util.Stack;

public class ReverserArray {
    public static void reverse(int[] numbers){
        Stack<Integer> stack = new Stack<>();
        for(var number : numbers)
            stack.push(number);

        for(int i = 0; i< numbers.length;i++)
            numbers[i] = stack.pop();
    }

    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,5,6,7};

        System.out.println("Before reversing : ");
        System.out.println(Arrays.toString(numbers));

        reverse(numbers);
        System.out.println("After reversing : ");
        System.out.println(Arrays.toString(numbers));

    }
}
