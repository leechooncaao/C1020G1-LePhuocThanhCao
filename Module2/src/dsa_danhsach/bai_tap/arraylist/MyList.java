package dsa_danhsach.bai_tap.arraylist;

public class MyList<E> {
    private static final int DEFAULT_CAPACITY = 2;
    private Object[] items;
    private int count; // count the number of elements in array

    public MyList() {
        items = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        items = new Object[capacity];
    }

    public void clear(){
        items = new Object[DEFAULT_CAPACITY];
        count = 0;
    }

    public E get(int index){
        if(index < 0 || index >= count)
            throw new IllegalArgumentException("Invalid index");

        return  (E) items[index];
    }

    public void ensureCapacity(int minCapacity){
        if(minCapacity < count)
            throw new IllegalArgumentException("Invalid capacity");

        Object[] newItems = new Object[minCapacity];
        System.arraycopy(items, 0, newItems, 0, count);

        items = newItems;
    }

    public boolean add(E element){
        add(count,element);

        return true;
    }

    public int indexOf(E element){
        var index = -1;
        for(int i = 0; i < count; i++)
            if(element.equals(((E) items[i]))){
                index = i;
                break;
            }

        return index;
    }

    public boolean contains(E element) {
        boolean isContain = false;
        for (int i = 0; i < count; i++)
            if (element.equals(((E) items[i]))){
                isContain = true;
                break;
            }

        return isContain;
    }

    public Object[] clone() {
        Object[] newItems = new Object[count];
        System.arraycopy(items, 0, newItems, 0, count);

        return newItems;
    }

    public int size() {
        return count;
    }

    public E remove(int index) {
        if (index < 0 || index >= count)
            throw new IllegalArgumentException("Invalid index");

        E removedItem = (E) items[index];
        // if the removing item is the last item in array else shifting item to the left
        if (index == count - 1)
            items[index] = null;
        else {
            for (int i = index; i < count; i++)
                items[i] = items[i + 1];

            items[count - 1] = null;
        }

        count--;

        return removedItem;
    }

    public void add(int index, E item) {
        if (index == 0 && count == 0) {
            items[0] = item;
            count++;
            return;
        } else if (index < 0 || index > count)
            throw new IllegalArgumentException("Invalid input !");
        else {
            count++;
            if (isFull())
                resize();

            for (int i = count - 1; i > index; i--) {
                items[i] = items[i - 1];
            }

            items[index] = item;
        }
    }

    public void print() {
        if(count == 0)
            return;

        for (int i = 0; i < count; i++)
            System.out.print(items[i] + " ");

        System.out.println();
    }

    private void resize() {
        Object[] newItems = new Object[count + count / 2]; //increment size 50% if current array is full
        System.arraycopy(items, 0, newItems, 0, count);

        items = newItems;
    }

    private boolean isFull() {
        return count == items.length;
    }


}
