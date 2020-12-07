package dsa_stack_queue.bai_tap.trienkhaistack;

import java.util.NoSuchElementException;

public class MyStack {
    private int[] items;
    private int count; // count the number of elements in stack

    public MyStack(){
        items = new int[1]; // stack automatically grows it's length, initial = 1
    }

    public void print(){
        for (int i = 0; i < items.length; i++)
            System.out.print(items[i] + " ");

        System.out.println();
    }

    public void push(int item){
        if(items.length == count){
            int[] newItems = new int[count + 1];
            System.arraycopy(items, 0, newItems, 0, items.length);

            items = newItems;
        }

        items[count++] = item;
    }

    public int pop(){
        if(isEmpty())
            throw new NoSuchElementException();

        var removedItem = items[count -1];

        var newSize = count -1;
        int[] newItems = new int[newSize];
        System.arraycopy(items,0,newItems,0,newSize);

        items = newItems;
        count--;

        return removedItem;
    }

    public int peek(){
        if(isEmpty())
            throw new NoSuchElementException();

        return items[count -1];
    }

    private boolean isEmpty(){
        return count == 0;
    }



}
