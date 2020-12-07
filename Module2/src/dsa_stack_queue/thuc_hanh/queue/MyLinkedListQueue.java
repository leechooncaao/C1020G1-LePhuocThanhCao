package dsa_stack_queue.thuc_hanh.queue;

import java.util.LinkedList;

public class MyLinkedListQueue<T> {
    private LinkedList<T> queue;

    public MyLinkedListQueue(){
        queue = new LinkedList<>();
    }

    public void enqueue(T item){
        queue.addLast(item);
    }

    public T dequeue(){
        if(isEmpty())
            throw new IllegalStateException("Empty queue !");

        return queue.removeFirst();
    }

    public boolean isEmpty(){
        return queue.size() == 0;
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
