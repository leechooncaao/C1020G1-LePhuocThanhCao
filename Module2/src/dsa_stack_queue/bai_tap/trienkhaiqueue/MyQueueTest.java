package dsa_stack_queue.bai_tap.trienkhaiqueue;

public class MyQueueTest {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue(6);

//        queue.enqueue(1);
//        queue.enqueue(2);
//        queue.enqueue(3);
//        queue.enqueue(4);
//        queue.enqueue(5);
//        queue.enqueue(5);
//        queue.dequeue();

//        queue.print();

        System.out.println(queue.isFull());
        System.out.println(queue.isEmpty());
    }
}
