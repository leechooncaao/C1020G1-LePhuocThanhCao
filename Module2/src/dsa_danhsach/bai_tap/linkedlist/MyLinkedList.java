package dsa_danhsach.bai_tap.linkedlist;


import java.util.NoSuchElementException;

public class MyLinkedList<E> {
    private Node head;
    private int count; // count the number of elements in linkedList

    public MyLinkedList(){
    }

    public void clear(){
        head = null;
    }

    public E get(int index){
        if(isEmpty() || index < 0 || index >= count)
            throw new IndexOutOfBoundsException("Invalid input");

        var current = head;
        while (index > 0){
            current = current.next;
            index--;
        }

        return (E) current.data;
    }

    public E getFirst(){
        if(isEmpty())
            throw new NoSuchElementException();

        return (E) head.data;
    }

    public E getLast(){
        if(isEmpty())
            throw new NoSuchElementException();

        var current = head;
        while (current.next != null){
            current = current.next;
        }

        return (E) current.data;
    }

    public boolean add(E element){
        add(count,element);

        return true;
    }

    public int indexOf(E element){
        if(isEmpty() || !contains(element))
            return -1;

        return getIndex(element);
    }

    private int getIndex(E element){
        var current = head;
        int index = 0;
        while (current.next != null){
            if(element.equals(((E) current.data)))
                break;

            index++;
            current = current.next;
        }

        return index;
    }

    public int size(){
        return count;
    }

    public boolean remove(Object element){
        if(isEmpty())
            return false;

        var newElement = (E) element;
        if(!contains(newElement))
            return false;

        remove(getIndex(newElement));

        return true;
    }

    public boolean contains(E element){
        if(isEmpty())
            return false;

        var current = head;
        while(current.next != null){
            if(element.equals(((E) current.data)))
                return true;

            current = current.next;
        }

        return false;
    }

    public E remove(int index){
        if(index < 0 || index >= count || isEmpty())
            throw new IndexOutOfBoundsException("Invalid index");

        var current = head;
        while (index -1 > 0){
            current = current.next;
            index--;
        }
        var removedElement = current.next;
        current.next = current.next.next;
        removedElement.next = null;
        count--;

        return (E) removedElement.data;

    }

    public void addFirst(E element){
        var node = new Node(element);

        if(isEmpty()){
            head = node;
            count++;
            return;
        }

        var temp = head;
        node.next = temp;
        head = node;
        count++;
    }

    public void addLast(E element){
        var node = new Node(element);

        if(isEmpty()){
            head = node;
            count++;
            return;
        }

        var current = head;
        while (current.next != null){
            current = current.next;
        }

        current.next = node;
        count++;
    }

    public void add(int index, E element){
        var node = new Node(element);

        if(index == 0){
            addFirst(element);
            return;
        }

        if(index == count){
            addLast(element);
            return;
        }

        if(index < 0 || index > count)
            throw new IllegalArgumentException("Invalid index");

        var current = head;
        while (index - 1 > 0){
            current = current.next;
            index--;
        }
        var temp = current.next;
        current.next = node;
        node.next = temp;

        count++;
    }

    public void print(){
        if(isEmpty())
            return;

        var current = head;
        while (current != null){
            System.out.print(current.data + " ");
            current = current.next;
        }

        System.out.println();
    }

    private boolean isEmpty(){
        return head == null;
    }

    private class Node{
        private Object data;
        private Node next;

        public Node() {
        }

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return data;
        }

        @Override
        public String toString() {
            return data + " ";
        }
    }
}
