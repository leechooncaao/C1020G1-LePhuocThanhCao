package dsa_stack_queue.bai_tap.trienkhaiqueuebanglienketvong;

public class QueueTest {
    public static void main(String[] args) {
        CircleLinkedListQueue queue = new CircleLinkedListQueue();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);

        queue.displayQueue();

        var front = queue.dequeue();
        queue.displayQueue();
        System.out.println(front);

        front = queue.dequeue();
        queue.displayQueue();
        System.out.println(front);
    }
}
