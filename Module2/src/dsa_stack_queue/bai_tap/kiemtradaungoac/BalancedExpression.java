package dsa_stack_queue.bai_tap.kiemtradaungoac;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BalancedExpression {
    private final List<Character> LEFT_BRACKET = Arrays.asList('(','[','{','<');
    private final List<Character> RIGHT_BRACKET = Arrays.asList(')',']','}','>');

    public boolean isBalanced(String input){
        Stack<Character> stack = new Stack<>();

        // s * (s – a) * (s – b) * (s – c)
        for(var ch : input.toCharArray()){
            if(isLeftBracket(ch))
                stack.push(ch);

            if(isRightBracket(ch)){
                // if rightBracket exists but leftBracket does not exist
                if(stack.isEmpty()) return false;

                // if both left and right brackets exist -> check match between them
                var top = stack.pop();
                if(!bracketMatch(top,ch)) return false;
            }
        }

        return stack.isEmpty();
    }

    private boolean bracketMatch(char left, char right){
        return LEFT_BRACKET.indexOf(left) == RIGHT_BRACKET.indexOf(right);
    }

    private boolean isLeftBracket(char ch){
        return LEFT_BRACKET.contains(ch);
    }

    private boolean isRightBracket(char ch){
        return RIGHT_BRACKET.contains(ch);
    }
}
