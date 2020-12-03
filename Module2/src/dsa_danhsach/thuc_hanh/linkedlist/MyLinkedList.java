package dsa_danhsach.thuc_hanh.linkedlist;

public class MyLinkedList<E> {
    private Node head;
    private int count;

    public MyLinkedList(){
        head = null;
    }

    public void add(int index, E data){
        if(isEmpty()){
            head = new Node(data);
            return;
        }

        var current = head;

        while (current.next != null && index -1 > 0){
            current = current.next;
            index--;
        }

        var temp = current.next;
        current.next = new Node(data);
        current.next.next = temp;
        count++;
    }

    public E get(int index){
        var current = head;
        for(int i = 0; i < index; i++){
            if(current == null){
                throw new IllegalArgumentException("Not found !");
            }
            current = current.next;
        }

        return current.data;
    }

    public void addFirst(E data){
        if(isEmpty()){
            head = new Node(data);
            return;
        }

        var temp = head;
        head = new Node(data);
        head.next = temp;

        count++;
    }

    public void printList(){
        var current = head;
        while (current != null){
            System.out.println(current.data);
            current = current.next;
        }
    }

    private boolean isEmpty() {
        return head == null;
    }

    private class Node{
        private E data;
        private Node next;

        public Node() {
        }

        public Node(E data) {
            this.data = data;
        }

        public E getData() {
            return data;
        }
    }
}
