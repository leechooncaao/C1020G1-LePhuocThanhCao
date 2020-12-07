package dsa_stack_queue.bai_tap.kiemtradaungoac;

public class BalancedExpressionTest {
    public static void main(String[] args) {
        BalancedExpression expression = new BalancedExpression();

        var result = expression.isBalanced("s * ((s – a) * (s – b)) * (s – c)");

        if (result)
            System.out.println("The entered expression is balanced");
        else System.out.println("The entered expression is not balanced");

    }
}
