package dsa_stack_queue.bai_tap.trienkhaiqueuebanglienketvong;

public class CircleLinkedListQueue {
    private Node front;
    private Node rear;

    public CircleLinkedListQueue() {
    }

    public void enqueue(int item) {
        var node = new Node(item);

        if (isEmpty())
            front = node;
        else rear.next = node;

        rear = node;
        rear.next = front;

//        System.out.println("front= " + front.data);
//        System.out.println("rear= " + rear.data);
    }

    public int dequeue(){
       if(isEmpty())
           throw new IllegalStateException("Empty queue");

       int removedItem = front.data;
       if(front == rear)
           front = rear = null;

       front = front.next;
       rear.next = front;

       return removedItem;
    }

    public void displayQueue() {
        if (isEmpty())
            return;

        var current = front;
        while (current.next != front) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println(current.data);
    }

    private boolean isEmpty() {
        return front == null;
    }

    private class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }
    }
}
