package dsa_stack_queue.thuc_hanh.queue;

public class LinkedListQueueClient {
    public static void main(String[] args) {
        MyLinkedListQueue<Integer> queue = new MyLinkedListQueue<>();

        queue.enqueue(10);
        queue.enqueue(20);
        System.out.println(queue);

        var firstItem = queue.dequeue();
        System.out.println("The dequeued-item : " + firstItem);

        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);

        System.out.println(queue);
        firstItem =  queue.dequeue();
        System.out.println("The dequeued-item : " + firstItem);

        System.out.println(queue);

    }
}
