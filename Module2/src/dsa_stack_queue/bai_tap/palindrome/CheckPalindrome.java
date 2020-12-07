package dsa_stack_queue.bai_tap.palindrome;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class CheckPalindrome {
    public static void main(String[] args) {
        String input = "Able was I ere I saw Elba";
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new ArrayDeque<>();

        for(var ch : input.toLowerCase().toCharArray()){
            stack.push(ch);
            queue.add(ch);
        }

        boolean isPalindrome = true;
        while (!stack.isEmpty()){
            if(stack.pop() != queue.remove()){
                isPalindrome = false;
                break;
            }
        }

        if(isPalindrome)
            System.out.println("is Palindrome");
        else System.out.println("is NOT palindrome");
    }
}
