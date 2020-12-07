package dsa_stack_queue.bai_tap.reverser;

import java.util.Stack;

public class ReverserString {

    // abcde => edcba
    // stack1.push(a,b,c,d,e) : L - e d c b a - F
    // result = stack1.pop() = edcba
    public static String reverse(String input){
        if(input.isEmpty())
            return "";

        Stack<Character> stack = new Stack<>();
        for(var ch : input.toCharArray())
            stack.push(ch);

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty())
            result.append(stack.pop());

        return result.toString();

    }

    public static void main(String[] args) {
        var reversed = reverse("I Love You");
        System.out.println(reversed);
    }
}
