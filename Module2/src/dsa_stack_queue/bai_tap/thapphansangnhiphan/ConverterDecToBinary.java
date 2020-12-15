package dsa_stack_queue.bai_tap.thapphansangnhiphan;

import java.util.Stack;

public class ConverterDecToBinary {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        int dec = 174;

        var quotient = dec/2;
        var remainder = dec%2;
        stack.push(remainder);
        while (quotient != 0){
            remainder = quotient%2;
            quotient = quotient/2;
            stack.push(remainder);
        }

        while (!stack.isEmpty()){
            System.out.print(stack.pop());
        }

    }
}
