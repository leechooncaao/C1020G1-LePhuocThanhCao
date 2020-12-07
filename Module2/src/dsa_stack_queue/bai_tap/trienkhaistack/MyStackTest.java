package dsa_stack_queue.bai_tap.trienkhaistack;

public class MyStackTest {
    public static void main(String[] args) {
        MyStack stack = new MyStack();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        stack.print();

        System.out.println(stack.pop());
        stack.print();

        System.out.println(stack.pop());
        stack.print();

        System.out.println(stack.peek());
        stack.print();
    }
}
