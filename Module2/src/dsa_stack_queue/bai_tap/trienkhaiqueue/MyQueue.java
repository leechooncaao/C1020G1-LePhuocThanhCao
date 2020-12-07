package dsa_stack_queue.bai_tap.trienkhaiqueue;

public class MyQueue {
    private int[] items;
    private int first;
    private int rear;

    // 0 1 2 3 4
    // 5 3 4 0 0
    // F
    //     R

    public MyQueue(int size) {
        items = new int[size];
    }

    public void print() {
        for (int i = first; i < rear; i++)
            System.out.print(items[i] + " ");

        System.out.println();
    }

    public void enqueue(int item) {
        items[rear++] = item;
    }

    public void dequeue() {
        first++;
    }

    public boolean isFull(){
        return first == 0 && rear == items.length;
    }

    public boolean isEmpty(){
        return rear == 0;
    }
}
