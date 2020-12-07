package dsa_stack_queue.bai_tap.thapphansangnhiphan;

import java.util.Stack;

public class ConverterDecToBinary {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        int dec = 174;

        var quotien = dec/2;
        var remainder = dec%2;
        stack.push(remainder);
        while (quotien != 0){
            remainder = quotien%2;
            quotien = quotien/2;
            stack.push(remainder);
        }

        while (!stack.isEmpty()){
            System.out.print(stack.pop());
        }

    }
}
