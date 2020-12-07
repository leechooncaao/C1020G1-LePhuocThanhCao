package dsa_stack_queue.thuc_hanh.stack;

import java.util.EmptyStackException;
import java.util.LinkedList;

public class MyGenericStack<T> {
    private LinkedList<T> stack;

    public MyGenericStack(){
        stack = new LinkedList<>();
    }

    public void push(T item){
        stack.addFirst(item);
    }

    public T pop(){
        if(isEmpty())
            throw new EmptyStackException();
        return stack.removeFirst();
    }

    public boolean isEmpty(){
        return stack.size() == 0;
    }

    public int size(){
        return stack.size();
    }


}
